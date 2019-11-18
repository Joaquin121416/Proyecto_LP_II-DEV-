package com.sistema.comidas.util;

import org.displaytag.decorator.TableDecorator;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import com.sistema.comidas.bean.CategoriaProductoBean;

public class Wrapper extends TableDecorator{

	
	public String getSeleccionaCategoria() {
		CategoriaProductoBean  obj = (CategoriaProductoBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/CategoriaServlet?opc=act1&codigo="+ obj.getCat_pro_id()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Actualizar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
	
	public String getEliminaCategoria() {
		CategoriaProductoBean  obj = (CategoriaProductoBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/CategoriaServlet?opc=eli&codigo="+ obj.getCat_pro_id()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Eliminar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
}
