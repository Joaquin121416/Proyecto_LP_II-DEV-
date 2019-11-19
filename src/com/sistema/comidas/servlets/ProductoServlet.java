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
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet Producto");
		String opc = request.getParameter("opc");
		switch(opc) {
		case "lis": listarProducto(request,response);break;
		case "fil": filtrarProducto(request,response);break;
		case "reg": registrarProducto(request,response);break;
		case "act": actualizarProducto(request,response);break;
		case "eli": eliminarProducto(request,response);break;
		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro a registrar");
		String mensaje, url;
		String PRO_NOM;
		String PRO_DES;
		double PRO_PRE;
		int CAT_PRO_ID;

		
		PRO_NOM = request.getParameter("txtNombre");
		PRO_DES = request.getParameter("txtDescripcion");
		PRO_PRE = Double.parseDouble(request.getParameter("txtPrecio"));
		CAT_PRO_ID = Integer.parseInt(request.getParameter("txtCategoria"));

		
		ProductoBean p = new ProductoBean();
		p.setPRO_NOM(PRO_NOM);
		p.setPRO_DES(PRO_DES);
		p.setPRO_PRE(PRO_PRE);
		p.setCAT_PRO_ID(CAT_PRO_ID);
		
		System.out.println(p);
		
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		ProductoDAO dao =fabrica.getProductoDAO();
		int ok = dao.registrarProducto(p);
		
		if(ok==0) {
			mensaje = "Error al registrar";
			url = "Productos/AgregarProductoMenu.jsp";
		}else {
			mensaje = "Producto " + p.getPRO_NOM() + " registrado";
			url = "Productos/AgregarProductoMenu.jsp";
		}
		
		request.setAttribute("msg", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void filtrarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
			url = "Productos/ListaProductoMenu.jsp";
		} else {
			mensaje = "";
			url = "Productos/ListaProductoMenu.jsp";
		}

		// salidas
		request.setAttribute("lista", lis);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
