package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.DetalleCompraBean;
import com.sistema.comidas.bean.DetalleVentaBean;
import com.sistema.comidas.bean.DocumentoCompraBean;
import com.sistema.comidas.bean.DocumentoVentaBean;

public interface VentaDAO {

	
	public int RealizarVenta(ArrayList<DetalleVentaBean> det,DocumentoVentaBean doc); 
	
	public int RealizarCompra(ArrayList<DetalleCompraBean> det,DocumentoCompraBean doc); 
}
