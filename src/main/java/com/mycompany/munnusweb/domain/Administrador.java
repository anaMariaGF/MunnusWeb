/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "administrador")

@NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
@NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador")
@NamedQuery(name = "Administrador.findByNif", query = "SELECT a FROM Administrador a WHERE a.nif = :nif")
@NamedQuery(name = "Administrador.findByMatriculaAbogado", query = "SELECT a FROM Administrador a WHERE a.matriculaAbogado = :matriculaAbogado")
@NamedQuery(name = "Administrador.findByNombres", query = "SELECT a FROM Administrador a WHERE a.nombres = :nombres")
@NamedQuery(name = "Administrador.findByApellidos", query = "SELECT a FROM Administrador a WHERE a.apellidos = :apellidos")
@NamedQuery(name = "Administrador.findByTelefono", query = "SELECT a FROM Administrador a WHERE a.telefono = :telefono")
@NamedQuery(name = "Administrador.findByEmail", query = "SELECT a FROM Administrador a WHERE a.email = :email")
@NamedQuery(name = "Administrador.findByClave", query = "SELECT a FROM Administrador a WHERE a.clave = :clave")
@NamedQuery(name = "Administrador.findByClaveMatriculaAbogado", query = "SELECT a FROM Administrador a WHERE a.clave = :clave AND a.matriculaAbogado = :matriculaAbogado")

public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
        
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Administrador", unique = true, nullable = false)
	private Integer idAdministrador;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NIF", unique = true, nullable = false)
	private String nif;

	@Basic(optional = false)
	@NotNull()
	@Size(min = 1, max = 45)
	@Column(name = "matriculaAbogado", unique = true, nullable = false)
	private String matriculaAbogado;

	
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
	@Column(name = "telefono")
	private String telefono;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "email",unique = true, nullable = false)
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "clave", nullable = false)
	private String clave;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using
	// this annotation to enforce field validation

	@Basic(optional = false)
	@NotNull
	@Column(name = "estadoCuentaA", length = 1)
	private String estadoCuentaA;


	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "administrador")
	private List<Presupuesto> presupuestoCollection;
        
    

	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMatriculaAbogado() {
		return matriculaAbogado;
	}

	public void setMatriculaAbogado(String matriculaAbogado) {
		this.matriculaAbogado = matriculaAbogado;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstadoCuentaA() {
		return estadoCuentaA;
	}

	public void setEstadoCuentaA(String estadoCuentaA) {
		this.estadoCuentaA = estadoCuentaA;
	}

	
	public List<Presupuesto> getPresupuestoCollection() {
		return presupuestoCollection;
	}

	public void setPresupuestoCollection(List<Presupuesto> presupuestoCollection) {
		this.presupuestoCollection = presupuestoCollection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, clave, email, estadoCuentaA, idAdministrador, matriculaAbogado,
				nif, nombres, presupuestoCollection, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Administrador))
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(clave, other.clave)
				&& Objects.equals(email, other.email) && Objects.equals(estadoCuentaA, other.estadoCuentaA)
				
				&& Objects.equals(idAdministrador, other.idAdministrador)
				&& Objects.equals(matriculaAbogado, other.matriculaAbogado) && Objects.equals(nif, other.nif)
				&& Objects.equals(nombres, other.nombres)
				&& Objects.equals(presupuestoCollection, other.presupuestoCollection)
				&& Objects.equals(telefono, other.telefono);
	}

}
