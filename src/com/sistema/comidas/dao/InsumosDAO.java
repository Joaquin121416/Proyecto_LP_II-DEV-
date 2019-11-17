package com.sistema.comidas.dao;

import java.util.ArrayList;

import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.UsuarioBean;

public interface InsumosDAO {

	
	public int agregarInsumo(InsumosBean ins);
	
	public ArrayList<InsumosDAO> listarInsumos();

	public int modificarUsuario(InsumosBean ins);
	
	public int eliminarInsumo(InsumosBean ins);
}