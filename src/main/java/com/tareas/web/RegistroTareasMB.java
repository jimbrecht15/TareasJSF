/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.ExcepcionDBTareas;
import com.tareas.modelo.Tarea;
import com.tareas.modelo.Usuario;
import com.tareas.servicios.TareasService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "registroTareasMB")
@RequestScoped
public class RegistroTareasMB {

    private Usuario usuario;
    private String definicion;
    private String estado;
    private int id;
    
    //inyectar el managedBean de session llamado UsuarioManagedBean
    @Inject
    private LoginManagedBean usuarioMb;
    
     @EJB
    private TareasService tareasServ;  // =new TareasService();
    
    private Tarea selectTarea;
    
    public RegistroTareasMB() {
    }
 
    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String agregarTarea(){
          FacesContext ctx = FacesContext.getCurrentInstance();
          
          try {
              tareasServ.agregarTarea(selectTarea);
              FacesMessage msg = new FacesMessage("Has agregado una tarea ");
                ctx.addMessage(null, msg);
            return "tareas";
          } catch (ExcepcionDBTareas ex) {
            FacesMessage msg = new FacesMessage("No se ha agregado la tarea" + ex.getMessage());
            ctx.addMessage(null, msg);
          }
          return null;
      }
    
}
