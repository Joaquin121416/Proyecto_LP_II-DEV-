package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.util.MySQLConexion;

public class GenericoDAOImpl implements GenericoDAO {

	@Override
	public int consultarCodigo(String nombreTabla, String nombreCodigo) {

		int codigo = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "SELECT MAX(" + nombreCodigo + ") ultimo FROM " + nombreTabla + ";";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				codigo = rs.getInt("ultimo");
				System.out.println(codigo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return codigo;

	}

}
