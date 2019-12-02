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
@WebServlet(name = "ReporteServlet", urlPatterns = { "/ReporteServlet" })
public class ReporteServlet extends GenericoMB {
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
		case "agr":
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
			throws ServletException, IOException {}

	private void actualizarProducto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void limpiarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void actualizarProducto1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao = bd.getGenericoDAO();
		String lis;
		lis = dao.consultarCompras();
		String lis2;
		lis2 = dao.consultarCantidadCompras();
		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "Reportes/ReporteInsumoCompraMenu.jsp";
		} else {
			mensaje = "";
			url = "Reportes/ReporteInsumoCompraMenu.jsp";
		}
		request.setAttribute("ventas", lis);
		request.setAttribute("cantidad", lis2);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	
	}

	private void realizarVenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}

	private void listarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao = bd.getGenericoDAO();
		String lis;
		lis = dao.consultarVentas();
		String lis2;
		lis2 = dao.consultarCantidadVentas();
		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "Reportes/ReporteProductoVentaMenu.jsp";
		} else {
			mensaje = "";
			url = "Reportes/ReporteProductoVentaMenu.jsp";
		}
		request.setAttribute("ventas", lis);
		request.setAttribute("cantidad", lis2);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);


	}

}
