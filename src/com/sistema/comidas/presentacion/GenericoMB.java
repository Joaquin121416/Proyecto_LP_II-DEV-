package com.sistema.comidas.presentacion;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


import com.sistema.comidas.bean.GenericoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.servlets.LoginServlet;
import com.sistema.comidas.util.Constantes;
import com.sistema.comidas.util.Net;


public class GenericoMB extends HttpServlet{

	
	private HttpSession session= null;
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	private static final long serialVersionUID = 1L;

	protected String getStringProp(String key) {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			Properties properties = new Properties();
			try {
				properties.load(cl.getResourceAsStream(Constantes.FILE_NAME_RESOURCE));
				return properties.getProperty(key); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "";
		}
		
		protected UsuarioBean getUsuarioActivo() {
			UsuarioBean oUsuarioBean=null;
		
			if (session!=null) {
				Object obj=session.getAttribute("usuario");
				if (obj!=null) {
					oUsuarioBean=(UsuarioBean)obj;
				}
			}
			return oUsuarioBean;
		}
		
		protected void setAuditoria(GenericoBean ge){
			LoginServlet log= new LoginServlet();
			session= log.getRequest().getSession();
			if (session!=null) {
				
				// Usuario
				Object obj=session.getAttribute("usuario");
				if (obj!=null) {
					UsuarioBean oUsuarioBean=(UsuarioBean)obj;
					ge.setAudIdUsuario(oUsuarioBean.getCodigo());
				}
				
				// Sesion
				Object id=session.getAttribute("ID");
				if (id!=null) {
					String oID=(String)id;
					ge.setAudSession(oID);
				}
			}
			// IP
			String ip= Net.getClientIPAddres(log.getRequest());
			ge.setAudIp(ip);
		}
		

}
