/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.excepciones.ExcepcionDBUsuarios;
import com.tareas.modelo.Usuario;
import javax.annotation.PostConstruct;

/**
 *
 * @author user
 */
public interface NuevoUsuarioInterface {

    boolean altaUsuario(Usuario usuario) throws ExcepcionDBUsuarios;

    boolean existeEmail(String email);

    @PostConstruct
    void iniciar();
    
}
