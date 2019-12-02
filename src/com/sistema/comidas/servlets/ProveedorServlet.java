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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarProveedor(request, response);
		} else if (opc.equals("agr")) {
			agregarProveedor(request, response);
		} else if (opc.equals("act")) {
			actualizar(request, response);
		} else if (opc.equals("eli")) {
			eliminar(request, response);
		}

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = String.valueOf(request.getParameter("codigo"));
		int cod = Integer.parseInt(id);
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao = bd.getProveedorDAO();
		ProveedorBean pro = new ProveedorBean();
		pro.setPROV_ID(cod);
		int res = dao.eliminarProveedor(pro);

		String url = "Proveedor/ListaProveedorMenu.jsp";
		// salidas
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao = bd.getProveedorDAO();
		ProveedorBean pro;
		int codi = 0;
		String nombre = (request.getParameter("txtNombre"));
		String ruc = (request.getParameter("txtRuc"));
		String telefono = (request.getParameter("txtTelefono"));
		String est = (request.getParameter("txtestado"));
		String url = "Proveedor/ListaProveedorMenu.jsp";
		String mensaje = "";
		// salidas
		ProveedorBean p = new ProveedorBean();
		p.setPROV_ID(codi);
		p.setPROV_NOM(nombre);
		
		//estos pueden votar error
		
		
		//en serio te demoraste para esto
		p.setPROV_COD_RUC(Integer.parseInt(ruc));
		p.setPROV_NUM_TEL(Integer.parseInt(telefono));
		p.setPROV_ESTADO(Integer.parseInt(est));

		if (nombre.matches("[a-zA-Z]{3,120}") || nombre != "") {
			if (ruc.length() == 12) { //valida que sea numero
				if (telefono.length() > 12) {//valida que sea numero
					int res = dao.agregarProveedor(p);
					if (res == 0) {
						mensaje = "no se pudo insertar el Proveedor";
						url = "Proveedor/AgregarProveedor.jsp";
					} else {
						mensaje = "Proveedor añadido Exitosamente";
						url = "Proveedor/AgregarProveedor.jsp";
					}
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher(url).forward(request, response);
				} else {
					url = "Proveedor/ActualizarProveedor.jsp";
					request.setAttribute("codi", p.getPROV_ID());
					request.setAttribute("nombre", p.getPROV_NOM());
					request.setAttribute("ruc", p.getPROV_COD_RUC());
					request.setAttribute("telefono", p.getPROV_NUM_TEL());
					request.setAttribute("est", p.getPROV_ESTADO());
					request.setAttribute("msg", "Ingrese un id");
					request.getRequestDispatcher(url).forward(request, response);
				}
			} else {
				url = "Proveedor/ActualizarProveedor.jsp";
				request.setAttribute("codi", p.getPROV_ID());
				request.setAttribute("nombre", p.getPROV_NOM());
				request.setAttribute("ruc", p.getPROV_COD_RUC());
				request.setAttribute("telefono", p.getPROV_NUM_TEL());
				request.setAttribute("est", p.getPROV_ESTADO());
				request.setAttribute("msg", "Ingrese un nombre");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} else {
			url = "Proveedor/ActualizarProveedor.jsp";
			request.setAttribute("codi", p.getPROV_ID());
			request.setAttribute("nombre", p.getPROV_NOM());
			request.setAttribute("ruc", p.getPROV_COD_RUC());
			request.setAttribute("telefono", p.getPROV_NUM_TEL());
			request.setAttribute("est", p.getPROV_ESTADO());
			request.setAttribute("msg", "Ingrese un ruc correcto");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void agregarProveedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = null;
		String url;
		int codi = 0;
		String nombre = (request.getParameter("txtNombre"));
		String ruc = (request.getParameter("txtRuc"));
		String telefono = (request.getParameter("txtTelefono"));
		ProveedorBean pro = new ProveedorBean();
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao = bd.getProveedorDAO();
		int res = dao.agregarProveedor(pro);

		ProveedorBean p = new ProveedorBean();
		p.setPROV_ID(codi);
		p.setPROV_NOM(nombre);
		p.setPROV_COD_RUC(Integer.parseInt(ruc));
		p.setPROV_NUM_TEL(Integer.parseInt(telefono));

		if (nombre.matches("[a-zA-Z]{3,120}") || nombre != "") {
			if (ruc.length() > 12) {
				if (telefono.length() > 12) {

					int ok = dao.agregarProveedor(pro);
					if (res == 0) {
						mensaje = "no se pudo insertar el Proveedor";
						url = "Proveedor/AgregarProveedor.jsp";
					} else {
						mensaje = "Proveedor añadido Exitosamente";
						url = "Proveedor/AgregarProveedor.jsp";
					}
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher(url).forward(request, response);
				} else {
					url = "Proveedor/AgregarProveedor.jsp";
					request.setAttribute("msg", "Ingrese una Id");
					request.getRequestDispatcher(url).forward(request, response);
				}
			} else {
				url = "Proveedor/AgregarProveedor.jsp";
				request.setAttribute("msg", "Ingrese un Nombre");
				request.getRequestDispatcher(url).forward(request, response);
			}
		} else {
			url = "Proveedor/AgregarProveedor.jsp";
			request.setAttribute("msg", "Ingrese Ruc con menos de 11 dijitos");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void listarProveedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// variables
		String mensaje = null;
		String url = null;
		// entradas

		// procesos
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ProveedorDAO dao = bd.getProveedorDAO();
		ArrayList<ProveedorBean> lis;
		lis = dao.listarProveedor();

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
