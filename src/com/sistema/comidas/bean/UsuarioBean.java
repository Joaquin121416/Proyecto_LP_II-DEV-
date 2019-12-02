package com.sistema.comidas.bean;

import java.io.File;
import java.sql.Date;

public class UsuarioBean {
	private int usuario_id;
	
	private String nombre;
	
	private String apellido;
	
	private String usuario;

	private String clave;
	
	private int tip_doc_id;
	
	private String usu_doc;
	
	private int usu_rol_id;
	
	private Date usu_fec_con;
	
	private File usu_img;
	
	private String usuario_est;
	
	private String aud_tipo;
	
	private int aud_id_usuario;
	
	private String aud_sesion;
	
	private Date aud_fecha;

	private String aud_ip;
	

	public String getUsu_doc() {
		return usu_doc;
	}


	public void setUsu_doc(String usu_doc) {
		this.usu_doc = usu_doc;
	}


	public int getUsu_rol_id() {
		return usu_rol_id;
	}


	public void setUsu_rol_id(int usu_rol_id) {
		this.usu_rol_id = usu_rol_id;
	}


	public String getAud_ip() {
		return aud_ip;
	}


	public void setAud_ip(String aud_ip) {
		this.aud_ip = aud_ip;
	}


	public UsuarioBean() {
	}


	public UsuarioBean(String usuario, String clave, String nombre) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "UsuarioBean [usuario=" + usuario + ", clave=" + clave
				+ ", nombre=" + nombre + "]";
	}


	public int getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getTip_doc_id() {
		return tip_doc_id;
	}


	public void setTip_doc_id(int tip_doc_id) {
		this.tip_doc_id = tip_doc_id;
	}


	public Date getUsu_fec_con() {
		return usu_fec_con;
	}


	public void setUsu_fec_con(Date usu_fec_con) {
		this.usu_fec_con = usu_fec_con;
	}



	public File getUsu_img() {
		return usu_img;
	}


	public void setUsu_img(File usu_img) {
		this.usu_img = usu_img;
	}


	public String getUsuario_est() {
		return usuario_est;
	}


	public void setUsuario_est(String usuario_est) {
		this.usuario_est = usuario_est;
	}


	public String getAud_tipo() {
		return aud_tipo;
	}


	public void setAud_tipo(String aud_tipo) {
		this.aud_tipo = aud_tipo;
	}


	public int getAud_id_usuario() {
		return aud_id_usuario;
	}


	public void setAud_id_usuario(int aud_id_usuario) {
		this.aud_id_usuario = aud_id_usuario;
	}


	public String getAud_sesion() {
		return aud_sesion;
	}


	public void setAud_sesion(String aud_sesion) {
		this.aud_sesion = aud_sesion;
	}


	public Date getAud_fecha() {
		return aud_fecha;
	}


	public void setAud_fecha(Date aud_fecha) {
		this.aud_fecha = aud_fecha;
	}


	 
}