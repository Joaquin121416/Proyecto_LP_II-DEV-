package com.sistema.comidas.test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.sistema.comidas.util.Encrypt;

public class MainEncrypt {
	
	public static void main(String args[]) throws GeneralSecurityException, IOException{
	
		String clave="Nicolas1212";
		Encrypt.init("C1b3rT3c");
		System.out.println(Encrypt.encrypt(clave));
		//System.out.println(Encrypt.decrypt("KhcE1Gejlz0="));
		
		//xdlOnb5Nv0M=
		//KEu8xB5eqcs=

		
	}

}
