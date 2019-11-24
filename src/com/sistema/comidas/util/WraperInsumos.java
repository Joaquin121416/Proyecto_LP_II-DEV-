package com.sistema.comidas.util;

import java.text.DecimalFormat;

import org.displaytag.decorator.TableDecorator;
import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProductoBean;
public class WraperInsumos extends TableDecorator{

	//metodo con la imaagen de un insumo
	public String getimagen2() {
		InsumosBean p = (InsumosBean) getCurrentRowObject();
		return "<img alt ='' src='images/"+p.getINS_ID()+".png' width='40px'>";
	}
	public String getnombreycod() {
		InsumosBean p = (InsumosBean) getCurrentRowObject();
		return "<b>"+p.getINS_DES()+"</b>+<br> SKU NUMERO :"+ p.getINS_ID();
	}
	
	public String getPredad() {
		InsumosBean p = (InsumosBean) getCurrentRowObject();
		DecimalFormat dec = new DecimalFormat("####,00");
		return "<b>"+dec.format(p.getINS_PRE())+"</b>";
	}
	
	public String getEnlace() {
		return "<a href='#'>Elemento</a>";
	}
	public String getSeleccionaActualizar() {
		InsumosBean  obj = (InsumosBean) getCurrentRowObject();
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/InsumoServlet?opc=act&codigo="+ obj.getINS_ID()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Actualizar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
	
	}
