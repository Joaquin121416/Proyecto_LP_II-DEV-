package com.sistema.comidas.bean;

import java.util.Date;

public class DocumentoCompraBean extends GenericoBean{
	
	private int doc_ven_id;
	
	private int cli_id;
	
	private int usu_id;
	
	private Date doc_ven_fec;
	
	private double doc_ven_tot;
	
	public int getDoc_ven_id() {
		return doc_ven_id;
	}

	public void setDoc_ven_id(int doc_ven_id) {
		this.doc_ven_id = doc_ven_id;
	}

	public int getCli_id() {
		return cli_id;
	}

	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public Date getDoc_ven_fec() {
		return doc_ven_fec;
	}

	public void setDoc_ven_fec(Date doc_ven_fec) {
		this.doc_ven_fec = doc_ven_fec;
	}

	public double getDoc_ven_tot() {
		return doc_ven_tot;
	}

	public void setDoc_ven_tot(double doc_ven_tot) {
		this.doc_ven_tot = doc_ven_tot;
	}

	public String getDoc_ven_est() {
		return doc_ven_est;
	}

	public void setDoc_ven_est(String doc_ven_est) {
		this.doc_ven_est = doc_ven_est;
	}

	private String doc_ven_est;
}
	

