/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.excepciones.ExcepcionDBTareas;
import com.tareas.modelo.Tarea;
import com.tareas.servicios.TareasService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "cambiarEstadoMB")
@ViewScoped
public class CambiarEstadoMB {

 private Tarea selectTarea;
    private int idTarea;
     private TareasService tareasServ = new TareasService();
   
    public CambiarEstadoMB() {
    }

    public Tarea getSelectTarea() {
        return selectTarea;
    }

    public void setSelectTarea(Tarea selectTarea) {
        this.selectTarea = selectTarea;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public TareasService getTareasServ() {
        return tareasServ;
    }

    public void setTareasServ(TareasService tareasServ) {
        this.tareasServ = tareasServ;
    }

        
     public String  cambiarEstadoUp(){
         this.idTarea = this.selectTarea.getId();
         FacesContext ctx = FacesContext.getCurrentInstance();
    
          try {
            tareasServ.cambiarEstadoUp(idTarea);
            FacesMessage msg = new FacesMessage("Cambiaste el estado de la tarea ");
            ctx.addMessage(null, msg);
            return "tareas";
        } catch (ExcepcionDBTareas ex) {
            Logger.getLogger(CambiarEstadoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
     
      public String  cambiarEstadoDown(){
         this.idTarea = this.selectTarea.getId();
         FacesContext ctx = FacesContext.getCurrentInstance();
    
          try {
            tareasServ.cambiarEstadoDown(idTarea);
            FacesMessage msg = new FacesMessage("Cambiaste el estado de la tarea ");
            ctx.addMessage(null, msg);
            return "tareas";
        } catch (ExcepcionDBTareas ex) {
            Logger.getLogger(CambiarEstadoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
