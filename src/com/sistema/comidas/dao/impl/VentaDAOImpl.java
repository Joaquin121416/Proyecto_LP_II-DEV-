package com.sistema.comidas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistema.comidas.bean.DetalleCompraBean;
import com.sistema.comidas.bean.DetalleVentaBean;
import com.sistema.comidas.bean.DocumentoCompraBean;
import com.sistema.comidas.bean.DocumentoVentaBean;
import com.sistema.comidas.dao.GenericoDAO;
import com.sistema.comidas.dao.VentaDAO;
import com.sistema.comidas.dao.factory.Factory;
import com.sistema.comidas.util.MySQLConexion;

public class VentaDAOImpl implements VentaDAO{

	@Override
	public int RealizarVenta(ArrayList<DetalleVentaBean> det,DocumentoVentaBean doc) {
	
		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "INSERT INTO TB_DOCUMENTO_DE_VENTA  VALUES(NULL, ?, ?, sysdate(),?,'1',null,null,null,null,null);";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, doc.getCli_id());
			pstm.setInt(2, doc.getUsu_id());
			pstm.setDouble(3, doc.getDoc_ven_tot());
			res = pstm.executeUpdate();
				
			for (DetalleVentaBean detalleVentaBean : det) {
				Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
				GenericoDAO dao = bd.getGenericoDAO();
				int COD =dao.consultarCodigo("TB_DOCUMENTO_DE_VENTA", "DOC_VEN_ID");
				String sql2 = "INSERT INTO TB_DETALLE_DE_DOCUMENTO_VENTA  VALUES(NULL,"+COD+", ?, ?,?,null,?);";
				pstm = conn.prepareStatement(sql2);
				pstm.setInt(1, detalleVentaBean.getPro_id());
				pstm.setDouble(2, detalleVentaBean.getDet_doc_ven_pre());
				pstm.setInt(3, detalleVentaBean.getDet_doc_ven_can());
				pstm.setDouble(4, detalleVentaBean.getDet_doc_ven_can()*detalleVentaBean.getDet_doc_ven_pre());
				res = pstm.executeUpdate();	
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.setAutoCommit(false);
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
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
	public int RealizarCompra(ArrayList<DetalleCompraBean> deta,DocumentoCompraBean doc) {
	
		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySQLConexion().getConexion();
			String sql = "INSERT INTO TB_DOCUMENTO_COMPRA VALUES(NULL, ?, ?, sysdate(),'1',null,null,null,null,null);";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, doc.getUsu_id());
			pstm.setInt(2, doc.getCli_id());
			res = pstm.executeUpdate();
				
			for (DetalleCompraBean det : deta) {
				Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
				GenericoDAO dao = bd.getGenericoDAO();
				int COD =dao.consultarCodigo("TB_DOCUMENTO_COMPRA", "DOC_COM_ID");
				String sql2 = "INSERT INTO TB_DETALLE_DE_DOCUMENTO_COMPRA  VALUES(NULL,"+COD+", ?, ?,?,default,?);";
				pstm = conn.prepareStatement(sql2);
				pstm.setInt(1, det.getIns_id());
				pstm.setDouble(2, det.getDet_doc_ven_pre());
				pstm.setInt(3, det.getDet_doc_ven_can());
				pstm.setDouble(4, det.getDet_doc_ven_can()*det.getDet_doc_ven_pre());
				res = pstm.executeUpdate();	
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.setAutoCommit(false);
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
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
