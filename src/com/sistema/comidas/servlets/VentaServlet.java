package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.DetalleVentaBean;
import com.sistema.comidas.bean.DocumentoVentaBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.VentaDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "VentaServlet", urlPatterns = { "/VentaServlet" })
public class VentaServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet VentaServlet");
		String opc = request.getParameter("opc");
		switch (opc) {
		case "lis":
			listarProducto(request, response);
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
		ProductoDAO dao = bd.getProductoDAO();
		ProductoBean pro = dao.listarByID(Integer.parseInt(request.getParameter("codigo")));
		String cantidad = request.getParameter("can");

		// variables
		String mensaje = null;
		String url = null;
		// entradas
		ArrayList<DetalleVentaBean> carroCompra = new ArrayList<DetalleVentaBean>();
		// procesos
		try {
			carroCompra = (ArrayList<DetalleVentaBean>) request.getSession().getAttribute("carros");
			if (carroCompra.isEmpty()) {
				carroCompra = new ArrayList<DetalleVentaBean>();
			}
		} catch (Exception e) {
			carroCompra = new ArrayList<DetalleVentaBean>();
		}

		DetalleVentaBean detalleVentaBean = new DetalleVentaBean();
		detalleVentaBean.setDet_doc_ven_id((Integer) 0);
		detalleVentaBean.setDet_doc_ven_pre(pro.getPRO_PRE());
		detalleVentaBean.setDet_doc_ven_can(1);
		detalleVentaBean.setDoc_ven_id((Integer) 0);
		detalleVentaBean.setIgv(0.18);
		detalleVentaBean.setPro_id(pro.getPRO_ID());

		carroCompra.add(detalleVentaBean);

		System.out.println();
		request.getSession().setAttribute("carros", carroCompra);
		ArrayList<ProductoBean> lisProVen = (ArrayList<ProductoBean>) request.getSession().getAttribute("carroCT");
		lisProVen.add(pro);
		request.getSession().setAttribute("carroCT", lisProVen);

		// llamar al Factory para insertar
		ArrayList<ProductoBean> lis;
		lis = dao.listarProductosVenta();

		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "/VentaServlet?opc=lis";
		} else {
			mensaje = "agregado";
			url = "Ventas/ListaProductoVentaMenu.jsp";
		}

		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		double subtotal = (double) request.getSession().getAttribute("subtotalVenta");
		request.getSession().setAttribute("subtotalVenta", subtotal + pro.getPRO_PRE());
		double Total = (double) request.getSession().getAttribute("totalVenta");
		request.getSession().setAttribute("totalVenta", (double) request.getSession().getAttribute("subtotalVenta")
				+ (double) request.getSession().getAttribute("subtotalVenta") * 0.18);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void limpiarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<DetalleVentaBean> carroCompra = new ArrayList<DetalleVentaBean>();
		request.getSession().setAttribute("carros", carroCompra);
		ArrayList<ProductoBean> lisProVen = new ArrayList<ProductoBean>();
		request.getSession().setAttribute("carroCT", lisProVen);
		request.getSession().setAttribute("subtotalVenta", 0.0);
		request.getSession().setAttribute("totalVenta", 0.0);
		String mensaje = "no se encontraron datos";
		String url = "/VentaServlet?opc=lis";
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
				if (daoGen.existe(codcli, "TB_CLIENTE", "CLI_ID") > 0) {
					DocumentoVentaBean doc = new DocumentoVentaBean();
					doc.setCli_id(codcli);
					doc.setUsu_id((int) request.getSession().getAttribute("codUsu"));
					doc.setDoc_ven_tot((double) request.getSession().getAttribute("totalVenta"));
					res = dao.RealizarVenta((ArrayList<DetalleVentaBean>) request.getSession().getAttribute("carros"),
							doc);
					if (res > 0) {
						mensaje = "La venta fue exitosa";
						url = "Ventas/ListaProductoVentaMenu.jsp";
						request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher(url).forward(request, response);
					}
				} else {

					mensaje = "El cliente ingresado no existe";
					url = "Ventas/ListaProductoVentaMenu.jsp";
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher(url).forward(request, response);
				}
			} catch (Exception e) {
				mensaje = "ingrese un cod de cliente numero";
				url = "Ventas/ListaProductoVentaMenu.jsp";

				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			}
		}

	}

	private void listarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao = bd.getProductoDAO();
		ArrayList<ProductoBean> lis;
		lis = dao.listarProductosVenta();

		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "Ventas/ListaProductoVentaMenu.jsp";
		} else {
			mensaje = "";
			url = "Ventas/ListaProductoVentaMenu.jsp";
		}
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		try {
			ArrayList<ProductoBean> listaCarro = (ArrayList<ProductoBean>) super.getSession().getAttribute("carro");
			request.setAttribute("miCarro", listaCarro);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

}
