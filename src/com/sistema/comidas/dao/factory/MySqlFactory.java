package com.sistema.comidas.dao.factory;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.impl.CategoriaDAOImpl;
import com.sistema.comidas.dao.impl.GenericoDAOImpl;
import com.sistema.comidas.dao.impl.InsumosDAOImpl;
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
	public InsumosDAO getInsumosDAO () {
		// TODO Auto-generated method stub
		return new InsumosDAOImpl();
	}


	@Override
	public GenericoDAO getGenericoDAO() {
		// TODO Auto-generated method stub
		return new GenericoDAOImpl();
	}

	@Override
	public InsumosDAO getInsumoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
