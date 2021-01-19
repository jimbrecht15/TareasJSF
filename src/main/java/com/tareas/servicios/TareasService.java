/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBTareas;
import com.tareas.modelo.Tarea;
import java.util.Collection;

/**
 *
 * @author user
 */
public class TareasService {
      
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
}
