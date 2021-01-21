/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.modelo.Tarea;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;

/**
 *
 * @author user
 */
public interface tareasInterface extends Serializable {

    public String cambiarEstadoDown();

    String cambiarEstadoUp();

    Collection<Tarea> getCollecionEnProgreso();

    Collection<Tarea> getCollecionHacer();

    Collection<Tarea> getCollecionHechas();

    Tarea getSelectTarea();

    @PostConstruct
    void iniciar();

    void setSelectTarea(Tarea selectTarea);
    
}
