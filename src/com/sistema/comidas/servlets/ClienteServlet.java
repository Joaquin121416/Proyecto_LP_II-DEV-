package com.sistema.comidas.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.presentacion.GenericoMB;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opc = request.getParameter("opc");
		if (opc == "lis") {

		} else if (opc == "agr") {

		} else if (opc == "act") {

		} else if (opc == "eli") {

		} else if (opc == "ing") {

		}

	}

}
