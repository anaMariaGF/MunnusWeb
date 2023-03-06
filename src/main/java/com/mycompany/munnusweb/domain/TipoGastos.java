/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "tipo_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGastos.findAll", query = "SELECT t FROM TipoGastos t"),
    @NamedQuery(name = "TipoGastos.findByTipoGastosIdTipoGastos", query = "SELECT t FROM TipoGastos t WHERE t.tipoGastosIdTipoGastos = :tipoGastosIdTipoGastos"),
    @NamedQuery(name = "TipoGastos.findByDescripcion", query = "SELECT t FROM TipoGastos t WHERE t.descripcion = :descripcion")})
public class TipoGastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPO_GASTOS_ID_TIPO_GASTOS", nullable = false)
    private Integer tipoGastosIdTipoGastos;
    
    @Size(max = 255)
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoGastos")
    private Collection<PresupuestoHasTipoGastos> presupuestoHasTipoGastosCollection;

    public TipoGastos() {
    }

    public TipoGastos(Integer tipoGastosIdTipoGastos) {
        this.tipoGastosIdTipoGastos = tipoGastosIdTipoGastos;
    }

    public Integer getTipoGastosIdTipoGastos() {
        return tipoGastosIdTipoGastos;
    }

    public void setTipoGastosIdTipoGastos(Integer tipoGastosIdTipoGastos) {
        this.tipoGastosIdTipoGastos = tipoGastosIdTipoGastos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<PresupuestoHasTipoGastos> getPresupuestoHasTipoGastosCollection() {
        return presupuestoHasTipoGastosCollection;
    }

    public void setPresupuestoHasTipoGastosCollection(Collection<PresupuestoHasTipoGastos> presupuestoHasTipoGastosCollection) {
        this.presupuestoHasTipoGastosCollection = presupuestoHasTipoGastosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoGastosIdTipoGastos != null ? tipoGastosIdTipoGastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGastos)) {
            return false;
        }
        TipoGastos other = (TipoGastos) object;
        if ((this.tipoGastosIdTipoGastos == null && other.tipoGastosIdTipoGastos != null) || (this.tipoGastosIdTipoGastos != null && !this.tipoGastosIdTipoGastos.equals(other.tipoGastosIdTipoGastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.TipoGastos[ tipoGastosIdTipoGastos=" + tipoGastosIdTipoGastos + " ]";
    }
    
}
