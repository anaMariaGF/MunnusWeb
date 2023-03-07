/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Column;
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

	private static final long serialVersionUID = -5254374409123863106L;


         @EmbeddedId
    protected PresupuestoTipoGastosPK presupuestoHasTipoGastosPK;
         
    @JoinColumn(name = "presupuesto_id_administrador", referencedColumnName = "id_Administrador", insertable = false, updatable = false)
    @JoinColumn(name = "presupuesto_id_Presupuesto", referencedColumnName = "id_Presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Presupuesto presupuesto;
   
    @JoinColumn(name = "TIPO_GASTOS_ID_TIPO_GASTOS", referencedColumnName = "TIPO_GASTOS_ID_TIPO_GASTOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoGastos tipoGastos;
    
	@Column(nullable = false)
	private BigDecimal valor;

    public PresupuestoTipoGastosPK getPresupuestoHasTipoGastosPK() {
        return presupuestoHasTipoGastosPK;
    }

    public void setPresupuestoHasTipoGastosPK(PresupuestoTipoGastosPK presupuestoHasTipoGastosPK) {
        this.presupuestoHasTipoGastosPK = presupuestoHasTipoGastosPK;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.presupuestoHasTipoGastosPK);
        hash = 83 * hash + Objects.hashCode(this.presupuesto);
        hash = 83 * hash + Objects.hashCode(this.tipoGastos);
        hash = 83 * hash + Objects.hashCode(this.valor);
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
        if (!Objects.equals(this.presupuestoHasTipoGastosPK, other.presupuestoHasTipoGastosPK)) {
            return false;
        }
        if (!Objects.equals(this.presupuesto, other.presupuesto)) {
            return false;
        }
        if (!Objects.equals(this.tipoGastos, other.tipoGastos)) {
            return false;
        }
        return Objects.equals(this.valor, other.valor);
    }


    
    

}
