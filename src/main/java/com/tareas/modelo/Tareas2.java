/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TAREAS2")
@NamedQueries({
    @NamedQuery(name = "Tareas2.findAll", query = "SELECT t FROM Tareas2 t"),
    @NamedQuery(name = "Tareas2.findByIdTarea", query = "SELECT t FROM Tareas2 t WHERE t.idTarea = :idTarea"),
    @NamedQuery(name = "Tareas2.findByDescripcion", query = "SELECT t FROM Tareas2 t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tareas2.findByEstado", query = "SELECT t FROM Tareas2 t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tareas2.findByArchivado", query = "SELECT t FROM Tareas2 t WHERE t.archivado = :archivado")})
public class Tareas2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TAREA")
    private Integer idTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCHIVADO")
    private Boolean archivado;

    public Tareas2() {
    }

    public Tareas2(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Tareas2(Integer idTarea, String descripcion, String estado, Boolean archivado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.archivado = archivado;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getArchivado() {
        return archivado;
    }

    public void setArchivado(Boolean archivado) {
        this.archivado = archivado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas2)) {
            return false;
        }
        Tareas2 other = (Tareas2) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tareas.modelo.Tareas2[ idTarea=" + idTarea + " ]";
    }
    
}
