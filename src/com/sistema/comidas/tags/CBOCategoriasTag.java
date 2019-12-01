package com.sistema.comidas.tags;



import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.factory.Factory;

//clase que encapsula la etiqueta de la fecha
public class CBOCategoriasTag extends TagSupport{
	
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
			CategoriaDAO dao = fabrica.getCategoriaDAO();
			ArrayList<CategoriaProductoBean> lista = dao.listarCategoria();
			if (lista!=null){
					out.println("<option value='0'>Selecione</option>");
				for (CategoriaProductoBean c : lista){
					out.println("<option value='"+c.getCat_pro_id()+"'>"+c.getCat_pro_des()+"</option>");
				}
			}
		} catch (Exception e) {
			throw new JspException("Error en el Custom Tag Fecha: " + e.getMessage());
		}
		
		return SKIP_BODY;
		}
	
		public int doEndTag() throws JspException {
		return EVAL_PAGE;
		}		

}
