package com.sistema.comidas.dao.factory;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.impl.CategoriaDAOImpl;
import com.sistema.comidas.dao.impl.GenericoDAOImpl;
import com.sistema.comidas.dao.impl.UsuarioDAOImpl;

public class MySqlFactory extends Factory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOImpl();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new CategoriaDAOImpl();
	}

	@Override
	public GenericoDAO getGenericoDAO() {
		// TODO Auto-generated method stub
		return new GenericoDAOImpl();
	}

}
