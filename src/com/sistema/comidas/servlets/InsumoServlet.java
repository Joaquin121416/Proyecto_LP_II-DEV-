package com.sistema.comidas.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.presentacion.GenericoMB;

@WebServlet("/InsumoServlet")
public class InsumoServlet extends GenericoMB {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet Producto");
		String opc = request.getParameter("opc");
		switch (opc) {
		case "lis":
			listarInsumo(request, response);
			break;
		case "fil":
			filtrarInsumo(request, response);
			break;
		case "reg":
			registrarInsumo(request, response);
			break;
		case "act":
			actualizarInsumo(request, response);
			break;
		case "eli":
			eliminarInsumo(request, response);
			break;
		}
	}

	private void eliminarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String mensaje = "";

		int cod = Integer.parseInt(request.getParameter("codigo"));

		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = fabrica.getInsumoDAO();
		InsumosBean p = new InsumosBean();
		p.setINS_ID(cod);
		int ok = dao.eliminarInsumo(p);

		if (ok == 0) {
			mensaje = "Error al eliminar";
			url = "Insumos/ListaInsumoMenu.jsp";
		} else {
			mensaje = "Insumo " + p.getINS_NOM() + " eliminado";
			url = "Insumos/ListaInsumoMenu.jsp";
		}

		request.setAttribute("msg", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void actualizarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = String.valueOf(request.getParameter("codigo"));
		int cod = Integer.parseInt(id);
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = (InsumosDAO) bd.getInsumoDAO();
		InsumosBean ins;
		ins = dao.listarByID(cod);
		String url = "Insumos/ActualizarInsumoMenu.jsp";
		request.setAttribute("INS_ID", ins.getINS_ID());
		request.setAttribute("INS_NOM", ins.getINS_NOM());
		request.setAttribute("INS_DES", ins.getINS_DES());
		request.setAttribute("INS_PRE", ins.getINS_PRE());
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void registrarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro a registrar");
		String mensaje, url;
		String INSNOM;
		String INS_DES;
		double INS_PRE;

		INSNOM = request.getParameter("txtNombre");
		INS_DES = request.getParameter("txtDescripcion");
		INS_PRE = Double.parseDouble(request.getParameter("txtPrecio"));

		InsumosBean p = new InsumosBean(0, INS_DES, INS_DES, INS_PRE);
		p.setINS_NOM(INSNOM);
		p.setINS_DES(INS_DES);
		p.setINS_PRE(INS_PRE);

		System.out.println(p);

		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = fabrica.getInsumoDAO();
		int ok = dao.agregarInsumo(p);

		if (ok == 0) {
			mensaje = "Error al registrar Insumo";
			url = "Insumos/AgregarInsumo.jsp";
		} else {
			mensaje = "Insumo " + p.getINS_ID() + " registrado";
			url = "Insumos/AgregarInsumoMenu.jsp";
		}

		request.setAttribute("msg", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void filtrarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "", url;
		int tipo = Integer.parseInt(request.getParameter("cboTipoInsumo"));

		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = fabrica.getInsumoDAO();
		ArrayList<InsumosBean> lista = dao.listarInsumos();

		if (lista.isEmpty()) {
			mensaje = "no se encontraron Insumos  ";
			url = "Insumos/ListaInsumoMenu.jsp";
		} else {
			mensaje = "";
			url = "Insumos/ListaInsumoMenu.jsp";
		}

		// salidas
		request.setAttribute("aviso", mensaje);
		request.setAttribute("listadoins", lista);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void listarInsumo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// variables
		String mensaje = null;
		String url = "Insumos/ListaInsumoMenu.jsp";
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		InsumosDAO dao = bd.getInsumoDAO();
		ArrayList<InsumosBean> lis = null;
		try {
			lis = dao.listarInsumos();
			request.setAttribute("lista", lis);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (NullPointerException e) {

			mensaje = "no se encontraron Insumos que listar";
			url = "Insumos/ListaInsumoMenu.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}

	}
}
