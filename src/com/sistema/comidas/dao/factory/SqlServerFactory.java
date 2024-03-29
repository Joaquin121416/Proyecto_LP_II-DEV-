package com.sistema.comidas.dao.factory;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.ProveedorDAO;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.VentaDAO;
import com.sistema.comidas.dao.impl.UsuarioDAOImpl;

public class SqlServerFactory extends Factory {

	@Override
	public UsuarioDAO getUsuarioDAO() {

		return new UsuarioDAOImpl();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericoDAO getGenericoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsumosDAO getInsumoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaDAO getVentaDAO() {
		// TODO Auto-generated method stub
		return null;
	}



}
