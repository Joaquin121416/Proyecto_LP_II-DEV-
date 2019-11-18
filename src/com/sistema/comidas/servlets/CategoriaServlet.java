package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProducto;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet(name = "CategoriaServlet" ,urlPatterns = "/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarCategoria(request,response);
		} else if (opc.equals("agr")) {
			agregarCategoria(request,response);
		} else if (opc == "act") {
			
		} else if (opc == "eli") {

		} else if (opc == "ing") {

		}

	
	}
	
	protected void agregarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url;
		// entradas
		String nombre = (request.getParameter("nom"));
		String descripcion = (request.getParameter("des"));
		// procesos
		
		CategoriaProducto cat = new CategoriaProducto(0, nombre, descripcion,null);
		
		
		//llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao =bd.getCategoriaDAO();
		int res = dao.agregarCategoria(cat);
		if (res==0) {
			mensaje = "no se pudo insertar el registro";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
		} else {
			mensaje = "categoria añadida";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
		}
		
		// salidas
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	
	}
	
	
	protected void listarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		
		
		//llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao =bd.getCategoriaDAO();
		ArrayList<CategoriaProducto> lis;
		lis=dao.listarCategoria();
		
		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "CategoriasProductos/ListaCategoriaMenu.jsp";
		} else {
			mensaje = "";
			url = "CategoriasProductos/ListaCategoriaMenu.jsp";
		}
		
		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	
	}
	

}
