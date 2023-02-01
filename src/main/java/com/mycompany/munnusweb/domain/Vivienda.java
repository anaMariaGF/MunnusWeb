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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda"),
    @NamedQuery(name = "Vivienda.findByDireccionVivienda", query = "SELECT v FROM Vivienda v WHERE v.direccionVivienda = :direccionVivienda"),
    @NamedQuery(name = "Vivienda.findByCoeficienteVivienda", query = "SELECT v FROM Vivienda v WHERE v.coeficienteVivienda = :coeficienteVivienda"),
    @NamedQuery(name = "Vivienda.findByPortal", query = "SELECT v FROM Vivienda v WHERE v.portal = :portal"),
    @NamedQuery(name = "Vivienda.findByTotalPagar", query = "SELECT v FROM Vivienda v WHERE v.totalPagar = :totalPagar")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Vivienda")
    private Integer idVivienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccionVivienda")
    private String direccionVivienda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coeficienteVivienda")
    private double coeficienteVivienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "portal")
    private String portal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "parking")
    private byte[] parking;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "ascensor")
    private byte[] ascensor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPagar")
    private double totalPagar;
    @ManyToMany(mappedBy = "viviendaCollection")
    private Collection<Propietario> propietarioCollection;
    @JoinColumn(name = "factura_id_Factura", referencedColumnName = "id_Factura")
    @ManyToOne(optional = false)
    private Factura facturaidFactura;

    public Vivienda() {
    }

    public Vivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Vivienda(Integer idVivienda, String direccionVivienda, double coeficienteVivienda, String portal, byte[] parking, byte[] ascensor, double totalPagar) {
        this.idVivienda = idVivienda;
        this.direccionVivienda = direccionVivienda;
        this.coeficienteVivienda = coeficienteVivienda;
        this.portal = portal;
        this.parking = parking;
        this.ascensor = ascensor;
        this.totalPagar = totalPagar;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDireccionVivienda() {
        return direccionVivienda;
    }

    public void setDireccionVivienda(String direccionVivienda) {
        this.direccionVivienda = direccionVivienda;
    }

    public double getCoeficienteVivienda() {
        return coeficienteVivienda;
    }

    public void setCoeficienteVivienda(double coeficienteVivienda) {
        this.coeficienteVivienda = coeficienteVivienda;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public byte[] getParking() {
        return parking;
    }

    public void setParking(byte[] parking) {
        this.parking = parking;
    }

    public byte[] getAscensor() {
        return ascensor;
    }

    public void setAscensor(byte[] ascensor) {
        this.ascensor = ascensor;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
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
