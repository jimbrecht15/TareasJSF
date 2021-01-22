/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface NuevoUsuarioInterface {

    public boolean altaUsuario(Usuario usuario) throws ExcepcionDBUsuarios;
    public  boolean existeEmail(String email);
    
}
