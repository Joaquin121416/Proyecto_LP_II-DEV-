package com.sistema.comidas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sistema.comidas.presentacion.GenericoMB;

public class MySQLConexion extends GenericoMB {
	String dri = super.getStringProp("jdbc.driverClassName");
	String url = super.getStringProp("jdbc.url");
	String usr = super.getStringProp("jdbc.username");
	String psw = super.getStringProp("jdbc.password");

	public Connection getConexion() {
		Connection con = null;
		try {
			Class.forName(dri); // instanciamiento de la clase del driver
			String url = this.url;// variable String que contiene los datos del servidor
			String usr = this.usr;// variable String que contiene el dato del usuario
			String psw = this.psw;// variable String que contiene el dato del password
			con = DriverManager.getConnection(url, usr, psw);// con este método se establece la conexión con el servidor
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD");
			e.printStackTrace();
		}
		return con;
	}

	public void closeConexion(Connection con) {

		try {
			con.close();// Sentencia para cerrar la conexión
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar la conexion");
		}
	}

	public void closeStatement(Statement stmt) {

		try {
			stmt.close();// sentencia para cerrar el statement
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar el statement");
		}
	}

}
