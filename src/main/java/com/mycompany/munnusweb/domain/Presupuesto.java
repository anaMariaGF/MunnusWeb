/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"),
    @NamedQuery(name = "Presupuesto.findByNombreComunidad", query = "SELECT p FROM Presupuesto p WHERE p.nombreComunidad = :nombreComunidad"),
    @NamedQuery(name = "Presupuesto.findByNumProtales", query = "SELECT p FROM Presupuesto p WHERE p.numProtales = :numProtales"),
    @NamedQuery(name = "Presupuesto.findByTotalPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.totalPresupuesto = :totalPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByIdAdministrador", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idPresupuesto = :idPresupuesto")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoPK presupuestoPK;
    @Size(max = 255)
    @Column(name = "nombreComunidad", nullable = false)
    private String nombreComunidad;
   
    @Column(name = "num_Protales")
    private Integer numProtales;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    @Column(name = "totalPresupuesto",  nullable = false)
    private Double totalPresupuesto;
    
    @Column(name = "totalGastos", insertable = false, updatable = false)
    private Double totalGastos;
   
    @JoinColumn(name = "id_Administrador", referencedColumnName = "id_Administrador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Administrador administrador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuesto")
    private Collection<PresupuestoHasTipoGastos> presupuestoHasTipoGastosCollection;

    public Presupuesto() {
    }

    public Presupuesto(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }

    public Presupuesto(int idAdministrador, int idPresupuesto) {
        this.presupuestoPK = new PresupuestoPK(idAdministrador, idPresupuesto);
    }

    public PresupuestoPK getPresupuestoPK() {
        return presupuestoPK;
    }

    public void setPresupuestoPK(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public Integer getNumProtales() {
        return numProtales;
    }

    public void setNumProtales(Integer numProtales) {
        this.numProtales = numProtales;
    }

    public Double getTotalPresupuesto() {
        return totalPresupuesto;
    }

    public void setTotalPresupuesto(Double totalPresupuesto) {
        this.totalPresupuesto = totalPresupuesto;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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
        hash += (presupuestoPK != null ? presupuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.presupuestoPK == null && other.presupuestoPK != null) || (this.presupuestoPK != null && !this.presupuestoPK.equals(other.presupuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.Presupuesto[ presupuestoPK=" + presupuestoPK + " ]";
    }
    
}
