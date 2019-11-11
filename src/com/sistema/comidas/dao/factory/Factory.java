package com.sistema.comidas.dao.factory;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.ProveedorDAO;
import com.sistema.comidas.dao.UsuarioDAO;

public abstract class Factory {

	public static final int TIPO_MYSQL = 1;
	public static final int TIPO_SQL_SERVER = 2;
	
	
	public abstract UsuarioDAO  getUsuarioDAO();
	
	public abstract CategoriaDAO getCategoriaDAO();
	
	public abstract InsumosDAO getInsumoDAO();
	
	public abstract GenericoDAO getGenericoDAO(); 
	
	public abstract ProveedorDAO getProveedorDAO();
	
	
	public static Factory getTipo(int tipo) {
		switch (tipo) {
		case TIPO_MYSQL:
			return new MySqlFactory();
		case TIPO_SQL_SERVER:
			return new SqlServerFactory();

		}

		return null;
	}

}
