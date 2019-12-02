package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.RolBean;
import com.sistema.comidas.bean.TipoDeDocumentoBean;

public interface GenericoDAO {

	
	public int consultarCodigo(String nombreTabla,String nombreCodigo);
	
	public ArrayList<RolBean> consultarRoles();
	
	public ArrayList<TipoDeDocumentoBean> consultarTipoDeDocumento();
	
	public String consultarTipoDoc(int id);
	
	public String consultarRolesNombre(int id);
	
	public int existe(int id , String Tb,String idTb);
	
	public String consultarCantidadVentas();
	
	public String consultarVentas();
	
	public String consultarCantidadCompras();
	
	public String consultarCompras();
}
