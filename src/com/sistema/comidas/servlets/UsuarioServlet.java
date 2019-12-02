package com.sistema.comidas.servlets;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
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
import com.sistema.comidas.test.Bin;
import com.sistema.comidas.test.ImgBin;
import com.sistema.comidas.util.Encrypt;
import com.sistema.comidas.util.Net;

import sun.invoke.empty.Empty;

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
			try {
				agregarUsuario(request, response);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opc.equals("act1")) {
			actualizar1(request, response);
		} else if (opc.equals("eli")) {
			eliminar(request, response);
		} else if (opc.equals("act2")) {
			actualizar2(request, response);
		}

	}
	
	protected void agregarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, GeneralSecurityException {

		// variables
		String mensaje = null;
		String url;
		// entradas
		String nombre = (request.getParameter("nom"));
		String rol = request.getParameter("rol");
		String usu = request.getParameter("usu");
		String tipDoc = request.getParameter("tipDoc");
		String ape = request.getParameter("ape");
		String img =  request.getParameter("img"); 
		String pwd = request.getParameter("pwd");
		String doc = request.getParameter("doc");
		String audIp = Net.getClientIPAddres(request);
		// procesos
		File file = new File("E://"+img);
		
		UsuarioBean user = new UsuarioBean();
		user.setNombre(nombre);
		user.setApellido(ape);
		user.setUsuario(usu);
		try {
			user.setUsu_img(Bin.ImgCastBlob(file));
		} catch (Exception e) {
			user.setUsu_img(null);
		}
		Encrypt.init("C1b3rT3c");
		user.setClave(Encrypt.encrypt(pwd));
		user.setTip_doc_id(Integer.parseInt(tipDoc));
		user.setUsu_rol_id(Integer.parseInt(rol));
		user.setUsuario_id(0);
		user.setUsu_doc(doc);
		user.setAud_ip(audIp);
		
		if (nombre.matches("\\D{3,20}")) {
			if(ape.matches("\\D{3,40}")) {
				if(doc.matches("\\d{6,15}")) {
					if(usu.matches("[\\D\\d]{2,20}")) {
						if(pwd.matches("[a-zA-Z\\d]{5,30}" )){
							System.out.println(doc.matches("\\d{8,15}"));
							
							Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
							UsuarioDAO dao = bd.getUsuarioDAO();
							int res = dao.agregarUsuario(user);
							System.err.println(res);
							if (res == 0) {
								mensaje = "no se pudo insertar el registro";
								url = "Usuario/AgregarUsuarioMenu.jsp";
							} else {
								mensaje = "usuario añadido";
								url = "Usuario/AgregarUsuarioMenu.jsp";
							}
				
							request.setAttribute("mensaje", mensaje);
							request.getRequestDispatcher(url).forward(request, response);	
							
						}else {
							url = "Usuario/AgregarUsuarioMenu.jsp";
							request.setAttribute("cod", user.getUsuario_id());
							request.setAttribute("nom", user.getNombre());
							request.setAttribute("ape", user.getApellido());
							request.setAttribute("docIde", user.getUsu_doc());
							request.setAttribute("usu", user.getUsuario());
							request.setAttribute("val", user.getTip_doc_id());
							request.setAttribute("rol", user.getUsu_rol_id());
							request.setAttribute("mensaje", "Ingrese una contraseñña valida");
							request.getRequestDispatcher(url).forward(request, response);
						}
					}else {
						url = "Usuario/AgregarUsuarioMenu.jsp";
						request.setAttribute("cod", user.getUsuario_id());
						request.setAttribute("nom", user.getNombre());
						request.setAttribute("ape", user.getApellido());
						request.setAttribute("docIde", user.getUsu_doc());
						request.setAttribute("usu", user.getUsuario());
						request.setAttribute("val", user.getTip_doc_id());
						request.setAttribute("rol", user.getUsu_rol_id());
						request.setAttribute("mensaje", "Ingrese un usuario valido");
						request.getRequestDispatcher(url).forward(request, response);
					}
				}else {
					url = "Usuario/AgregarUsuarioMenu.jsp";
					request.setAttribute("cod", user.getUsuario_id());
					request.setAttribute("nom", user.getNombre());
					request.setAttribute("ape", user.getApellido());
					request.setAttribute("docIde", user.getUsu_doc());
					request.setAttribute("usu", user.getUsuario());
					request.setAttribute("val", user.getTip_doc_id());
					request.setAttribute("rol", user.getUsu_rol_id());
					request.setAttribute("mensaje", "Ingrese numero de documento valido");
					request.getRequestDispatcher(url).forward(request, response);	
				}
				
			}else {
				url = "Usuario/AgregarUsuarioMenu.jsp";
				request.setAttribute("cod", user.getUsuario_id());
				request.setAttribute("nom", user.getNombre());
				request.setAttribute("ape", user.getApellido());
				request.setAttribute("docIde", user.getUsu_doc());
				request.setAttribute("usu", user.getUsuario());
				request.setAttribute("val", user.getTip_doc_id());
				request.setAttribute("rol", user.getUsu_rol_id());
				request.setAttribute("mensaje", "Ingrese un apellido correcto");
				request.getRequestDispatcher(url).forward(request, response);	
			}
			
		}else {
		
		url = "Usuario/AgregarUsuarioMenu.jsp";
		request.setAttribute("cod", user.getUsuario_id());
		request.setAttribute("nom", user.getNombre());
		request.setAttribute("ape", user.getApellido());
		request.setAttribute("docIde", user.getUsu_doc());
		request.setAttribute("usu", user.getUsuario());
		request.setAttribute("val", user.getTip_doc_id());
		request.setAttribute("rol", user.getUsu_rol_id());
		request.setAttribute("mensaje", "Ingrese un nombre correcto");
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

		// variables
				String mensaje = null;
				String url;
				// entradas
				int cod = Integer.parseInt(request.getParameter("cod"));
				String nombre = (request.getParameter("nom"));
				String rol = request.getParameter("rol");
				String usu = request.getParameter("usu");
				String tipDoc = request.getParameter("tipDoc");
				String ape = request.getParameter("txtape");
				String doc = request.getParameter("doc");
				String audIp = Net.getClientIPAddres(request);
				// procesos
				
				UsuarioBean user = new UsuarioBean();
				user.setUsuario_id(cod);
				user.setNombre(nombre);
				user.setApellido(ape);
				user.setUsuario(usu);
				user.setTip_doc_id(Integer.parseInt(tipDoc));
				user.setUsu_rol_id(Integer.parseInt(rol));
				user.setUsu_doc(doc);
				user.setAud_ip(audIp);
				
				if (nombre.matches("\\D{3,20}")) {
					System.out.println(ape +" : "+ape.matches("\\D{3,40}"));
					if(ape.matches("\\D{3,40}")) {
							if(usu.matches("[\\D\\d]{2,20}")) {
								System.out.println(doc.matches("\\d{8,15}"));
								if(doc.matches("\\d{6,15}")){
									
									Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
									UsuarioDAO dao = bd.getUsuarioDAO();
									int res = dao.modificarUsuario(user);
									System.err.println(res);
									if (res == 0) {
										mensaje = "no se pudo actualizar el registro";
										url = "Usuario/ListaUsuarioMenu.jsp";
									} else {
										mensaje = "usuario actualizado";
										url = "Usuario/ListaUsuarioMenu.jsp";
									}
						
									request.setAttribute("mensaje", mensaje);
									request.getRequestDispatcher(url).forward(request, response);	
									
								}else{
									url = "Usuario/ModificarUsuarioMenu.jsp";
									request.setAttribute("cod", user.getUsuario_id());
									request.setAttribute("nom", user.getNombre());
									request.setAttribute("ape", user.getApellido());
									request.setAttribute("docIde", user.getUsu_doc());
									request.setAttribute("usu", user.getUsuario());
									request.setAttribute("val", user.getTip_doc_id());
									request.setAttribute("rol", user.getUsu_rol_id());
									request.setAttribute("mensaje", "Ingrese un numero de documento valido");
									request.getRequestDispatcher(url).forward(request, response);
								}
							}else {
								url = "Usuario/ModificarUsuarioMenu.jsp";
								request.setAttribute("cod", user.getUsuario_id());
								request.setAttribute("nom", user.getNombre());
								request.setAttribute("ape", user.getApellido());
								request.setAttribute("docIde", user.getUsu_doc());
								request.setAttribute("usu", user.getUsuario());
								request.setAttribute("val", user.getTip_doc_id());
								request.setAttribute("rol", user.getUsu_rol_id());
								request.setAttribute("mensaje", "Ingrese un usuario valido");
								request.getRequestDispatcher(url).forward(request, response);
							}
						
						
					}else {
						url = "Usuario/ModificarUsuarioMenu.jsp";
						request.setAttribute("cod", user.getUsuario_id());
						request.setAttribute("nom", user.getNombre());
						request.setAttribute("ape", user.getApellido());
						request.setAttribute("docIde", user.getUsu_doc());
						request.setAttribute("usu", user.getUsuario());
						request.setAttribute("val", user.getTip_doc_id());
						request.setAttribute("rol", user.getUsu_rol_id());
						request.setAttribute("mensaje", "Ingrese un apellido correcto");
						request.getRequestDispatcher(url).forward(request, response);	
					}
					
				}else {
				
				url = "Usuario/ModificarUsuarioMenu.jsp";
				request.setAttribute("cod", user.getUsuario_id());
				request.setAttribute("nom", user.getNombre());
				request.setAttribute("ape", user.getApellido());
				request.setAttribute("docIde", user.getUsu_doc());
				request.setAttribute("usu", user.getUsuario());
				request.setAttribute("val", user.getTip_doc_id());
				request.setAttribute("rol", user.getUsu_rol_id());
				request.setAttribute("mensaje", "Ingrese un nombre correcto");
				request.getRequestDispatcher(url).forward(request, response);	
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
