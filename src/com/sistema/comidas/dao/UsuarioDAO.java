package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.UsuarioBean;

public interface UsuarioDAO {

	
	public int agregarUsuario(UsuarioBean user);
	
	public ArrayList<UsuarioBean> listarUsuario();

	public int modificarUsuario(UsuarioBean user);
	
	public int eliminarUsuario(UsuarioBean user);
	
	public UsuarioBean listarByID(int id);

}
