package com.sistema.comidas.tags;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class CodigosTag extends TagSupport {
	// <p class="form-control-static">Codigo</p>

	private String tabla;
	
	private String campo;
	
 
	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public int doStartTag() throws JspException {
		// Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");

		JspWriter out = pageContext.getOut();

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao =bd.getGenericoDAO();

		try {
			int codigo= dao.consultarCodigo(tabla,campo);
			codigo++;
			out.print("<p class=\"form-control-static\">" + codigo + "</p>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}


}
