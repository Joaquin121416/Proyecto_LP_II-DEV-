package com.sistema.comidas.bean;

public class InsumosBean extends GenericoBean{
      private int INS_ID ;
	  private  String INS_NOM,INS_DES;
	  private  double INS_PRE;

public InsumosBean() {
		}

	public  InsumosBean(int INS_ID, String INS_NOM, String INS_DES,double INS_PRE ) {
		super();
		this.INS_ID = INS_ID;
		this.INS_NOM = INS_NOM;
		this.INS_DES = INS_DES;
		this.INS_PRE = INS_PRE;
	}
	public int getINS_ID() {
		return INS_ID;
	}
	public void setINS_ID(int iNS_ID) {
		INS_ID = iNS_ID;
	}
	public String getINS_DES() {
		return INS_DES;
	}
	public void setINS_DES(String iNS_DES) {
		INS_DES = iNS_DES;
	}
	public String getINS_NOM() {
		return INS_NOM;
	}
	public void setINS_NOM(String iNS_NOM) {
		INS_NOM = iNS_NOM;
	}
	public double getINS_PRE() {
		return INS_PRE;
	}
	public void setINS_PRE(double iNS_PRE) {
		INS_PRE = iNS_PRE;
	}
	@Override
	public String toString() {
		return "InsumosBean [INS_ID=" + INS_ID + ", INS_DES=" + INS_DES + ", INS_NOM=" + INS_NOM + ", INS_PRE="
				+ INS_PRE + "]";
	}
}