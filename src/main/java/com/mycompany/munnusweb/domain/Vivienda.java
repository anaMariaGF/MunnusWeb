/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "vivienda")

@NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v")
@NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda")
@NamedQuery(name = "Vivienda.findByDireccionVivienda", query = "SELECT v FROM Vivienda v WHERE v.direccionVivienda = :direccionVivienda")
@NamedQuery(name = "Vivienda.findByCoeficienteVivienda", query = "SELECT v FROM Vivienda v WHERE v.coeficienteVivienda = :coeficienteVivienda")
@NamedQuery(name = "Vivienda.findByPortal", query = "SELECT v FROM Vivienda v WHERE v.portal = :portal")
@NamedQuery(name = "Vivienda.findByTotalPagar", query = "SELECT v FROM Vivienda v WHERE v.totalPagar = :totalPagar")
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
	@Column(name = "portal", length = 1)
	private String portal;

	@Basic(optional = false)
	@NotNull
	@Column(name = "parking", length = 1)
	private String parking;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ascensor", length = 1)
	private String ascensor;

	@Basic(optional = false)
	@NotNull
	@Column(name = "totalPagar")
	private double totalPagar;

	@JoinColumn(name = "factura_id_Factura", referencedColumnName = "id_Factura")
	@ManyToOne(optional = false)
	private Factura facturaidFactura;

	@ManyToMany(mappedBy = "viviendaCollection")
	private Collection<Propietario> propietarioCollection;

	public Vivienda() {
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

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getAscensor() {
		return ascensor;
	}

	public void setAscensor(String ascensor) {
		this.ascensor = ascensor;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Factura getFacturaidFactura() {
		return facturaidFactura;
	}

	public void setFacturaidFactura(Factura facturaidFactura) {
		this.facturaidFactura = facturaidFactura;
	}

	public Collection<Propietario> getPropietarioCollection() {
		return propietarioCollection;
	}

	public void setPropietarioCollection(Collection<Propietario> propietarioCollection) {
		this.propietarioCollection = propietarioCollection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ascensor, coeficienteVivienda, direccionVivienda, facturaidFactura, idVivienda, parking,
				portal, propietarioCollection, totalPagar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vivienda))
			return false;
		Vivienda other = (Vivienda) obj;
		return Objects.equals(ascensor, other.ascensor)
				&& Double.doubleToLongBits(coeficienteVivienda) == Double.doubleToLongBits(other.coeficienteVivienda)
				&& Objects.equals(direccionVivienda, other.direccionVivienda)
				&& Objects.equals(facturaidFactura, other.facturaidFactura)
				&& Objects.equals(idVivienda, other.idVivienda) && Objects.equals(parking, other.parking)
				&& Objects.equals(portal, other.portal)
				&& Objects.equals(propietarioCollection, other.propietarioCollection)
				&& Double.doubleToLongBits(totalPagar) == Double.doubleToLongBits(other.totalPagar);
	}

}
