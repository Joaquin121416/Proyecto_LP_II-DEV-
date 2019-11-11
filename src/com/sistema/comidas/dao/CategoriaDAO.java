package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProducto;

public interface CategoriaDAO {

	public int agregarCategoria(CategoriaProducto cat);

	public ArrayList<CategoriaProducto> listarCategoria();

	public int modificarCategoria(CategoriaProducto cat);

	public int eliminarCategoria(CategoriaProducto cat);
	
	public CategoriaProducto listarByID(int id);

}
