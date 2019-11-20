package com.sistema.comidas.util;

import org.displaytag.decorator.TableDecorator;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.ProductoBean;

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
	
	//--------------BOTONES DE LA LISTA DE PRODUCTOS
	public String getSeleccionaProducto() {
		ProductoBean  obj = (ProductoBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/crudProducto?opc=act1&codigo="+ obj.getPRO_ID()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Actualizar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
	
	public String getEliminaProducto() {
		ProductoBean  obj = (ProductoBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/crudProducto?opc=eli&codigo="+ obj.getPRO_ID()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Eliminar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
}
