/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "TipoGastos.findByIdTipoGasto", query = "SELECT t FROM TipoGastos t WHERE t.idTipoGasto = :idTipoGasto"),
    @NamedQuery(name = "TipoGastos.findByDescripcion", query = "SELECT t FROM TipoGastos t WHERE t.descripcion = :descripcion")})
public class TipoGastos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPO_GASTOS_ID_TIPO_GASTOS")
    private Integer idTipoGasto;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "tipoGastos")
    private Collection<PresupuestoTipoGastos> presupuestoTipoGastos;
    
    

    public TipoGastos() {
    }

    public TipoGastos(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public TipoGastos(Integer idTipoGasto, String descripcion) {
        this.idTipoGasto = idTipoGasto;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }


    @XmlTransient
    public Collection<PresupuestoTipoGastos> getPresupuestoCollection() {
        return presupuestoTipoGastos;
    }

    public void setPresupuestoCollection(Collection<PresupuestoTipoGastos> presupuestoCollection) {
        this.presupuestoTipoGastos = presupuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGasto != null ? idTipoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGastos)) {
            return false;
        }
        TipoGastos other = (TipoGastos) object;
        if ((this.idTipoGasto == null && other.idTipoGasto != null) || (this.idTipoGasto != null && !this.idTipoGasto.equals(other.idTipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.TipoGastos[ idTipoGasto=" + idTipoGasto + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
