package com.sistema.comidas.bean;

public class ProveedorBean {
	
	private int PROV_ID, AUD_IDUSUARIO,AUD_FECHA,PROV_COD_RUC,PROV_NUM_TEL,PROV_ESTADO,AUD_TIPO;
	@Override
	public String toString() {
		return "ProveedorBean [PROV_ID=" + PROV_ID + ", AUD_IDUSUARIO=" + AUD_IDUSUARIO + ", AUD_FECHA=" + AUD_FECHA
				+ ", PROV_COD_RUC=" + PROV_COD_RUC + ", PROV_NUM_TEL=" + PROV_NUM_TEL + ", PROV_ESTADO=" + PROV_ESTADO
				+ ", PROV_EST="  + ", AUD_TIPO=" + AUD_TIPO + ", PROV_NOM=" + PROV_NOM + ", AUD_IP=" + AUD_IP
				+ ", AUD_SESION=" + AUD_SESION + "]";
	}
	private String PROV_NOM,AUD_IP,AUD_SESION;
	public String getAUD_SESION() {
		return AUD_SESION;
	}
	public void setAUD_SESION(String aUD_SESION) {
		AUD_SESION = aUD_SESION;
	}
	public int getPROV_ID() {
		return PROV_ID;
	}
	public void setPROV_ID(int pROV_ID) {
		PROV_ID = pROV_ID;
	}
	public int getAUD_IDUSUARIO() {
		return AUD_IDUSUARIO;
	}
	public void setAUD_IDUSUARIO(int aUD_IDUSUARIO) {
		AUD_IDUSUARIO = aUD_IDUSUARIO;
	}
	public int getAUD_FECHA() {
		return AUD_FECHA;
	}
	public void setAUD_FECHA(int aUD_FECHA) {
		AUD_FECHA = aUD_FECHA;
	}
	public int getPROV_COD_RUC() {
		return PROV_COD_RUC;
	}
	public void setPROV_COD_RUC(int pROV_COD_RUC) {
		PROV_COD_RUC = pROV_COD_RUC;
	}
	public int getPROV_NUM_TEL() {
		return PROV_NUM_TEL;
	}
	public void setPROV_NUM_TEL(int pROV_NUM_TEL) {
		PROV_NUM_TEL = pROV_NUM_TEL;
	}
	public int getPROV_ESTADO() {
		return PROV_ESTADO;
	}
	public void setPROV_ESTADO(int pROV_ESTADO) {
		PROV_ESTADO = pROV_ESTADO;
	}
	public int getAUD_TIPO() {
		return AUD_TIPO;
	}
	public void setAUD_TIPO( int aUD_TIPO ) {
		AUD_TIPO = aUD_TIPO;
	}
	public String getPROV_NOM() {
		return PROV_NOM;
	}
	public void setPROV_NOM(String pROV_NOM) {
		PROV_NOM = pROV_NOM;
	}
	public String getAUD_IP() {
		return AUD_IP;
	}
	public void setAUD_IP(String aUD_IP) {
		AUD_IP = aUD_IP;
	}



}
