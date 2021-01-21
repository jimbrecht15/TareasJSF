
package com.tareas.web;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author user
 */
@Named(value = "idiomaMB")
@SessionScoped
public class IdiomaManagedBean implements Serializable{

    String lenguaje; 
    
    public IdiomaManagedBean() {
    }

    public String getLenguaje() {
        return lenguaje;
    }
    
    public String cambioIdioma(String nuevoIidioma){
        this.lenguaje = nuevoIidioma;
        return null; 
    }
    
}
