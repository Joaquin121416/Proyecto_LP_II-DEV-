package com.sistema.comidas.tags;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sistema.comidas.bean.RolBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class RolesTag extends TagSupport{

	private int value;
	
	public int doStartTag() throws JspException {
		// Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");

		JspWriter out = pageContext.getOut();

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao =bd.getGenericoDAO();

		try {
			ArrayList<RolBean> listRol= dao.consultarRoles();
			out.print("<select name=\"rol\" id=\"selectSm\" class=\"form-control-sm form-control\" value=\" "+value +"\">");
			for (RolBean rolBean : listRol) {
				out.print(" <option value=\""+rolBean.getRolId()+"\">"+rolBean.getRolName()+"</option>");
			}
			out.print("<select>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
