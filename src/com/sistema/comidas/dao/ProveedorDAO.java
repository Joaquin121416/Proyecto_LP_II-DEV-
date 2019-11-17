package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.ProveedorBean;

public interface ProveedorDAO {
	
	public ArrayList<ProveedorBean> listarProveedor();
	public int agregarProveedor(ProveedorBean pro);
}
