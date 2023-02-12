/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ana
 */
@Embeddable
public class PresupuestoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Administrador", nullable = false)
    private int idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Presupuesto",  nullable = false)
    private int idPresupuesto;

    public PresupuestoPK() {
    }

    public PresupuestoPK(int idAdministrador, int idPresupuesto) {
        this.idAdministrador = idAdministrador;
        this.idPresupuesto = idPresupuesto;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAdministrador;
        hash += (int) idPresupuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoPK)) {
            return false;
        }
        PresupuestoPK other = (PresupuestoPK) object;
        if (this.idAdministrador != other.idAdministrador) {
            return false;
        }
        if (this.idPresupuesto != other.idPresupuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.PresupuestoPK[ idAdministrador=" + idAdministrador + ", idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
