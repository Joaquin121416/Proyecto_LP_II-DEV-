package com.sistema.comidas.bean;

public class DetalleCompraBean {

private int DET_DOC_COM_ID;
	
	private int DOC_COM_ID;
	
	private int ins_id;
	
	private double det_doc_ven_pre;
	
	private int det_doc_ven_can;
	
	private double igv;

	public int getDET_DOC_COM_ID() {
		return DET_DOC_COM_ID;
	}

	public void setDET_DOC_COM_ID(int dET_DOC_COM_ID) {
		DET_DOC_COM_ID = dET_DOC_COM_ID;
	}

	public int getDOC_COM_ID() {
		return DOC_COM_ID;
	}

	public void setDOC_COM_ID(int dOC_COM_ID) {
		DOC_COM_ID = dOC_COM_ID;
	}

	public int getIns_id() {
		return ins_id;
	}

	public void setIns_id(int ins_id) {
		this.ins_id = ins_id;
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
