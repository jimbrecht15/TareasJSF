/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class SaludaTimerSessionBean {

    //@Schedule(minute = "*/1", hour ="*")
    public void myTimer() {
        System.out.println("Timer saludo: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
