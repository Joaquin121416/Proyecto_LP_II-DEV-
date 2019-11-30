package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProveedorBean;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.ProveedorDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;

/**
 * Servlet implementation class ProveedorServlet
 */
@WebServlet(description = "ProveedorServlet", urlPatterns = { "/ProveedorServlet" })
public class ProveedorServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarProveedor(request,response);
		} else if (opc.equals("agr")) {
			agregarProveedor(request,response);
	}

}

	private void agregarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = null;
		String url;
		String nombre = (request.getParameter("nom"));
		String descripcion = (request.getParameter("des"));
		ProveedorBean pro = new ProveedorBean();
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao =bd.getProveedorDAO();
		int res = dao.agregarProveedor(pro);
		if (res==0) {
			mensaje = "no se pudo insertar el Proveedor";
			url = "Proveedor/AgregarProveedor.jsp";
		} else {
			mensaje = "Proveedor añadido Exitosamente";
			url = "Proveedor/AgregarProveedor.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void listarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos

		
		

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao =bd.getProveedorDAO();
		ArrayList<ProveedorBean> lis;
		lis=dao.listarProveedor();
		
		if (lis.isEmpty()) {
			mensaje = "no se encontraron datos que listar";
			url = "Proveedor/AgregarProveedor.jsp";
		} else {
			mensaje = "";
			url = "Proveedor/AgregarProveedor.jsp";
		}
		
		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	
	}
		
	}

