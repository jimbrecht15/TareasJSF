/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Tarea implements Serializable {
    
    public int usuarioid; 
    public int id;
    public String tarea;
    public String definicion;
    public String estado;

    public Tarea(int usuarioid, String tarea, String definicion, String estado) {
        this.usuarioid = usuarioid;
        this.tarea = tarea;
        this.definicion = definicion;
        this.estado = estado;
    }

    public Tarea(int usuarioid, int id, String tarea, String definicion, String estado) {
        this.usuarioid = usuarioid;
        this.id = id;
        this.tarea = tarea;
        this.definicion = definicion;
        this.estado = estado;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.tarea);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tarea, other.tarea)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", tarea=" + tarea + ", definicion=" + definicion + ", estado=" + estado + '}';
    }

    
    
    
}
