package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProducto;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.util.MySQLConexion;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public int agregarCategoria(CategoriaProducto cat) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "INSERT INTO TB_CATEGORIA_PRODUCTO  VALUES (NULL, ?, ?, 1);";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cat.getCat_pro_nom());
			pstm.setString(2, cat.getCat_pro_des());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public ArrayList<CategoriaProducto> listarCategoria() {
		ArrayList<CategoriaProducto> lista = new ArrayList<CategoriaProducto>();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select cat_pro_id,cat_pro_nom,cat_pro_des from TB_CATEGORIA_PRODUCTO where cat_pro_est;";

			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while (res.next()) {
				CategoriaProducto cat = new CategoriaProducto(res.getInt(1), res.getString(2), res.getString(3),"1");
				lista.add(cat);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int modificarCategoria(CategoriaProducto cat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCategoria(CategoriaProducto cat) {
		// TODO Auto-generated method stub
		return 0;
	}

}
