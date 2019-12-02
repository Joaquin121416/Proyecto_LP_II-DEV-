package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.CategoriaProductoBean;
import com.sistema.comidas.bean.UsuarioBean;
import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.test.Bin;
import com.sistema.comidas.util.Encrypt;
import com.sistema.comidas.util.MySQLConexion;
import com.sistema.comidas.util.Net;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public int agregarUsuario(UsuarioBean user) {


		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "INSERT INTO TB_USUARIO  VALUES(NULL, ?, ?, ?, ?, ?, ?, ?,SYSDATE(),?,1,'N',1,'Sesion01',sysdate(),?)";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getNombre());
			pstm.setString(2, user.getApellido());
			pstm.setString(3, user.getUsuario());
			pstm.setString(4, user.getClave());
			pstm.setInt(5, user.getTip_doc_id());
			pstm.setInt(6, Integer.parseInt(user.getUsu_doc()));
			pstm.setInt(7, user.getUsu_rol_id());
			pstm.setString(8, user.getUsu_img());
			pstm.setString(9, user.getAud_ip());
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
	public ArrayList<UsuarioBean> listarUsuario() {

		ArrayList<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select USU_ID,USU_NOM,USU_APE,USU_USU,TIP_DOC_ID,USU_DOC_NUM,ROL_ID from TB_USUARIO where USU_EST=?;";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 1);
			res = pstm.executeQuery();
			while (res.next()) {
				UsuarioBean user = new UsuarioBean();
				user.setUsuario_id(res.getInt(1));
				user.setNombre(res.getString(2));
				user.setApellido(res.getString(3));
				user.setUsuario(res.getString(4));
				user.setTip_doc_id(res.getInt(5));
				user.setUsu_doc(res.getString(6));
				user.setUsu_rol_id(res.getInt(7));
				lista.add(user);
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
	public int modificarUsuario(UsuarioBean u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySQLConexion().getConexion();
			String sql = "update TB_USUARIO set USU_NOM=?,USU_APE=?,USU_USU=?, TIP_DOC_ID=?, USU_DOC_NUM=?,ROL_ID=? where USU_ID=?" ;

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setInt(4, u.getTip_doc_id());
			pst.setString(5, u.getUsu_doc());
			pst.setInt(6, u.getUsu_rol_id());
			pst.setInt(7, u.getUsuario_id());

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
	public int eliminarUsuario(UsuarioBean user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioBean listarByID(int id) {
		UsuarioBean usuario = new UsuarioBean();
		ResultSet res = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "select USU_ID,USU_NOM,USU_APE,USU_USU,TIP_DOC_ID,USU_DOC_NUM,ROL_ID from TB_USUARIO where USU_EST=? and USU_ID= ?;";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 1);
			pstm.setInt(2, id);
			res = pstm.executeQuery();
			while (res.next()) {
				usuario.setUsuario_id(res.getInt(1));
				usuario.setNombre(res.getString(2));
				usuario.setApellido(res.getString(3));
				usuario.setUsuario(res.getString(4));
				usuario.setTip_doc_id(res.getInt(5));
				usuario.setUsu_doc(res.getString(6));
				usuario.setUsu_rol_id(res.getInt(7));
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
		return usuario;
	
	}

	
}
