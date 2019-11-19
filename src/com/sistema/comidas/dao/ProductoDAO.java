package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.ProductoBean;

public interface ProductoDAO {
	public ArrayList<ProductoBean> listarProductos();
	public int registrarProducto(ProductoBean p);
	public int actualizarProducto(ProductoBean p);
	public int eliminarProducto(ProductoBean p);
}
