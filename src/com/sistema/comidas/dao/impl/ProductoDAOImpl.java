package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.ProductoBean;
import com.sistema.comidas.dao.ProductoDAO;
import com.sistema.comidas.util.MySQLConexion;

public class ProductoDAOImpl implements ProductoDAO{

	@Override
	public ArrayList<ProductoBean> listarProductos() {
		ArrayList<ProductoBean> lista = new ArrayList<ProductoBean>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "select * from TB_PRODUCTO where PRO_EST='1'";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductoBean p = new ProductoBean();
				p.setPRO_ID(rs.getInt(1));
				p.setPRO_NOM(rs.getString(2));
				p.setPRO_DES(rs.getString(3));
				p.setPRO_PRE(rs.getDouble(4));
				p.setPRO_EST(rs.getString(5));
				p.setPRO_IMG(rs.getString(6));
				p.setCAT_PRO_ID(rs.getInt(7));
				p.setAUD_TIPO(rs.getString(8));
				p.setAUD_IDUSUARIO(rs.getInt(9));
				p.setAUD_SESION(rs.getString(10));
				p.setAUD_FECHA(rs.getString(11));
				p.setAUD_IP(rs.getString(12));
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

	@Override
	public int registrarProducto(ProductoBean p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {

			con = new MySQLConexion().getConexion();
			String sql = "insert into TB_PRODUCTO values(null,?,?,?,default,null,?,null,null,null,null,null)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, p.getPRO_NOM());
			pst.setString(2, p.getPRO_DES());
			pst.setDouble(3, p.getPRO_PRE());
			pst.setInt(4, p.getCAT_PRO_ID());

			rs = pst.executeUpdate();
			System.out.println(rs);
		} catch (Exception e) {

			System.out.println("Error al agregar " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return rs;
	}


	@Override
	public int actualizarProducto(ProductoBean p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "update TB_PRODUCTO set PRO_NOM=?,PRO_DES=?,PRO_PRE=?,PRO_EST=?, CAT_PRO_ID=? where PRO_ID=?;" ;

			pst = con.prepareStatement(sql);
			pst.setString(1, p.getPRO_NOM());
			pst.setString(2, p.getPRO_DES());
			pst.setDouble(3, p.getPRO_PRE());
			pst.setString(4, p.getPRO_EST());
			pst.setInt(5, p.getCAT_PRO_ID());
			pst.setInt(6, p.getPRO_ID());

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
	public int eliminarProducto(ProductoBean p) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "delete from TB_PRODUCTO where PRO_ID=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getPRO_ID());

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
	public ProductoBean listarByID(int id) {
		ProductoBean pro = new ProductoBean();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "select PRO_ID,PRO_NOM,PRO_DES,PRO_PRE,PRO_EST,CAT_PRO_ID,PRO_IMG from TB_PRODUCTO where PRO_ID= ?;";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				pro = new ProductoBean();
				pro.setPRO_ID(rs.getInt(1));
				pro.setPRO_NOM(rs.getString(2));
				pro.setPRO_DES(rs.getString(3));
				pro.setPRO_PRE(rs.getDouble(4));
				pro.setPRO_EST(rs.getString(5));
				pro.setCAT_PRO_ID(rs.getInt(6));
				pro.setCAT_PRO_ID(rs.getInt(6));
				pro.setPRO_IMG(rs.getString(7));
				return pro;
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
		return pro;
	}

	@Override
	public ArrayList<ProductoBean> listarProductosVenta() {
		ArrayList<ProductoBean> lista = new ArrayList<ProductoBean>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "select PRO_ID,PRO_NOM,PRO_IMG,PRO_PRE from TB_PRODUCTO where PRO_EST='1';";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProductoBean p = new ProductoBean();
				p.setPRO_ID(rs.getInt(1));
				p.setPRO_NOM(rs.getString(2));
				p.setPRO_IMG(rs.getString(3));
				p.setPRO_PRE(rs.getDouble(4));
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

}
