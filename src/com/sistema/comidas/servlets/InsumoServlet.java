package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.factory.Factory;

/**
 * Servlet implementation class InsumoServlet
 */
@WebServlet("/InsumoServlet")
public class InsumoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String opc = request.getParameter("opc");
		if (opc.equals("lis")) {
			listarInsumo(request,response);
		} else if (opc.equals("agr")) {
			agregarInsumo(request,response);
		} else if (opc == "act") {
			
		} else if (opc == "eli") {

		} else if (opc == "ing") {

		}

	
	}

	private void agregarInsumo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String mensaje = null;
				String url;
				String nombre = (request.getParameter("nom"));
				String descripcion = (request.getParameter("des"));
				InsumosBean ins = new InsumosBean();
				Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
				InsumosDAO dao =bd.getInsumoDAO();
				int res = dao.agregarInsumo(ins);
				if (res==0) {
					mensaje = "no se pudo insertar el registro";
					url = "insumos/AgregarInsumo.jsp";
				} else {
					mensaje = "Insumo añadido Exitosamente";
					url = "insumos/AgregarInsumoMenu.jsp";
				}
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			}
	private void listarInsumo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// variables
				String mensaje = null;
				String url = null;
				// entradas

				// procesos

				
				

				Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
				InsumosDAO dao =bd.getInsumoDAO();
				ArrayList<InsumosDAO> lis;
				lis=dao.listarInsumos();
				
				if (lis.isEmpty()) {
					mensaje = "no se encontraron datos que listar";
					url = "Insumos/ListaInsumosMenu.jsp";
				} else {
					mensaje = "";
					url = "Insumos/ListaInsumosMenu.jsp";
				}
				
				// salidas
				request.setAttribute("lista", lis);
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher(url).forward(request, response);
			
			}
}
