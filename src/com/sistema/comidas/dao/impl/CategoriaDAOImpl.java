package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.dao.CategoriaDAO;
import com.sistema.comidas.util.MySQLConexion;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public int agregarCategoria(CategoriaProductoBean cat) {

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
	public ArrayList<CategoriaProductoBean> listarCategoria() {
		ArrayList<CategoriaProductoBean> lista = new ArrayList<CategoriaProductoBean>();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select cat_pro_id,cat_pro_nom,cat_pro_des from TB_CATEGORIA_PRODUCTO where cat_pro_est=?;";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 1);
			res = pstm.executeQuery();
			while (res.next()) {
				CategoriaProductoBean cat = new CategoriaProductoBean(res.getInt(1), res.getString(2), res.getString(3), "1");
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
	public int modificarCategoria(CategoriaProductoBean cat) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "update TB_CATEGORIA_PRODUCTO set CAT_PRO_NOM =? ,CAT_PRO_DES=? where CAT_PRO_ID=?;";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cat.getCat_pro_nom());
			pstm.setString(2, cat.getCat_pro_des());
			pstm.setInt(3, cat.getCat_pro_id());

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
	public int eliminarCategoria(CategoriaProductoBean cat) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "update TB_CATEGORIA_PRODUCTO set cat_pro_est=0 where cat_pro_id=? ;";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cat.getCat_pro_id());

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
	public CategoriaProductoBean listarByID(int id) {
		CategoriaProductoBean cat = new CategoriaProductoBean();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select cat_pro_id,cat_pro_nom,cat_pro_des from TB_CATEGORIA_PRODUCTO where cat_pro_est and cat_pro_id= ?;";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeQuery();
			while (res.next()) {
				cat = new CategoriaProductoBean(res.getInt(1), res.getString(2), res.getString(3), "1");
				return cat;
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
		return cat;
	}

}
