package com.sistema.comidas.wrapper;

import org.displaytag.decorator.TableDecorator;

import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.factory.Factory;

public class UsuarioWrapper extends TableDecorator{

	public String getTipoDoc() {
		UsuarioBean user = (UsuarioBean) getCurrentRowObject();
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao = bd.getGenericoDAO();
		String tipDoc=dao.consultarTipoDoc(user.getTip_doc_id());
		return tipDoc;
		
	}
	
	public String getRol() {
		UsuarioBean user = (UsuarioBean) getCurrentRowObject();
		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		GenericoDAO dao = bd.getGenericoDAO();
		String rol=dao.consultarRolesNombre(user.getUsu_rol_id());
		return rol;		
	}
	
	//------------Botones de la lista de Usuario
	public String getSeleccionaUsuario() {
		UsuarioBean  obj = (UsuarioBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/UsuarioServlet?opc=act1&codigo="+ obj.getUsuario_id()+"\" value=\"\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Actualizar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
	
	public String getEliminaUsuario() {
		UsuarioBean  obj = (UsuarioBean) getCurrentRowObject();
		
		String selecciona ="<a class=\"btn btn-primary btn-sm\" href=\"/LP_2_Sistema_Venta_3.0/UsuarioServlet?opc=eli&codigo="+ obj.getUsuario_id()+"\" value=\"\"  onclick=\"return confirm('¿Esta Seguro de Eliminar a "+ obj.getNombre()+" "+ obj.getApellido()+" ?')\">\r\n" + 
				"											<i class=\"fa fa-dot-circle-o\"></i> Eliminar\r\n" + 
				"										</a>";
		return selecciona;
		
	}
	
}
