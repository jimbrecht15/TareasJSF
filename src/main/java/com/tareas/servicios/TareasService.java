/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBTareas;
import com.tareas.modelo.Tarea;
import com.tareas.modelo.Tareas2;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TareasService {

    @PersistenceContext(unitName = "tareasPersist" )
    private EntityManager em;
    
    public TareasService() {
    }
      
    @PostConstruct
    public void iniciar(){
        System.out.println("... en el postconstruct");
    }
    
    public void altaTarea(Tarea tarea) throws ExcepcionDBTareas{
        DBTareas.addTarea(tarea);
    }
    
    public Collection<Tarea> tareasCollection(int id, String estado){
        return DBTareas.listaTareasUsuario(id, estado);
    }
    
    public void cambiarEstadoUp (int id)throws ExcepcionDBTareas{
        DBTareas.cambiarEstadoUp(id);
    }
    
    public void cambiarEstadoDown (int id)throws ExcepcionDBTareas{
        DBTareas.cambiarEstadoDown(id);
    }
    
    public void agregarTarea (Tarea tarea) throws ExcepcionDBTareas{
        DBTareas.addTarea(tarea);
    }
    
    
    public Tareas2 getTareaJPA(Integer id){
        Tareas2 t = em.find(Tareas2.class, id);
    return t;
    }
   
}
