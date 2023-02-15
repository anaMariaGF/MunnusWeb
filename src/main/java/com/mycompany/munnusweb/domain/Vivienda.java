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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda"),
    @NamedQuery(name = "Vivienda.findByAscensor", query = "SELECT v FROM Vivienda v WHERE v.ascensor = :ascensor"),
    @NamedQuery(name = "Vivienda.findByCoeficienteVivienda", query = "SELECT v FROM Vivienda v WHERE v.coeficienteVivienda = :coeficienteVivienda"),
    @NamedQuery(name = "Vivienda.findByDireccionVivienda", query = "SELECT v FROM Vivienda v WHERE v.direccionVivienda = :direccionVivienda"),
    @NamedQuery(name = "Vivienda.findByParking", query = "SELECT v FROM Vivienda v WHERE v.parking = :parking"),
    @NamedQuery(name = "Vivienda.findByPortal", query = "SELECT v FROM Vivienda v WHERE v.portal = :portal"),
    @NamedQuery(name = "Vivienda.findByTotalPagar", query = "SELECT v FROM Vivienda v WHERE v.totalPagar = :totalPagar")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Vivienda")
    private Integer idVivienda;
    @Size(max = 1)
    @Column(name = "ascensor")
    private String ascensor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coeficienteVivienda")
    private Double coeficienteVivienda;
    @Size(max = 255)
    @Column(name = "direccionVivienda")
    private String direccionVivienda;
    @Size(max = 1)
    @Column(name = "parking")
    private String parking;
    @Size(max = 1)
    @Column(name = "portal")
    private String portal;
    @Column(name = "totalPagar")
    private Double totalPagar;
    @JoinTable(name = "propietario_has_vivienda", joinColumns = {
        @JoinColumn(name = "vivienda_id_Vivienda", referencedColumnName = "id_Vivienda")}, inverseJoinColumns = {
        @JoinColumn(name = "propietario_id_Propietario", referencedColumnName = "id_Propietario")})
    @ManyToMany
    private Collection<Propietario> propietarioCollection;
    @JoinColumn(name = "factura_id_Factura", referencedColumnName = "id_Factura")
    @ManyToOne
    private Factura facturaidFactura;

    public Vivienda() {
    }

    public Vivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getAscensor() {
        return ascensor;
    }

    public void setAscensor(String ascensor) {
        this.ascensor = ascensor;
    }

    public Double getCoeficienteVivienda() {
        return coeficienteVivienda;
    }

    public void setCoeficienteVivienda(Double coeficienteVivienda) {
        this.coeficienteVivienda = coeficienteVivienda;
    }

    public String getDireccionVivienda() {
        return direccionVivienda;
    }

    public void setDireccionVivienda(String direccionVivienda) {
        this.direccionVivienda = direccionVivienda;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    @XmlTransient
    public Collection<Propietario> getPropietarioCollection() {
        return propietarioCollection;
    }

    public void setPropietarioCollection(Collection<Propietario> propietarioCollection) {
        this.propietarioCollection = propietarioCollection;
    }

    public Factura getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(Factura facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVivienda != null ? idVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.idVivienda == null && other.idVivienda != null) || (this.idVivienda != null && !this.idVivienda.equals(other.idVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.Vivienda[ idVivienda=" + idVivienda + " ]";
    }

}
