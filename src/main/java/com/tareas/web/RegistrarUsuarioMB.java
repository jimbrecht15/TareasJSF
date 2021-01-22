/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import com.tareas.servicios.NuevoUsuarioInterface;
import com.tareas.servicios.NuevoUsuarioService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "registrarUsuarioMB")
@ViewScoped
public class RegistrarUsuarioMB implements Serializable{

    @EJB
    private NuevoUsuarioInterface servicioNuevoUsuario; //= new NuevoUsuarioService();
    
    private Usuario nuevoUsuario = new Usuario();;
    private String mensajeExisteEmail = "";
    
    public RegistrarUsuarioMB() {
        System.out.println(".... constructor");
    }

    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public String getMensajeExisteEmail() {
         System.out.println("....¿existe  " + nuevoUsuario.getMail() + "?");
         if( nuevoUsuario.getMail()!= null 
                 && servicioNuevoUsuario.existeEmail(nuevoUsuario.getMail())){
             mensajeExisteEmail = "El email ya existe";
         }else{
             mensajeExisteEmail = "";
         }
        return mensajeExisteEmail;
    }
    
    public String altaUsuario(){
         FacesContext ctx = FacesContext.getCurrentInstance();
         String mnsAlta = "";
         
        try {
            //grabar en bd
            servicioNuevoUsuario.altaUsuario(nuevoUsuario);
            mnsAlta = "Nuevo usuario creado. Puedes hacer el Login ";
            FacesMessage mns = new FacesMessage(mnsAlta);
            ctx.addMessage(null, mns);
            return "login";
        } catch (ExcepcionDBUsuarios ex) {
             System.out.println("... no grabo usuario " + ex.getMessage());
            FacesMessage mns = new FacesMessage(ex.getMessage());
            ctx.addMessage(null, mns);
             return "registrar";
        }
    }
    
    
}
