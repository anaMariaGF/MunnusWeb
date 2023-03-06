/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author ana
 */
@Embeddable
public class PresupuestoHasTipoGastosPK implements Serializable {

    @Basic(optional = false)

    @Column(name = "presupuesto_id_administrador",  nullable = false)
    private int presupuestoIdAdministrador;
    @Basic(optional = false)
    @Column(name = "presupuesto_id_Presupuesto",  nullable = false)
    private int presupuestoidPresupuesto;
    
    @Basic(optional = false)
    @Column(name = "TIPO_GASTOS_ID_TIPO_GASTOS", nullable = false)
    private int tipoGastosIdTipoGastos;
   

    public PresupuestoHasTipoGastosPK() {
    }

    public int getPresupuestoIdAdministrador() {
        return presupuestoIdAdministrador;
    }

    public void setPresupuestoIdAdministrador(int presupuestoIdAdministrador) {
        this.presupuestoIdAdministrador = presupuestoIdAdministrador;
    }

    public int getPresupuestoidPresupuesto() {
        return presupuestoidPresupuesto;
    }

    public void setPresupuestoidPresupuesto(int presupuestoidPresupuesto) {
        this.presupuestoidPresupuesto = presupuestoidPresupuesto;
    }

    public int getTipoGastosIdTipoGastos() {
        return tipoGastosIdTipoGastos;
    }

    public void setTipoGastosIdTipoGastos(int tipoGastosIdTipoGastos) {
        this.tipoGastosIdTipoGastos = tipoGastosIdTipoGastos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.presupuestoIdAdministrador;
        hash = 19 * hash + this.presupuestoidPresupuesto;
        hash = 19 * hash + this.tipoGastosIdTipoGastos;
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
        final PresupuestoHasTipoGastosPK other = (PresupuestoHasTipoGastosPK) obj;
        if (this.presupuestoIdAdministrador != other.presupuestoIdAdministrador) {
            return false;
        }
        if (this.presupuestoidPresupuesto != other.presupuestoidPresupuesto) {
            return false;
        }
        return this.tipoGastosIdTipoGastos == other.tipoGastosIdTipoGastos;
    }

    
    

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.PresupuestoHasTipoGastosPK[ presuestoIdAdministrador=" +  ", presupuestoidPresupuesto=" + presupuestoidPresupuesto + ", tipoGastosIdTipoGastos=" + tipoGastosIdTipoGastos + ", presupuestoIdAdministrador=" + presupuestoIdAdministrador + " ]";
    }
    
}
