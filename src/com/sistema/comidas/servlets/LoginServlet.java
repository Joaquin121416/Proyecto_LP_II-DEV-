package com.sistema.comidas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;

import com.sistema.comidas.bean.DetalleVentaBean;
import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.presentacion.GenericoMB;
import com.sistema.comidas.util.Encrypt;

@WebServlet(name = "Ingreso", urlPatterns = { "/Ingreso" })
@Scope(value = "session")
public class LoginServlet extends GenericoMB {

	HttpServletRequest request;
	private static final long serialVersionUID = 1L;
	
	String mensaje =null;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private UsuarioBean usuarioBean = new UsuarioBean();

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public UsuarioBean getUsuarioActivo() {
		UsuarioBean oUsuarioBean = new UsuarioBean();
		HttpSession session = getRequest().getSession();
		if (session != null) {
			Object obj = session.getAttribute("usuario");
			if (obj != null) {
				oUsuarioBean = (UsuarioBean) obj;
			}
		}
		return oUsuarioBean;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		String opc = request.getParameter("opcion");
		if (opc.equalsIgnoreCase("ing")) {
			System.out.println(opc);
			System.out.println("ingresar");
			String respuesta = null;
			try (PrintWriter pw = response.getWriter()) {
				
				String p1 = request.getParameter("txtuser");
				String p2 = request.getParameter("txtpwd");

				this.getUsuarioBean().setUsuario(p1);
				this.getUsuarioBean().setClave(p2);
				
				respuesta = validarAcceso();
				System.out.println(respuesta);
				request.setAttribute("msg", mensaje);
				request.getRequestDispatcher("" + respuesta).forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}

		} else if (opc.equalsIgnoreCase("sal")) {
			System.out.println(opc);
			
			
			super.getSession().invalidate();
			request.getRequestDispatcher("/Login.jsp").forward(request, response);			
		}

	}

	@SuppressWarnings("unused")
	public String validarAcceso() {

		String page = "Login.jsp";

		String key = super.getStringProp("Encrypt.key");
		Encrypt.init(key);

		try {
			if (this.getUsuarioBean().getClave() != null || !(this.getUsuarioBean().getClave().equals(""))) {
				String claveEncripatada = Encrypt.encrypt(this.getUsuarioBean().getClave());
				System.err.println("claveEncripatada " + claveEncripatada);

				this.getUsuarioBean().setClave(claveEncripatada);
				
				
				try {
					if (this.getUsuarioBean().getUsuario()  == null || true) {
						System.out.println("Entro");
						UsuarioBean oUsuario = new UsuarioBean();
						oUsuario.setUsuario(this.getUsuarioBean().getUsuario());
						oUsuario.setClave(this.getUsuarioBean().getClave());
						System.out.println(oUsuario.getUsuario());
						System.out.println(oUsuario.getClave());
						if (oUsuario.getUsuario() != null && oUsuario.getClave() != null) {
							System.out.println("user no vacio");
							HttpSession session = getRequest().getSession(true);
							super.setSession(session);
							super.getSession().setAttribute("ID",super.getSession().getId());
							super.getSession().setAttribute("usuario",oUsuario);
							ArrayList<DetalleVentaBean> carro = new ArrayList<DetalleVentaBean>();
							ArrayList<ProductoBean> carroComprasTemporal = new ArrayList<ProductoBean>();
							int cantidadDeProducto = 0;
							double SubTotal = 0;
							double Total = 0;
							ArrayList<DetalleVentaBean> carroCompra = new ArrayList<DetalleVentaBean>();
							ArrayList<InsumosBean> carroComprasTemporal2 = new ArrayList<InsumosBean>();
							int cantidadDeInsumo = 0;
							double SubTotalCompra = 0;
							double TotalCompra = 0;
							super.getSession().setAttribute("carro", carro);
							super.getSession().setAttribute("carroCT", carroComprasTemporal);
							super.getSession().setAttribute("cantidadDeProducto", cantidadDeProducto);
							super.getSession().setAttribute("subtotalVenta", SubTotal);
							super.getSession().setAttribute("totalVenta", Total);
							super.getSession().setAttribute("carroCompra", carroCompra);
							super.getSession().setAttribute("carroCTC", carroComprasTemporal2);						
							super.getSession().setAttribute("cantidadDeInsumo", cantidadDeInsumo);
							super.getSession().setAttribute("subtotalCompra", SubTotalCompra);
							super.getSession().setAttribute("totalCompra", TotalCompra);
							super.getSession().setAttribute("codUsu", 1);
							page = "MenuPrincipal.jsp";
						} else {
							
							System.out.println(page);
						}
					} else {
						System.out.println("Entro a");
						page = "Login.jsp";
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				page = "Login.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(page);
		return page;
	}

}
