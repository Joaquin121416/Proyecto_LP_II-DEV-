package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.factory.Factory;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarUsuario(request, response);
		} else if (opc.equals("agr")) {
			agregarUsuario(request, response);
		} else if (opc.equals("act1")) {
			actualizar1(request, response);
		} else if (opc.equals("eli")) {
			eliminar(request, response);
		} else if (opc.equals("act2")) {
			actualizar2(request, response);
		}

	}
	
	protected void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url;
		// entradas
		String nombre = (request.getParameter("nom"));
		String descripcion = (request.getParameter("des"));
		// procesos

		CategoriaProductoBean cat = new CategoriaProductoBean(0, nombre, descripcion, null);

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		int res = dao.agregarCategoria(cat);
		if (res == 0) {
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

	protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		ArrayList<CategoriaProductoBean> lis;
		lis = dao.listarCategoria();

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


	protected void actualizar1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = String.valueOf(request.getParameter("codigo"));
		int cod = Integer.parseInt(id);
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		CategoriaProductoBean cat;
		cat = dao.listarByID(cod);

		String url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
		// salidas
		request.setAttribute("cod", cat.getCat_pro_id());
		request.setAttribute("nom", cat.getCat_pro_nom());
		request.setAttribute("des", cat.getCat_pro_des());
		request.getRequestDispatcher(url).forward(request, response);

	}

	protected void actualizar2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		CategoriaProductoBean cat;
		String nom = (String) request.getParameter("nom");
		String des = (String) request.getParameter("des");
		String url = "CategoriasProductos/ListaCategoriaMenu.jsp";
		// salidas
		String codi=(String) request.getParameter("cod");
		int cod = Integer.parseInt(codi);
		
		
		cat = new CategoriaProductoBean();
		cat.setCat_pro_id(cod);
		cat.setCat_pro_des(des);
		cat.setCat_pro_nom(nom);
		int res = dao.modificarCategoria(cat);
		if (res != 0) {
			request.getRequestDispatcher(url).forward(request, response);
		}else {
			
		}

	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = String.valueOf(request.getParameter("codigo"));
		int cod = Integer.parseInt(id);
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		CategoriaProductoBean cat = new CategoriaProductoBean();
		cat.setCat_pro_id(cod);
		int res = dao.eliminarCategoria(cat);

		String url = "CategoriasProductos/ListaCategoriaMenu.jsp";
		// salidas
		request.getRequestDispatcher(url).forward(request, response);

	}


}
