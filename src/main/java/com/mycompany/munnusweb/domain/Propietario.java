/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "propietario")

@NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p")
@NamedQuery(name = "Propietario.findByIdPropietario", query = "SELECT p FROM Propietario p WHERE p.idPropietario = :idPropietario")
@NamedQuery(name = "Propietario.findByNombres", query = "SELECT p FROM Propietario p WHERE p.nombres = :nombres")
@NamedQuery(name = "Propietario.findByApellidos", query = "SELECT p FROM Propietario p WHERE p.apellidos = :apellidos")
@NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono")
@NamedQuery(name = "Propietario.findByEmail", query = "SELECT p FROM Propietario p WHERE p.email = :email")
@NamedQuery(name = "Propietario.findByNumeroCuentaBancaria", query = "SELECT p FROM Propietario p WHERE p.numeroCuentaBancaria = :numeroCuentaBancaria")
@NamedQuery(name = "Propietario.findByClave", query = "SELECT p FROM Propietario p WHERE p.clave = :clave")
public class Propietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Propietario")
	private Integer idPropietario;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "telefono")
	private String telefono;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 70)
	@Column(name = "numeroCuentaBancaria")
	private String numeroCuentaBancaria;

	@Basic(optional = false)
	@NotNull
	@Column(name = "estadoCuentaA", length = 1)
	private String estadoCuentaA;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nombres")
	private String nombres;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "apellidos")
	private String apellidos;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "clave")
	private String clave;

	@JoinTable(name = "propietario_has_vivienda", joinColumns = {
			@JoinColumn(name = "propietario_id_Propietario", referencedColumnName = "id_Propietario") }, inverseJoinColumns = {
					@JoinColumn(name = "vivienda_id_Vivienda", referencedColumnName = "id_Vivienda") })
	@ManyToMany
	private Collection<Vivienda> viviendaCollection;

	
	public Propietario() {
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}

	public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}

	public String getEstadoCuentaA() {
		return estadoCuentaA;
	}

	public void setEstadoCuentaA(String estadoCuentaA) {
		this.estadoCuentaA = estadoCuentaA;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Collection<Vivienda> getViviendaCollection() {
		return viviendaCollection;
	}

	public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
		this.viviendaCollection = viviendaCollection;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, clave, email, estadoCuentaA, idPropietario, nombres, numeroCuentaBancaria,
				telefono, viviendaCollection);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Propietario))
			return false;
		Propietario other = (Propietario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(clave, other.clave)
				&& Objects.equals(email, other.email) && Objects.equals(estadoCuentaA, other.estadoCuentaA)
				&& Objects.equals(idPropietario, other.idPropietario) && Objects.equals(nombres, other.nombres)
				&& Objects.equals(numeroCuentaBancaria, other.numeroCuentaBancaria)
				&& Objects.equals(telefono, other.telefono)
			
				&& Objects.equals(viviendaCollection, other.viviendaCollection);
	}

}
