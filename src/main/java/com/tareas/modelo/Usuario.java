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
public class Usuario implements Serializable {
    
    public int idUsuario;
    public String nombre; 
    public String mail; 
    public String pasw; 

    public Usuario() {
    }

    
    
    public Usuario(String nombre, String mail, String contraseña) {
        this.nombre = nombre;
        this.mail = mail;
        this.pasw = contraseña;
    }

    public Usuario(int idUsuario, String nombre, String mail, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.mail = mail;
        this.pasw = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasw() {
        return pasw;
    }

    public void setPasw(String pasw) {
        this.pasw = pasw;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.mail);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", mail=" + mail + ", contrase\u00f1a=" + pasw + '}';
    }
    
    
    
    
    
}//fin clase usuario 
