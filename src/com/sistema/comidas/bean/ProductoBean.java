package com.sistema.comidas.bean;

public class ProductoBean {
	private int PRO_ID;
	private String PRO_NOM;
	private String PRO_DES;
	private double PRO_PRE;
	private String PRO_EST;
	private String PRO_IMG;
	private int CAT_PRO_ID;
	private String AUD_TIPO;
	private int AUD_IDUSUARIO;
	private String AUD_SESION;
	private String AUD_FECHA;
	private String AUD_IP;
	public int getPRO_ID() {
		return PRO_ID;
	}
	public void setPRO_ID(int pRO_ID) {
		PRO_ID = pRO_ID;
	}
	public String getPRO_NOM() {
		return PRO_NOM;
	}
	public void setPRO_NOM(String pRO_NOM) {
		PRO_NOM = pRO_NOM;
	}
	public String getPRO_DES() {
		return PRO_DES;
	}
	public void setPRO_DES(String pRO_DES) {
		PRO_DES = pRO_DES;
	}
	public double getPRO_PRE() {
		return PRO_PRE;
	}
	public void setPRO_PRE(double pRO_PRE) {
		PRO_PRE = pRO_PRE;
	}
	public String getPRO_EST() {
		return PRO_EST;
	}
	public void setPRO_EST(String pRO_EST) {
		PRO_EST = pRO_EST;
	}
	public String getPRO_IMG() {
		return PRO_IMG;
	}
	public void setPRO_IMG(String pRO_IMG) {
		PRO_IMG = pRO_IMG;
	}
	public int getCAT_PRO_ID() {
		return CAT_PRO_ID;
	}
	public void setCAT_PRO_ID(int cAT_PRO_ID) {
		CAT_PRO_ID = cAT_PRO_ID;
	}
	public String getAUD_TIPO() {
		return AUD_TIPO;
	}
	public void setAUD_TIPO(String aUD_TIPO) {
		AUD_TIPO = aUD_TIPO;
	}
	public int getAUD_IDUSUARIO() {
		return AUD_IDUSUARIO;
	}
	public void setAUD_IDUSUARIO(int aUD_IDUSUARIO) {
		AUD_IDUSUARIO = aUD_IDUSUARIO;
	}
	public String getAUD_SESION() {
		return AUD_SESION;
	}
	public void setAUD_SESION(String aUD_SESION) {
		AUD_SESION = aUD_SESION;
	}
	public String getAUD_FECHA() {
		return AUD_FECHA;
	}
	public void setAUD_FECHA(String aUD_FECHA) {
		AUD_FECHA = aUD_FECHA;
	}
	public String getAUD_IP() {
		return AUD_IP;
	}
	public void setAUD_IP(String aUD_IP) {
		AUD_IP = aUD_IP;
	}
	@Override
	public String toString() {
		return "ProductoBean [PRO_ID=" + PRO_ID + ", PRO_NOM=" + PRO_NOM + ", PRO_DES=" + PRO_DES + ", PRO_PRE="
				+ PRO_PRE + ", PRO_EST=" + PRO_EST + ", PRO_IMG=" + PRO_IMG + ", CAT_PRO_ID=" + CAT_PRO_ID
				+ ", AUD_TIPO=" + AUD_TIPO + ", AUD_IDUSUARIO=" + AUD_IDUSUARIO + ", AUD_SESION=" + AUD_SESION
				+ ", AUD_FECHA=" + AUD_FECHA + ", AUD_IP=" + AUD_IP + "]";
	}
	
	
	
}
