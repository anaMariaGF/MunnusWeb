/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "factura")
@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
@NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
@NamedQuery(name = "Factura.findByFechaEmision", query = "SELECT f FROM Factura f WHERE f.fechaEmision = :fechaEmision")
@NamedQuery(name = "Factura.findByPeriodo", query = "SELECT f FROM Factura f WHERE f.periodo = :periodo")
@NamedQuery(name = "Factura.findByValor", query = "SELECT f FROM Factura f WHERE f.valor = :valor")

public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Factura", unique = true, nullable = false)
	private Integer idFactura;

	@Basic(optional = false)
	@NotNull
	@Column(name = "fechaEmision", nullable = false)
	private LocalDateTime fechaEmision;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "periodo", nullable = false)
	private String periodo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "estadoF",nullable = false)
	private String estadoF;

	@Basic(optional = false)
	@NotNull
	@Column(name = "valor", nullable = false)
	private double valor;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaidFactura")
	private Collection<Vivienda> viviendaCollection;

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getEstadoF() {
		return estadoF;
	}

	public void setEstadoF(String estadoF) {
		this.estadoF = estadoF;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Collection<Vivienda> getViviendaCollection() {
		return viviendaCollection;
	}

	public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
		this.viviendaCollection = viviendaCollection;
	}
      
	

	

	
}
