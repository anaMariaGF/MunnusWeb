/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "presupuesto_has_tipo_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoHasTipoGastos.findAll", query = "SELECT p FROM PresupuestoHasTipoGastos p"),
    @NamedQuery(name = "PresupuestoHasTipoGastos.findByPresupuestoidPresupuesto", query = "SELECT p FROM PresupuestoHasTipoGastos p WHERE p.presupuestoHasTipoGastosPK.presupuestoidPresupuesto = :presupuestoidPresupuesto"),
    @NamedQuery(name = "PresupuestoHasTipoGastos.findByTipoGastosIdTipoGastos", query = "SELECT p FROM PresupuestoHasTipoGastos p WHERE p.presupuestoHasTipoGastosPK.tipoGastosIdTipoGastos = :tipoGastosIdTipoGastos"),
    @NamedQuery(name = "PresupuestoHasTipoGastos.findByPresupuestoIdAdministrador", query = "SELECT p FROM PresupuestoHasTipoGastos p WHERE p.presupuestoHasTipoGastosPK.presupuestoIdAdministrador = :presupuestoIdAdministrador")})
public class PresupuestoHasTipoGastos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected PresupuestoHasTipoGastosPK presupuestoHasTipoGastosPK;
    @JoinColumn(name = "presupuesto_id_administrador", referencedColumnName = "id_Administrador", insertable = false, updatable = false)
    @JoinColumn(name = "presupuesto_id_Presupuesto", referencedColumnName = "id_Presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Presupuesto presupuesto;
   
    @JoinColumn(name = "TIPO_GASTOS_ID_TIPO_GASTOS", referencedColumnName = "TIPO_GASTOS_ID_TIPO_GASTOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoGastos tipoGastos;
    
    @Column(name = "valor", nullable = false )
    private double  valor; 

    public PresupuestoHasTipoGastosPK getPresupuestoHasTipoGastosPK() {
        return presupuestoHasTipoGastosPK;
    }

    public void setPresupuestoHasTipoGastosPK(PresupuestoHasTipoGastosPK presupuestoHasTipoGastosPK) {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
}
