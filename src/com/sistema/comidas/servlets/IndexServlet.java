package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.factory.Factory;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "crudIndex", urlPatterns = { "/crudIndex" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet Producto");
		String opc = request.getParameter("opc");
		switch (opc) {
		case "lis":
			listarProducto(request, response);
			break;
		}
	}

	private void listarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			url = "Index.jsp";
		} else {
			mensaje = "";
			url = "Index.jsp";
		}

		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
