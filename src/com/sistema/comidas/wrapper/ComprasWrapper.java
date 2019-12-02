package com.sistema.comidas.wrapper;

import org.displaytag.decorator.TableDecorator;

import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class ComprasWrapper extends TableDecorator{

	
	//------------Botones de la lista de Usuario

	public String getCantidad() {
		InsumosBean  obj = (InsumosBean) getCurrentRowObject();
		
		String cantidad ="<input type=\"text\" id=\"text-input\" name=\"can\"\r\n" + 
				"													 class=\"form-control\" value=\"0\">";
		return cantidad;
		
	}
	public String getCodigo() {
		InsumosBean  obj = (InsumosBean) getCurrentRowObject();
		
		String cantidad ="<input type=\"text\" id=\"text-input\" name=\"cod\"\r\n" + 
				"										readonly=	\"true\"	 class=\"form-control\" value=\""+ obj.getINS_ID()+" \">";
		return cantidad;
		
	}
	
	public String getAgregar() {
		InsumosBean  obj = (InsumosBean) getCurrentRowObject();
		
		String vender ="<button class=\"btn btn-primary btn-sm\" name=\"opc\" value=\"ven\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Vender\r\n" + 
				"										</button>";		
		return vender;
		
	}
	

	
}
