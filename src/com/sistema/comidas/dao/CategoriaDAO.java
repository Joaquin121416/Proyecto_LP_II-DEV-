package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;

public interface CategoriaDAO {

	public int agregarCategoria(CategoriaProductoBean cat);

	public ArrayList<CategoriaProductoBean> listarCategoria();

	public int modificarCategoria(CategoriaProductoBean cat);

	public int eliminarCategoria(CategoriaProductoBean cat);

	public CategoriaProductoBean listarByID(int id);

}
