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
		case "fil":
			filtrarProducto(request, response);
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
		case "eli":
			eliminarProducto(request, response);
			break;
		}
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cantidad = request.getParameter("can");
		try {
			int cantidadInt = Integer.parseInt(cantidad);
			if ( cantidadInt == 0) {
				String mensaje = "Introduzca una cantidad mayor de 0";
				String url = "Ventas/ListaProductoVentaMenu.jsp";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			} else {
				// variables
				String mensaje = null;
				String url = null;
				// entradas

				// procesos
				
				
				super.getSession().getAttribute("carro");
				super.getSession().getAttribute("cantidadDeProducto");
				super.getSession().getAttribute("cantidadDeProducto");
				super.getSession().getAttribute("cantidadDeProducto");

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

				// salidas
				request.setAttribute("lista", lis);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);

			}
		} catch (NumberFormatException e) {
			String mensaje = "Introduzca una cantidad valida";
			String url = "Ventas/ListaProductoVentaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void actualizarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void actualizarProducto1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void filtrarProducto(HttpServletRequest request, HttpServletResponse response) {

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

		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
