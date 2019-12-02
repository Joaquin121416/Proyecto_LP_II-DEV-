package com.sistema.comidas.bean;

public class DetalleVentaBean {
	private int det_doc_ven_id;
	
	private int doc_ven_id;
	
	private int pro_id;
	
	private double det_doc_ven_pre;
	
	private int det_doc_ven_can;
	
	private double igv;

	public int getDet_doc_ven_id() {
		return det_doc_ven_id;
	}

	public void setDet_doc_ven_id(int det_doc_ven_id) {
		this.det_doc_ven_id = det_doc_ven_id;
	}

	public int getDoc_ven_id() {
		return doc_ven_id;
	}

	public void setDoc_ven_id(int doc_ven_id) {
		this.doc_ven_id = doc_ven_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public double getDet_doc_ven_pre() {
		return det_doc_ven_pre;
	}

	public void setDet_doc_ven_pre(double det_doc_ven_pre) {
		this.det_doc_ven_pre = det_doc_ven_pre;
	}

	public int getDet_doc_ven_can() {
		return det_doc_ven_can;
	}

	public void setDet_doc_ven_can(int det_doc_ven_can) {
		this.det_doc_ven_can = det_doc_ven_can;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

}
