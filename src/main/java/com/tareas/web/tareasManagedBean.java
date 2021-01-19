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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author user
 */
@Named(value = "tareasMB")
@ViewScoped
public class tareasManagedBean implements Serializable {
    
    private Usuario usuario;
    private int id;
    
    //inyectar el managedBean de session llamado UsuarioManagedBean
    @Inject
    private LoginManagedBean usuarioMb;
    
    private Tarea selectTarea;
    private int idTarea;
    private Collection<Tarea> tareasHacer;
    private Collection<Tarea> tareasProgreso;
    private Collection<Tarea> tareasHechas;
   
    private TareasService tareasServ = new TareasService();
    
    
    public tareasManagedBean() {
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println( "Iniciando tareas por usuario");
        if(usuarioMb.getUsuario() != null){
            usuario= usuarioMb.getUsuarioCompleto();
            id = usuario.getIdUsuario();
        } else {
            System.out.println("Aun no tienes tareas para mostrar");
        }
    }

    public Tarea getSelectTarea() {
        return selectTarea;
    }

    public void setSelectTarea(Tarea selectTarea) {
        this.selectTarea = selectTarea;
    }
    
     public Collection<Tarea> getCollecionHacer() {
         this.tareasHacer = tareasServ.tareasCollection(id, "Hacer");
         System.out.println(".....OBTENIENDO TAREAS HACER ");
         
        return tareasHacer;
    }
    
      public Collection<Tarea> getCollecionEnProgreso() {
           this.tareasProgreso = tareasServ.tareasCollection(id, "En Progreso");
           System.out.println(".....OBTENIENDO TAREAS PROGRESO");
        return tareasProgreso;
    }
       public Collection<Tarea> getCollecionHechas() {
           this.tareasHechas = tareasServ.tareasCollection(id, "Hecho");
           System.out.println(".....OBTENIENDO TAREAS HECHAS");
        return tareasHechas;
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
