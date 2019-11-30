package com.sistema.comidas.tags;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sistema.comidas.bean.RolBean;
import com.sistema.comidas.bean.TipoDeDocumentoBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class TipoDeDocumentosTag extends TagSupport{
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		// Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");

		JspWriter out = pageContext.getOut();

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao =bd.getGenericoDAO();

		try {
			ArrayList<TipoDeDocumentoBean> listDoc= dao.consultarTipoDeDocumento();
			out.print("<select name=\"tipDoc\" id=\"selectSm\" class=\"form-control-sm form-control\"  value=\" "+value +"\" >");
			for (TipoDeDocumentoBean tipoDeDocumentoBean : listDoc) {
				out.print(" <option value=\""+tipoDeDocumentoBean.getTip_doc_id()+"\">"+tipoDeDocumentoBean.getTip_doc()+"</option>");
			}
			out.print("<select>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
}
