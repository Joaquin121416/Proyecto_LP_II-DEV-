package com.sistema.comidas.presentacion;

import java.io.IOException;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.sistema.comidas.bean.GenericoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.servlets.LoginServlet;
import com.sistema.comidas.util.Constantes;
import com.sistema.comidas.util.Net;

import oracle.net.aso.p;

public class GenericoMB extends HttpServlet{

	
	private HttpSession session= null;
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	private static final long serialVersionUID = 1L;

	protected void aviso(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_INFO,
	        				"Aviso", msg));
	    }
	     
	 protected void alerta(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_WARN,
	        				"Alerta!", msg));
	    }
	     
	 protected void error(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null,
	        		new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	        				"Error!", msg));
	    }
	     
	 protected void fatal(String msg) {
	        FacesContext.getCurrentInstance().addMessage(null, 
	        		new FacesMessage(FacesMessage.SEVERITY_FATAL, 
	        				"Fatal!", msg));
	    }
	 
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
		
		
		/*
		 * Formato de Exportación de Excel
		 */
		
		protected void setStyleFormat(HSSFWorkbook workbook, Cell cell) {
	        HSSFFont font = workbook.createFont();
	        font.setFontHeightInPoints((short) 10);
	        font.setFontName("Arial");
	        font.setColor(IndexedColors.BLACK.getIndex());
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setItalic(false);

	        CellStyle newCellStyle = workbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(cell.getCellStyle());
	
	        newCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
	        newCellStyle.setFont(font);

	        cell.setCellStyle(newCellStyle);
	    }

	    protected void setStyleLisCabecera(HSSFWorkbook workbook, Cell cell) {
	        HSSFFont font = workbook.createFont();
	        font.setFontHeightInPoints((short) 10);
	        font.setFontName("Arial");
	        font.setColor(IndexedColors.WHITE.getIndex());
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        font.setItalic(false);

	        CellStyle newCellStyle = workbook.createCellStyle();
	        newCellStyle.cloneStyleFrom(cell.getCellStyle());

	        newCellStyle.setFillForegroundColor(HSSFColor.RED.index);
	        newCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        newCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	        newCellStyle.setBorderTop((short) 1); 
	        newCellStyle.setBorderBottom((short) 1); 
	        newCellStyle.setBorderRight((short) 1);
	        newCellStyle.setBorderLeft((short) 1);
	        newCellStyle.setFont(font);

	        cell.setCellStyle(newCellStyle);
	    }

}
