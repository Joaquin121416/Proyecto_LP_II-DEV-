package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.InsumosBean;
public interface InsumosDAO {

	
	public int agregarInsumo(InsumosBean ins);
	
	public ArrayList<InsumosBean>listarInsumos();

	public int modificarInsumos(InsumosBean ins);
	
	public int eliminarInsumo(InsumosBean ins);
	public InsumosBean listarByID(int id);
}