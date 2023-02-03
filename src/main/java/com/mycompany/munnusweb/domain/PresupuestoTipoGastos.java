/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author ana
 */
@Entity

@Table(name = "presupuesto_has_tipo_gastos")

public class PresupuestoTipoGastos implements Serializable {

    @EmbeddedId
    private PresupuestoTipoGastosPK id;
    
    @ManyToOne
    @JoinColumn(name = "presupuesto_id_Presupuesto", referencedColumnName = "id_Presupuesto")
    @JoinColumn(name = "presupuesto_id_administrador", referencedColumnName = "id_Administrador")
    @MapsId("idPresupuesto")
    private Presupuesto presupuesto;

    @ManyToOne
    @MapsId("idTipoGastos")
    @JoinColumn(name = " TIPO_GASTOS_ID_TIPO_GASTOS")
    private TipoGastos tipoGastos;

    public PresupuestoTipoGastosPK getId() {
        return id;
    }

    public void setId(PresupuestoTipoGastosPK id) {
        this.id = id;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public TipoGastos getTipoGastos() {
        return tipoGastos;
    }

    public void setTipoGastos(TipoGastos tipoGastos) {
        this.tipoGastos = tipoGastos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.presupuesto);
        hash = 89 * hash + Objects.hashCode(this.tipoGastos);
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
        final PresupuestoTipoGastos other = (PresupuestoTipoGastos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.presupuesto, other.presupuesto)) {
            return false;
        }
        return Objects.equals(this.tipoGastos, other.tipoGastos);
    }

}
