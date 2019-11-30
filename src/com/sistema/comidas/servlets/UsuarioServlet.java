package com.sistema.comidas.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;
import com.sistema.comidas.util.Net;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends GenericoMB {
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
		String rol = request.getParameter("rol");
		String usu = request.getParameter("usu");
		String tipDoc = request.getParameter("tipDoc");
		String ape = request.getParameter("ape");
		String img = request.getParameter("img");
		String pwd = request.getParameter("pwd");
		String doc = request.getParameter("doc");
		String audIp = Net.getClientIPAddres(request);
		// procesos
		File file = new File(img);
		UsuarioBean user = new UsuarioBean();
		user.setNombre(nombre);
		user.setApellido(ape);
		user.setUsuario(usu);
		user.setUsu_img(file);
		user.setClave(pwd);
		user.setTip_doc_id(Integer.parseInt(tipDoc));
		user.setUsu_rol_id(Integer.parseInt(rol));
		user.setUsuario_id(0);
		if (doc.isEmpty() || doc.equals("")) {
			url = "Usuario/AgregarUsuarioMenu.jsp";
			request.setAttribute("mensaje", "Ingrese El numero de Documento");
			request.getRequestDispatcher(url).forward(request, response);			
		}else {
		user.setUsu_doc(Integer.parseInt(doc));
		user.setAud_ip(audIp);

		// llamar al Factory para insertar
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		UsuarioDAO dao = bd.getUsuarioDAO();
		int res = dao.agregarUsuario(user);
		System.err.println(res);
		if (res == 0) {
			mensaje = "no se pudo insertar el registro";
			url = "Usuario/AgregarUsuarioMenu.jsp";
		} else {
			mensaje = "categoria añadida";
			url = "Usuario/AgregarUsuarioMenu.jsp";
		}

		// salidas
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		}
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
		UsuarioDAO dao = bd.getUsuarioDAO();
		ArrayList<UsuarioBean> lis;
		lis = dao.listarUsuario();

		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos";
			url = "Usuario/ListaUsuarioMenu.jsp";
		} else {
			mensaje = "";
			url = "Usuario/ListaUsuarioMenu.jsp";
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
		UsuarioDAO dao = bd.getUsuarioDAO();
		UsuarioBean usuario;
		usuario = dao.listarByID(cod);

		String url = "Usuario/ModificarUsuarioMenu.jsp";
		// salidas
		request.setAttribute("cod", usuario.getUsuario_id());
		request.setAttribute("nom", usuario.getNombre());
		request.setAttribute("ape", usuario.getApellido());
		request.setAttribute("docIde", usuario.getUsu_doc());
		request.setAttribute("usu", usuario.getUsuario());
		request.setAttribute("val", usuario.getTip_doc_id());
		request.setAttribute("rol", usuario.getUsu_rol_id());
		
		
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
