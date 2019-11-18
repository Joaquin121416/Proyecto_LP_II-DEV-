package com.sistema.comidas.filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;

import com.sistema.comidas.bean.UsuarioBean;

@WebFilter("/*")
@Scope(value = "session")
public class LoginFilter implements Filter, ServletContextListener {

	public LoginFilter() {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		HttpSession session = request.getSession(false);

		System.out.println("doFilter...");

		UsuarioBean usuarioBean = (session != null) ? (UsuarioBean) session.getAttribute("usuario") : null;

		String loginURL = request.getContextPath() + "/Login.jsp";
		String resourcesURL = request.getContextPath() + "/resources";
		String resourcesFaces = request.getContextPath() + "/" + ResourceHandler.RESOURCE_IDENTIFIER;
		String ServletURL = request.getContextPath() + "/Ingreso";

		boolean loginRequest = request.getRequestURI().startsWith(loginURL);
		boolean resourcesRequest = request.getRequestURI().startsWith(resourcesURL);	
		boolean resourceRequest = request.getRequestURI().startsWith(resourcesFaces);
		boolean servletRequest = request.getRequestURI().startsWith(ServletURL);

		if (usuarioBean != null || loginRequest || resourceRequest || resourcesRequest || servletRequest) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(loginURL);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

	}

}
