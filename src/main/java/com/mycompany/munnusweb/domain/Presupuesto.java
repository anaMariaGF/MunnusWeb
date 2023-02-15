/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "presupuesto")

@NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
@NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idPresupuesto = :idPresupuesto")
@NamedQuery(name = "Presupuesto.findByNombreComunidad", query = "SELECT p FROM Presupuesto p WHERE p.nombreComunidad = :nombreComunidad")
@NamedQuery(name = "Presupuesto.findByTotalPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.totalPresupuesto = :totalPresupuesto")
@NamedQuery(name = "Presupuesto.findByNumProtales", query = "SELECT p FROM Presupuesto p WHERE p.numProtales = :numProtales")
@NamedQuery(name = "Presupuesto.findByIdAdministrador", query = "SELECT p FROM Presupuesto p WHERE p.presupuestoPK.idAdministrador = :idAdministrador")
public class Presupuesto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PresupuestoPK presupuestoPK;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 70)
	@Column(name = "nombreComunidad", nullable = false)
	private String nombreComunidad;

	@Basic(optional = false)
	@NotNull
	@Column(name = "totalPresupuesto", nullable = false)

	private double totalPresupuesto;
	@Basic(optional = false)
	@NotNull
	@Column(name = "num_Protales", nullable = false)
	private int numProtales;

	@JoinColumn(name = "id_Administrador", referencedColumnName = "id_Administrador", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Administrador administrador;

	@OneToMany(mappedBy = "presupuesto")
	private List<PresupuestoTipoGastos> presupuestoTipoGastos;

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

	public double getTotalPresupuesto() {
		return totalPresupuesto;
	}

	public void setTotalPresupuesto(double totalPresupuesto) {
		this.totalPresupuesto = totalPresupuesto;
	}

	public int getNumProtales() {
		return numProtales;
	}

	public void setNumProtales(int numProtales) {
		this.numProtales = numProtales;
	}

	public List<PresupuestoTipoGastos> getPresupuestoTipoGastos() {
		return presupuestoTipoGastos;
	}

	public void setPresupuestoTipoGastos(List<PresupuestoTipoGastos> presupuestoTipoGastos) {
		this.presupuestoTipoGastos = presupuestoTipoGastos;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
