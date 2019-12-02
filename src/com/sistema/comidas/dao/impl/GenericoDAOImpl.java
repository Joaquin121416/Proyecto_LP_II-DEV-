package com.sistema.comidas.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.RolBean;
import com.sistema.comidas.bean.TipoDeDocumentoBean;
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

	@Override
	public ArrayList<RolBean> consultarRoles() {
		ArrayList<RolBean> ListRolBean = new ArrayList<RolBean>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "SELECT * FROM  TB_ROL;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				RolBean rolBean = new RolBean();
				rolBean.setRolId(rs.getInt(1));
				rolBean.setRolName(rs.getString(2));
				ListRolBean.add(rolBean);
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
		return ListRolBean;
	}

	@Override
	public ArrayList<TipoDeDocumentoBean> consultarTipoDeDocumento() {
		ArrayList<TipoDeDocumentoBean> ListDocBean = new ArrayList<TipoDeDocumentoBean>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "SELECT * FROM  TB_TIPO_DOCUMENTO;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TipoDeDocumentoBean docBean = new TipoDeDocumentoBean();
				docBean.setTip_doc_id(rs.getInt(1));
				docBean.setTip_doc(rs.getString(2));
				ListDocBean.add(docBean);
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
		return ListDocBean;
	}

	@Override
	public String consultarTipoDoc(int id) {

		String tipoDoc = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select TIP_DOC from TB_TIPO_DOCUMENTO where TIP_DOC_ID = ?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				tipoDoc = rs.getString(1);
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
		return tipoDoc;

	}

	@Override
	public String consultarRolesNombre(int id) {

		String rol = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select Rol_Nam from TB_ROL where Rol_id = ?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				rol = rs.getString(1);
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
		return rol;

	}

	@Override
	public int existe(int id, String Tb, String idTb) {

		int num = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select * from " + Tb + " where  " + idTb + " = " + id + ";";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				num++;
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
		return num;

	}

	@Override
	public String consultarCantidadVentas() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int ventas = 0;
		conn = new MySQLConexion().getConexion();
		String sql = "select count(DOC_VEN_ID) from TB_DOCUMENTO_DE_VENTA;";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ventas = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return String.valueOf(ventas);
	}

	@Override
	public String consultarVentas() {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BigDecimal ventas = null;
		conn = new MySQLConexion().getConexion();
		String sql = "	select sum(DET_DOC_VEN_NETO) from TB_DETALLE_DE_DOCUMENTO_VENTA;";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ventas = rs.getBigDecimal(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ventas.toString();

	}

	@Override
	public String consultarCantidadCompras() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int ventas = 0;
		conn = new MySQLConexion().getConexion();
		String sql = "select count(DOC_COM_ID) from TB_DOCUMENTO_COMPRA;";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ventas = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return String.valueOf(ventas);
	}

	@Override
	public String consultarCompras() {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BigDecimal ventas = null;
		conn = new MySQLConexion().getConexion();
		String sql = "	select sum(DET_DOC_COM_NETO) from TB_DETALLE_DE_DOCUMENTO_COMPRA;";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ventas = rs.getBigDecimal(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ventas.toString();

	}

}
