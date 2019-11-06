package com.sistema.comidas.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sistema.comidas.bean.UsuarioBean;

public class UsuarioTest {

	public UsuarioBean usuarioBean;

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean user) {
		this.usuarioBean = user;
	}

	@PostConstruct
	public void init() {

		this.setUsuarioBean(new UsuarioBean());

	}

	@SuppressWarnings("deprecation")
	public void Validar() {
		try {/*
				 * this.setUsuarioService(usuarioService); UsuarioBean oUsuarioBean = new
				 * UsuarioBean(); oUsuarioBean.setUsuario("ADMIN");
				 * oUsuarioBean.setClave("KhcE1Gejlz0="); UsuarioBean user = new UsuarioBean();
				 * user = this.getUsuarioBean(); user =
				 * this.getUsuarioService().validarAcceso(oUsuarioBean);
				 * System.out.println("pase"); System.out.println(user.toString());
				 * System.out.println(oUsuarioBean.toString());
				 * System.out.println(" no pinte pero  pase"); Assert.assertSame(oUsuarioBean,
				 * user);
				 */
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
