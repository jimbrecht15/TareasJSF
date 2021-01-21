/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import com.tareas.servicios.NuevoUsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
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

    //@EJB
    private NuevoUsuarioService servicioNuevoUsuario = new NuevoUsuarioService();
    
    private Usuario nuevoUsuario;
    private String mensajeExisteEmail = "";
    
    public RegistrarUsuarioMB() {
        this.nuevoUsuario = new Usuario();
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
        
        try {
            //grabar en bd
            servicioNuevoUsuario.altaUsuario(nuevoUsuario);
            return "login";
        } catch (ExcepcionDBUsuarios ex) {
             System.out.println("... no grabo usuario " + ex.getMessage());
             return "registrar";
        }
    }
    
    
}
