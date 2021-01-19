/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.LoginException;
import java.util.Collection;
import javax.servlet.http.HttpSession;

import com.tareas.modelo.Usuario;


/**
 *
 * @author user
 */
public class LoginService {
    
    public void login(String mail, String password, HttpSession sesion) throws LoginException{
        //crear variables 
        Collection<Usuario> datos = DBUsuario.listaUsuarios();
        Usuario nuevoUsuario = null;
        
        //revisar BD y comprobar si existe usuario y contraseña 
        for (Usuario u: datos){
            if (u.getMail().equals(mail)){
                nuevoUsuario = u;
                break; 
            }
        }
        
        //si el usuario existe comparar contraseña 
        
        if (nuevoUsuario == null){
            throw new LoginException("El usuario no existe");
        }else{
            if(nuevoUsuario.getPasw().equals(password)){
                //añadir a sesion
                sesion.setAttribute("usuario", nuevoUsuario);
                
                
            }else {
                throw new LoginException("La contraseña no coincide con el mail introducido");
            }
        }
        
    }//fin login   
    
    public void logout(HttpSession sesion){
    sesion.invalidate();
}
}//fin clase 
