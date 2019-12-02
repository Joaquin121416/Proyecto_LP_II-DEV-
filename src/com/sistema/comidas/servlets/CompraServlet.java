package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.DetalleCompraBean;
import com.sistema.comidas.bean.DetalleVentaBean;
import com.sistema.comidas.bean.DocumentoCompraBean;
import com.sistema.comidas.bean.DocumentoVentaBean;
import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.VentaDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "CompraServlet", urlPatterns = { "/CompraServlet" })
public class CompraServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet CompraServlet");
		String opc = request.getParameter("opc");
		switch (opc) {
		case "lis":
			listarInsumo(request, response);
			break;
		case "reaven":
			realizarVenta(request, response);
			break;
		case "reg":
			registrarProducto(request, response);
			break;
		case "ven":
			agregarProducto(request, response);
			break;
		case "act1":
			actualizarProducto1(request, response);
			break;
		case "act2":
			actualizarProducto2(request, response);
			break;
		case "lim":
			limpiarTodo(request, response);
			break;
		}
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = bd.getInsumoDAO();
		// variables
		String mensaje = null;
		String url = null;
		try {
			InsumosBean pro = dao.listarByID(Integer.parseInt(request.getParameter("cod").trim()));
			String cantidad = request.getParameter("can");
			String cod = request.getParameter("cod");

			// entradas
			ArrayList<DetalleCompraBean> carroCompra = new ArrayList<DetalleCompraBean>();
			// procesos
			try {
				carroCompra = (ArrayList<DetalleCompraBean>) request.getSession().getAttribute("carroCompra");
				if (carroCompra.isEmpty()) {
					carroCompra = new ArrayList<DetalleCompraBean>();
				}
			} catch (Exception e) {
				carroCompra = new ArrayList<DetalleCompraBean>();
			}
			try {
				int cant = Integer.parseInt(cantidad);
				DetalleCompraBean detalleVentaBean = new DetalleCompraBean();
				detalleVentaBean.setDOC_COM_ID((Integer) 0);
				detalleVentaBean.setDet_doc_ven_pre(pro.getINS_PRE());
				detalleVentaBean.setDet_doc_ven_can(cant);
				detalleVentaBean.setDOC_COM_ID((Integer) 0);
				detalleVentaBean.setIgv(0.18);
				detalleVentaBean.setIns_id(pro.getINS_ID());

				carroCompra.add(detalleVentaBean);

				System.out.println();
				request.getSession().setAttribute("carroCompra", carroCompra);
				ArrayList<InsumosBean> lisProVen = (ArrayList<InsumosBean>) request.getSession()
						.getAttribute("carroCTC");
				lisProVen.add(pro);
				request.getSession().setAttribute("carroCTC", lisProVen);

				// llamar al Factory para insertar
				ArrayList<InsumosBean> lis;
				lis = dao.listarInsumos();

				if (lis.isEmpty()) {
					mensaje = "no se encontraron datos";
					url = "/CompraServlet?opc=lis";
				} else {
					mensaje = "agregado";
					url = "Compras/ListaInsumoCompraMenu.jsp";
				}

				// salidas
				request.setAttribute("lista", lis);
				request.setAttribute("mensaje", mensaje);
				double subtotal = (double) request.getSession().getAttribute("subtotalCompra");
				request.getSession().setAttribute("subtotalCompra", subtotal + pro.getINS_PRE()*cant);
				double Total = (double) request.getSession().getAttribute("totalCompra");
				request.getSession().setAttribute("totalCompra",
						(double) request.getSession().getAttribute("subtotalCompra")
								+ (double) request.getSession().getAttribute("subtotalCompra") * 0.18);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				mensaje = "Ingrese una cantidad valida";
				url = "/CompraServlet?opc=lis";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "error";
			url = "/CompraServlet?opc=lis";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void actualizarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void limpiarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<DetalleVentaBean> carroCompra = new ArrayList<DetalleVentaBean>();
		request.getSession().setAttribute("carroCompra", carroCompra);
		ArrayList<ProductoBean> lisProVen = new ArrayList<ProductoBean>();
		request.getSession().setAttribute("carroCTC", lisProVen);
		request.getSession().setAttribute("subtotalCompra", 0.0);
		request.getSession().setAttribute("totalCompra", 0.0);
		String mensaje = "no se encontraron datos";
		String url = "/CompraServlet?opc=lis";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizarProducto1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
	}

	private void realizarVenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensaje = null;
		String url = null;
		int res;
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		VentaDAO dao = bd.getVentaDAO();
		GenericoDAO daoGen = bd.getGenericoDAO();
		if (!(request.getParameter("clicod").equals(""))) {
			try {

				int codcli = Integer.parseInt(request.getParameter("clicod"));
				if (daoGen.existe(codcli, "TB_PROVEEDOR", "PROV_ID") > 0) {
					DocumentoCompraBean doc = new DocumentoCompraBean();
					doc.setCli_id(codcli);
					doc.setUsu_id((int) request.getSession().getAttribute("codUsu"));
					doc.setDoc_ven_tot((double) request.getSession().getAttribute("totalCompra"));
					res = dao.RealizarCompra(
							(ArrayList<DetalleCompraBean>) request.getSession().getAttribute("carroCompra"), doc);
					if (res > 0) {
						mensaje = "La compra fue exitosa";
						url = "Compras/ListaInsumoCompraMenu.jsp";
						request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher(url).forward(request, response);
					}
				} else {

					mensaje = "El proveedor ingresado no existe";
					url = "Compras/ListaInsumoCompraMenu.jsp";
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher(url).forward(request, response);
				}
			} catch (Exception e) {
				mensaje = "ingrese un cod de proveedor numero";
				url = "Compras/ListaInsumoCompraMenu.jsp";

				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			}
		}

	}

	private void listarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = bd.getInsumoDAO();
		ArrayList<InsumosBean> lis = new ArrayList<InsumosBean>();
		try {
			lis = dao.listarInsumos();

			if (lis.isEmpty()) {
				mensaje = "no se encontraron datos";
				url = "Compras/ListaInsumoCompraMenu.jsp";
			} else {
				mensaje = "";
				url = "Compras/ListaInsumoCompraMenu.jsp";
			}
			request.setAttribute("lista", lis);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
			try {
				ArrayList<InsumosBean> listaCarro = (ArrayList<InsumosBean>) super.getSession()
						.getAttribute("carroCTC");
				request.setAttribute("miCarro", listaCarro);
				request.getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
			url = "Compras/ListaInsumoCompraMenu.jsp";

			request.setAttribute("lista", lis);
			request.setAttribute("mensaje", "No se encontro ningun Insumo");

		}

	}

}
