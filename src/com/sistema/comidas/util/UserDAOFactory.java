package com.sistema.comidas.util;

import com.sistema.comidas.dao.UsuarioDAO;
import com.sistema.comidas.dao.impl.UsuarioDAOImpl;

public class UserDAOFactory {
    public static UsuarioDAO getUserDAO(String type) { 
        if (type.equalsIgnoreCase("jdbc")) {
            return (UsuarioDAO) new UsuarioDAOImpl();
        } else {
            return (UsuarioDAO) new UsuarioDAOImpl();
        }
    }
}