/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"),
    @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByNombreComunidad", query = "SELECT p FROM Presupuesto p WHERE p.nombreComunidad = :nombreComunidad"),
    @NamedQuery(name = "Presupuesto.findByTotalPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.totalPresupuesto = :totalPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByNumProtales", query = "SELECT p FROM Presupuesto p WHERE p.numProtales = :numProtales"),
    @NamedQuery(name = "Presupuesto.findByIdAdministrador", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idAdministrador = :idAdministrador")})
public class Presupuesto implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombreComunidad")
    private String nombreComunidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPresupuesto")
    private double totalPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_Protales")
    private int numProtales;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoPK presupuestoPK;
   
       
    
   @OneToMany(mappedBy = "presupuesto")

    private List<PresupuestoTipoGastos> presupuestoTipoGastos;
    
    @JoinColumn(name = "id_Administrador", referencedColumnName = "id_Administrador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Administrador administrador;

    public Presupuesto() {
    }

    public Presupuesto(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }

    public Presupuesto(PresupuestoPK presupuestoPK, String nombreComunidad, double totalPresupuesto, int numProtales) {
        this.presupuestoPK = presupuestoPK;
        this.nombreComunidad = nombreComunidad;
        this.totalPresupuesto = totalPresupuesto;
        this.numProtales = numProtales;
    }

    public Presupuesto(int idPresupuesto, int idAdministrador) {
        this.presupuestoPK = new PresupuestoPK(idPresupuesto, idAdministrador);
    }

    public PresupuestoPK getPresupuestoPK() {
        return presupuestoPK;
    }

    public void setPresupuestoPK(PresupuestoPK presupuestoPK) {
        this.presupuestoPK = presupuestoPK;
    }


    public int getNumProtales() {
        return numProtales;
    }

    public void setNumProtales(int numProtales) {
        this.numProtales = numProtales;
    }

    @XmlTransient
    public List<PresupuestoTipoGastos> getTipoGastosCollection() {
        return presupuestoTipoGastos;
    }

    public void setTipoGastosCollection(List<PresupuestoTipoGastos> tipoGastosCollection) {
        this.presupuestoTipoGastos = tipoGastosCollection;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        this.nombreComunidad = nombreComunidad;
    }

    public double getTotalPresupuesto() {
        return totalPresupuesto;
    }

    public void setTotalPresupuesto(double totalPresupuesto) {
        this.totalPresupuesto = totalPresupuesto;
    }

   
    
}
