package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;

import sun.invoke.empty.Empty;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "crudProducto", urlPatterns = { "/crudProducto" })
public class ProductoServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet Producto");
		String opc = request.getParameter("opc");
		switch (opc) {
		case "lis":
			listarProducto(request, response);
			break;
		case "fil":
			filtrarProducto(request, response);
			break;
		case "reg":
			registrarProducto(request, response);
			break;
		case "act1":
			actualizarProducto1(request, response);
			break;
		case "act2":
			actualizarProducto2(request, response);
			break;
		case "eli":
			eliminarProducto(request, response);
			break;
		}
	}

	private void actualizarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String mensaje = "";
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		String pre = request.getParameter("txtPrecio");
		int codi = Integer.parseInt(request.getParameter("txtCodigo"));
		String nom = request.getParameter("txtNombre");
		String des = request.getParameter("txtDescripcion");
		String est = request.getParameter("txtEstado");
		int cat = Integer.parseInt(request.getParameter("cboCategoria"));

		ProductoBean p = new ProductoBean();
		p.setPRO_ID(codi);
		p.setPRO_NOM(nom);
		p.setPRO_DES(des);
		p.setPRO_EST(est);
		p.setCAT_PRO_ID(cat);
		try {
			p.setPRO_PRE(Double.parseDouble(pre));
		} catch (Exception e) {
			mensaje = "Insertar un Precio correcto";
			url = "Productos/ListaProductoMenu.jsp";

			request.setAttribute("msg", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}

		if (pre.matches("\\d+(\\.\\d{1,2})?")) {

			if (nom.matches("[a-zA-Z]{3,120}") || nom != "") {
				if (des.matches("[a-zA-Z]{3,160}") || des != "") {
					if (cat >= 1) {

						int ok = dao.actualizarProducto(p);
						if (ok == 0) {
							mensaje = "Error al actualziar";
							url = "Productos/ListaProductoMenu.jsp";
						} else {
							mensaje = "Producto " + p.getPRO_NOM() + " actualizado";
							url = "Productos/ListaProductoMenu.jsp";
						}

						request.setAttribute("msg", mensaje);
						request.getRequestDispatcher(url).forward(request, response);

					} else {
						url = "Productos/ActualizarProductoMenu.jsp";
						request.setAttribute("cod", p.getPRO_ID());
						request.setAttribute("nom", p.getPRO_NOM());
						request.setAttribute("des", p.getPRO_DES());
						request.setAttribute("pre", p.getPRO_PRE());
						request.setAttribute("est", p.getPRO_EST());
						request.setAttribute("cat", p.getCAT_PRO_ID());
						request.setAttribute("msg", "Ingrese una categoria");
						request.getRequestDispatcher(url).forward(request, response);
					}
				} else {
					url = "Productos/ActualizarProductoMenu.jsp";
					request.setAttribute("cod", p.getPRO_ID());
					request.setAttribute("nom", p.getPRO_NOM());
					request.setAttribute("des", p.getPRO_DES());
					request.setAttribute("pre", p.getPRO_PRE());
					request.setAttribute("est", p.getPRO_EST());
					request.setAttribute("cat", p.getCAT_PRO_ID());
					request.setAttribute("msg", "Ingrese una descripcion correcta");
					request.getRequestDispatcher(url).forward(request, response);
				}
			} else {
				url = "Productos/ActualizarProductoMenu.jsp";
				request.setAttribute("cod", p.getPRO_ID());
				request.setAttribute("nom", p.getPRO_NOM());
				request.setAttribute("des", p.getPRO_DES());
				request.setAttribute("pre", p.getPRO_PRE());
				request.setAttribute("est", p.getPRO_EST());
				request.setAttribute("cat", p.getCAT_PRO_ID());
				request.setAttribute("msg", "Ingrese un nombre correcto");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} else {
			url = "Productos/ActualizarProductoMenu.jsp";
			request.setAttribute("cod", p.getPRO_ID());
			request.setAttribute("nom", p.getPRO_NOM());
			request.setAttribute("des", p.getPRO_DES());
			request.setAttribute("pre", p.getPRO_PRE());
			request.setAttribute("est", p.getPRO_EST());
			request.setAttribute("cat", p.getCAT_PRO_ID());
			request.setAttribute("msg", "Ingrese precio con formato xxx.00");
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String mensaje = "";

		int cod = Integer.parseInt(request.getParameter("codigo"));

		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		ProductoBean p = new ProductoBean();
		p.setPRO_ID(cod);
		int ok = dao.eliminarProducto(p);

		if (ok == 0) {
			mensaje = "Error al eliminar";
			url = "Productos/ListaProductoMenu.jsp";
		} else {
			mensaje = "Producto " + p.getPRO_NOM() + " eleminado";
			url = "Productos/ListaProductoMenu.jsp";
		}

		request.setAttribute("msg", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizarProducto1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = String.valueOf(request.getParameter("codigo"));
		int cod = Integer.parseInt(id);
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		ProductoBean pro;
		pro = dao.listarByID(cod);

		String url = "Productos/ActualizarProductoMenu.jsp";
		// salidas
		request.setAttribute("cod", pro.getPRO_ID());
		request.setAttribute("nom", pro.getPRO_NOM());
		request.setAttribute("des", pro.getPRO_DES());
		request.setAttribute("pre", pro.getPRO_PRE());
		request.setAttribute("est", pro.getPRO_EST());
		request.setAttribute("cat", pro.getCAT_PRO_ID());
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro a registrar");
		String url = "";
		String mensaje = "";
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		String pre = request.getParameter("txtPrecio");
		int codi = 0;
		String nom = request.getParameter("txtNombre");
		String des = request.getParameter("txtDescripcion");
		int cat = Integer.parseInt(request.getParameter("cboCategoria"));

		ProductoBean p = new ProductoBean();
		p.setPRO_ID(codi);
		p.setPRO_NOM(nom);
		p.setPRO_DES(des);
		p.setCAT_PRO_ID(cat);
		try {
			p.setPRO_PRE(Double.parseDouble(pre));
		} catch (Exception e) {
			mensaje = "Insertar un Precio correcto";
			url = "Productos/ListaProductoMenu.jsp";

			request.setAttribute("msg", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}

		if (pre.matches("\\d+(\\.\\d{1,2})?")) {
			if (nom.matches("[a-zA-Z]{3,120}") || nom != "") {
				if (des.matches("[a-zA-Z]{3,160}") || des != "") {
					if (cat >= 1) {

						int ok = dao.registrarProducto(p);
						if (ok == 0) {
							mensaje = "Error al registrar";
							url = "Productos/AgregarProductoMenu.jsp";
						} else {
							mensaje = "Producto " + p.getPRO_NOM() + " agregado";
							url = "Productos/AgregarProductoMenu.jsp";
						}

						request.setAttribute("msg", mensaje);
						request.getRequestDispatcher(url).forward(request, response);

					} else {
						url = "Productos/AgregarProductoMenu.jsp";
						request.setAttribute("cod", p.getPRO_ID());
						request.setAttribute("nom", p.getPRO_NOM());
						request.setAttribute("des", p.getPRO_DES());
						request.setAttribute("pre", p.getPRO_PRE());
						request.setAttribute("est", p.getPRO_EST());
						request.setAttribute("cat", p.getCAT_PRO_ID());
						request.setAttribute("msg", "Ingrese una categoria");
						request.getRequestDispatcher(url).forward(request, response);
					}
				} else {
					url = "Productos/AgregarProductoMenu.jsp";
					request.setAttribute("cod", p.getPRO_ID());
					request.setAttribute("nom", p.getPRO_NOM());
					request.setAttribute("des", p.getPRO_DES());
					request.setAttribute("pre", p.getPRO_PRE());
					request.setAttribute("est", p.getPRO_EST());
					request.setAttribute("cat", p.getCAT_PRO_ID());
					request.setAttribute("msg", "Ingrese una descripcion correcta");
					request.getRequestDispatcher(url).forward(request, response);
				}
			} else {
				url = "Productos/AgregarProductoMenu.jsp";
				request.setAttribute("cod", p.getPRO_ID());
				request.setAttribute("nom", p.getPRO_NOM());
				request.setAttribute("des", p.getPRO_DES());
				request.setAttribute("pre", p.getPRO_PRE());
				request.setAttribute("est", p.getPRO_EST());
				request.setAttribute("cat", p.getCAT_PRO_ID());
				request.setAttribute("msg", "Ingrese un nombre correcto");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} else {
			url = "Productos/AgregarProductoMenu.jsp";
			request.setAttribute("cod", p.getPRO_ID());
			request.setAttribute("nom", p.getPRO_NOM());
			request.setAttribute("des", p.getPRO_DES());
			request.setAttribute("pre", p.getPRO_PRE());
			request.setAttribute("est", p.getPRO_EST());
			request.setAttribute("cat", p.getCAT_PRO_ID());
			request.setAttribute("msg", "Ingrese precio con formato xxx.00");
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void filtrarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

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
		lis = dao.listarProductos();

		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "Productos/ListaProductoMenu.jsp";
		} else {
			mensaje = "";
			url = "Productos/ListaProductoMenu.jsp";
		}

		// salidas
		request.setAttribute("listaProducto", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
