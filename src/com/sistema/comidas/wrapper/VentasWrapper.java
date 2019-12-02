package com.sistema.comidas.wrapper;

import org.displaytag.decorator.TableDecorator;

import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class VentasWrapper extends TableDecorator{

	
	//------------Botones de la lista de Usuario
	public String getImg() {
		ProductoBean  obj = (ProductoBean) getCurrentRowObject();
		
		String img ="<img src=\"data:image/png;base64, "+obj.getPRO_IMG() +" \" alt=\"Producto\" width=\"100\" height=\"100\">";
		return img;
		
	}
	public String getCantidad() {
		ProductoBean  obj = (ProductoBean) getCurrentRowObject();
		
		String cantidad ="<input type=\"text\" id=\"text-input\" name=\"can\"\r\n" + 
				"													 class=\"form-control\" value=\"0\">";
		return cantidad;
		
	}
	
	public String getAgregar() {
		ProductoBean  obj = (ProductoBean) getCurrentRowObject();
		
		String vender ="<button class=\"btn btn-primary btn-sm\" name=\"opc\" value=\"ven\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Agregar\r\n" + 
				"										</button>";
		return vender;
		
	}
	

	
}
