package com.sistema.comidas.bean;

public class UsuarioBean extends GenericoBean{

	private String usuario;

	private String clave;

	private String nombre;


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


	
}