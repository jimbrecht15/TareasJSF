/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author user
 */
public class DBUsuario {
    
    public static int ultimoUsuario = 0;
    public static Set<Usuario> usuarios; 

    static{
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario(++ultimoUsuario, "Johanna", "simbrecht@birt.eus", "77777c"));
        usuarios.add(new Usuario(++ultimoUsuario, "Sindy", "jimbrecht15@hotmail.com", "77777c"));
        usuarios.add(new Usuario(++ultimoUsuario, "Paola", "gini.pao@gmail.com", "77777c"));
        
    }
    
    public DBUsuario() {
    }

    public static int getUltimoUsuario() {
        return ultimoUsuario;
    }

    public static void setUltimoUsuario(int ultimoUsuario) {
        DBUsuario.ultimoUsuario = ultimoUsuario;
    }
    
     
    public static void addUsuario(Usuario u) throws ExcepcionDBUsuarios{
        boolean agregar = usuarios.add(u);
        if (!agregar){
            throw new ExcepcionDBUsuarios("No se ha añadido el usuario porque ya existe");
        }
    }
    
    
    public static synchronized Collection<Usuario> listaUsuarios(){
        return usuarios; 
    }
  
    
}
