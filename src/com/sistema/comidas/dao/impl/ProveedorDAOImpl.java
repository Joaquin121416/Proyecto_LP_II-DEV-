package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;
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
			String sql = "select * from TB_PROVEEDOR where PROV_EST;";

			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while (res.next()) {
				ProveedorBean pro = new ProveedorBean();
				pro.setPROV_ID(res.getInt(1));
				pro.setPROV_NOM(res.getString(2));
				pro.setPROV_COD_RUC(res.getInt(3));
				pro.setPROV_NUM_TEL(res.getInt(4));
				pro.setPROV_ESTADO(res.getInt(5));
				pro.setAUD_TIPO(res.getInt(6));
				pro.setAUD_IDUSUARIO(res.getInt(7));
				pro.setAUD_SESION(res.getString(8));
				pro.setAUD_FECHA(res.getInt(9));
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
			String sql = "INSERT INTO TB_PROVEEDOR  VALUES (NULL,?,?,?,1,1,?,1,?,?);";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getPROV_NOM());
			pstm.setInt(2,pro.getPROV_COD_RUC());
			pstm.setInt(3,pro.getPROV_NUM_TEL());
			pstm.setString(4,pro.getAUD_SESION());
			pstm.setInt(5,pro.getAUD_FECHA());
			pstm.setString(6,pro.getAUD_IP());
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
