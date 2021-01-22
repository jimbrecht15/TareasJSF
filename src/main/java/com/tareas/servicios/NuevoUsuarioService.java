/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class NuevoUsuarioService implements NuevoUsuarioInterface {

    public NuevoUsuarioService() {
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Iniciar nuevo Usuario");
    }
            
    @Override
    public boolean altaUsuario(Usuario usuario) throws ExcepcionDBUsuarios{
       return DBUsuario.addUsuario(usuario);
    }
    
    @Override
    public boolean existeEmail(String email){
       return DBUsuario.existeEmail(email);
    }
}
