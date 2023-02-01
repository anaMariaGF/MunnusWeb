/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ana
 */
@Embeddable
public class PresupuestoTipoGastosPK {
  
    @Column(name=" presuesto_id_Presupuesto")
    private int idPresupuesto;
    
 
    @Column(name=" tipo_gastos_id_tipo_gastos")
    private int idTipoGastos;

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getIdTipoGastos() {
        return idTipoGastos;
    }

    public void setIdTipoGastos(int idTipoGastos) {
        this.idTipoGastos = idTipoGastos;
    }

    @Override
    public int hashCode() { //identificador has
        int hash = 7;
        hash = 37 * hash + this.idPresupuesto;
        hash = 37 * hash + this.idTipoGastos;
        return hash;
    }

    @Override //comparamos que una llavae no sea igual a la otra
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
        final PresupuestoTipoGastosPK other = (PresupuestoTipoGastosPK) obj;
        if (this.idPresupuesto != other.idPresupuesto) {
            return false;
        }
        return this.idTipoGastos == other.idTipoGastos;
    }
    
    
    
    
    
}
