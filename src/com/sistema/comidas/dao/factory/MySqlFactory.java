package com.sistema.comidas.dao.factory;

import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.dao.ProveedorDAO;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.VentaDAO;
import com.sistema.comidas.dao.impl.CategoriaDAOImpl;
import com.sistema.comidas.dao.impl.GenericoDAOImpl;
import com.sistema.comidas.dao.impl.InsumosDAOImpl;
import com.sistema.comidas.dao.impl.ProductoDAOImpl;
import com.sistema.comidas.dao.impl.ProveedorDAOImpl;
import com.sistema.comidas.dao.impl.UsuarioDAOImpl;
import com.sistema.comidas.dao.impl.VentaDAOImpl;

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
		return new InsumosDAOImpl();
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new ProveedorDAOImpl();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new ProductoDAOImpl();
	}

	@Override
	public VentaDAO getVentaDAO() {
		// TODO Auto-generated method stub
		return new VentaDAOImpl();
	}




}
