package com.sistema.comidas.bean;

public class CategoriaProducto {

	private int cat_pro_id;

	private String cat_pro_nom;

	private String cat_pro_des;

	private String cat_pro_est;


	public CategoriaProducto(int cat_pro_id, String cat_pro_nom, String cat_pro_des, String cat_pro_est) {
		super();
		this.cat_pro_id = cat_pro_id;
		this.cat_pro_nom = cat_pro_nom;
		this.cat_pro_des = cat_pro_des;
		this.cat_pro_est = cat_pro_est;
	}

	public String getCat_pro_est() {
		return cat_pro_est;
	}

	public void setCat_pro_est(String cat_pro_est) {
		this.cat_pro_est = cat_pro_est;
	}

	public int getCat_pro_id() {
		return cat_pro_id;
	}

	public void setCat_pro_id(int cat_pro_id) {
		this.cat_pro_id = cat_pro_id;
	}

	public String getCat_pro_nom() {
		return cat_pro_nom;
	}

	public void setCat_pro_nom(String cat_pro_nom) {
		this.cat_pro_nom = cat_pro_nom;
	}

	public String getCat_pro_des() {
		return cat_pro_des;
	}

	public void setCat_pro_des(String cat_pro_des) {
		this.cat_pro_des = cat_pro_des;
	}

	@Override
	public String toString() {
		return "CategoriaProducto [cat_pro_id=" + cat_pro_id + ", cat_pro_nom=" + cat_pro_nom + ", cat_pro_des="
				+ cat_pro_des + "]";
	}

}
