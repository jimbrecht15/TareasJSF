/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.LoginException;
import com.tareas.modelo.Usuario;
import com.tareas.servicios.LoginService;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginManagedBean implements Serializable{

    private String usuario;
    private String clave;
    private Usuario usuarioCompleto;
    private Date fecha = new Date();
    
    public LoginManagedBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioCompleto() {
        return usuarioCompleto;
    }

    public void setUsuarioCompleto(Usuario usuarioCompleto) {
        this.usuarioCompleto = usuarioCompleto;
    }
    
    
    
     public String login() {
        
        LoginService loginService = new LoginService();
        //obtener la sesion de JSF 
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        try {
            loginService.login(usuario, clave, session);
            usuarioCompleto = (Usuario) session.getAttribute("usuario");
            return "tareas.xhtml";

        } catch (LoginException e) {
            this.usuario = "";
            this.clave = "";

            //mns de error para mostrar en el formulario 
            FacesMessage mns = new FacesMessage(e.getMessage());
            //ctx.addMessage("formLogin:psw", mns);
            ctx.addMessage(null, mns);

            return "login.xhtml";
        }
    }

    public String logout() {
        
        LoginService ls = new LoginService();
        //obtener la sesion de JSF 
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) ctx.getExternalContext().getSession(true);
        ls.logout(sesion);
        
        return "login?faces-redirect=true";
    }

    
}
