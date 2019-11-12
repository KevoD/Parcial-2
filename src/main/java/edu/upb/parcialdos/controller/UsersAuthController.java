/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.parcialdos.controller;

import edu.upb.parcialdos.controller.dao.UsersDAO;
import edu.upb.parcialdos.model.Users;
import edu.upb.parcialdos.util.PasswordUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;

/**
 *
 * @author Carlos
 */
@Named(value = "usersAuthController")
@SessionScoped
public class UsersAuthController implements Serializable {

    /**
     * Creates a new instance of UsersAuthController
     */
    private Users actual;
    private Users loggedUser;

    @EJB
    private UsersDAO ejbFacade;

    public UsersAuthController() {
    }

    public String login() {

        Users result = ejbFacade.loginAuth(actual);

        if (result == null) {
            loggedUser = null;
            return "login?faces-redirect=true";
        } else {
            loggedUser = result;
            return "index?faces-redirect=true";
        }
    }
    
    public String autpassword(String password){
        //metodo de comparar las contraseñas
        String contraseña = actual.getUserpassword();
        //usar metodo de la clase Passworutil, guardar despues
        return contraseña;
        
    }    public String autpassword2(String password) throws NoSuchAlgorithmException{
        //metodo de solo edicion de contraseña, solo cifrado
        String contraseña = actual.getUserpassword();
        String securePassword = PasswordUtil.securePassword(password);
        return password;
        
    }
}
    
