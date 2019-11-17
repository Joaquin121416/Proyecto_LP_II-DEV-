package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProducto;
import com.sistema.comidas.bean.ProveedorBean;
import com.sistema.comidas.dao.ProveedorDAO;
import com.sistema.comidas.util.MySQLConexion;

public class ProveedorDAOImpl implements ProveedorDAO {

	@Override
	public ArrayList<ProveedorBean> listarProveedor() {
		ArrayList<ProveedorBean> lista = new ArrayList<ProveedorBean>();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select *from TB_PROVEEDOR where PROV_EST;";

			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while (res.next()) {
				ProveedorBean pro = new ProveedorBean();
				lista.add(pro);
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
	public int agregarProveedor(ProveedorBean pro) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "INSERT INTO TB_CATEGORIA_PRODUCTO  VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getPROV_NOM());
			pstm.setInt(2,pro.getPROV_COD_RUC());

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
	

}
