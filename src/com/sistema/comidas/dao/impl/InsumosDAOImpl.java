package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.InsumosBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.InsumosDAO;
import com.sistema.comidas.util.*;

public class InsumosDAOImpl implements InsumosDAO {

	public int agregarInsumo(InsumosBean ins) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "insert into TB_INSUMO values (defualt ,?, ?, ?,default,null,,null,null,null,null)";
			pst = con.prepareStatement(sql);
			pst.setString(1, ins.getINS_NOM());
			pst.setString(2, ins.getINS_DES());
			pst.setDouble(3, ins.getINS_PRE());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public ArrayList<InsumosBean> listarInsumos() {
		ArrayList<InsumosBean> lista = new ArrayList<InsumosBean>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "select * from TB_INSUMO where INS_EST='1'";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				InsumosBean p = new InsumosBean();
				p.setINS_ID(rs.getInt(1));
				p.setINS_NOM(rs.getString(2));
				p.setINS_DES(rs.getString(3));
				p.setINS_PRE(rs.getDouble(4));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public int modificarInsumos(InsumosBean ins) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "update TB_INSUMO set INS_NOM=?, INS_DES = ?, INS_PRE = ? where INS_ID = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, ins.getINS_NOM());
			pst.setString(2, ins.getINS_DES());
			pst.setDouble(3, ins.getINS_PRE());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;

	}

	@Override
	public int eliminarInsumo(InsumosBean ins) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "update TB_INSUMO set INS_EST = '0' where INS_ID = ?;";
			pst = con.prepareStatement(sql);
			pst.setInt(1, ins.getINS_ID());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public InsumosBean listarByID(int id) {
		InsumosBean ins = new InsumosBean();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "select INS_ID,INS_NOM,INS_DES,INS_PRE,INS_EST from TB_INSUMO where INS_ID= ?;";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ins = new InsumosBean();
				ins.setINS_ID(rs.getInt(1));
				ins.setINS_NOM(rs.getString(2));
				ins.setINS_DES(rs.getString(3));
				ins.setINS_PRE(rs.getDouble(4));
				return ins;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ins;
	}

}
