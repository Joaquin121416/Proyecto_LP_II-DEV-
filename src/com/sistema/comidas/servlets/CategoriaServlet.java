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
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;
import com.sistema.comidas.util.Wrapper;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet(name = "CategoriaServlet", urlPatterns = "/CategoriaServlet")
public class CategoriaServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarCategoria(request, response);
		} else if (opc.equals("agr")) {
			agregarCategoria(request, response);
		} else if (opc.equals("act1")) {
			actualizar1(request, response);
		} else if (opc.equals("eli")) {
			eliminar(request, response);
		} else if (opc.equals("act2")) {
			actualizar2(request, response);
		}

	}

	protected void agregarCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// variables
		String mensaje = null;
		String url;
		// entradas
		String nombre = (request.getParameter("nom"));
		String descripcion = (request.getParameter("des"));
		// procesos
		if (nombre.isEmpty() || nombre.equals("")) {
			mensaje = "Ingrese el Nombre";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (nombre.length() < 5 || nombre.length() > 70) {
			mensaje = "Ingrese un nombre que tenga entre 5 y 70 caracteres";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (descripcion.isEmpty() || descripcion.equals("")) {
			mensaje = "Ingrese la descripcion ";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (descripcion.length() < 5 || descripcion.length() > 140) {
			mensaje = "Ingrese una descripcion que tenga entre 5 y 140 caracteres";
			url = "CategoriasProductos/AgregarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else {

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

	}

	protected void listarCategoria(HttpServletRequest request, HttpServletResponse response)
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
		String mensaje = null;
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		CategoriaDAO dao = bd.getCategoriaDAO();
		CategoriaProductoBean cat;
		String nom = (String) request.getParameter("nom");
		String des = (String) request.getParameter("des");
		String url = "CategoriasProductos/ListaCategoriaMenu.jsp";
		// salidas
		String codi = (String) request.getParameter("cod");
		if (nom.isEmpty() || nom.equals("")) {
			mensaje = "Ingrese el Nombre";
			url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
			request.setAttribute("cod", codi);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (nom.length() < 5 || nom.length() > 70) {
			mensaje = "Ingrese un nombre que tenga entre 5 y 70 caracteres";
			url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
			request.setAttribute("cod", codi);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (des.isEmpty() || des.equals("")) {
			mensaje = "Ingrese la descripcion ";
			request.setAttribute("cod", codi);
			url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else if (des.length() < 5 || des.length() > 140) {
			request.setAttribute("cod", codi);
			mensaje = "Ingrese una descripcion que tenga entre 5 y 140 caracteres";
			url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			int cod = Integer.parseInt(codi);
			cat = new CategoriaProductoBean();
			cat.setCat_pro_id(cod);
			cat.setCat_pro_des(des);
			cat.setCat_pro_nom(nom);
			int res = dao.modificarCategoria(cat);
			if (res != 0) {
				request.setAttribute("cod", codi);
				request.setAttribute("nom", nom);
				request.setAttribute("des", des);		
				mensaje = "Se pudo actualizar el registro con exito";
				request.setAttribute("mensaje", mensaje);
				url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			} else {
				request.setAttribute("cod", codi);
				mensaje = "No se pudo actualizar el registro";
				request.setAttribute("mensaje", mensaje);
				url = "CategoriasProductos/ActualizarCategoriaMenu.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}
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

		String url = "CategoriaServlet?opc=lis";
		// salidas
		request.getRequestDispatcher(url).forward(request, response);

	}

}
