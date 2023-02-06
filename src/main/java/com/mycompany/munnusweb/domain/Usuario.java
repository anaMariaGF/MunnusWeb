/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "usuario")

@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
@NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
@NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
@NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
@NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Usuario")
	private Integer idUsuario;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nombres")
	private String nombres;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 70)
	@Column(name = "apellidos")
	private String apellidos;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "clave")
	private String clave;

	@Basic(optional = false)
	@NotNull
	@Column(name = "estadoCuenta")
	private byte[] estadoCuenta;

	@JoinColumn(name = "administrador_id_Administrador", referencedColumnName = "id_Administrador")
	@ManyToOne
	private Administrador administradoridAdministrador;

	@JoinColumn(name = "propietario_id_Propietario", referencedColumnName = "id_Propietario")
	@ManyToOne
	private Propietario propietarioidPropietario;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public byte[] getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(byte[] estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Administrador getAdministradoridAdministrador() {
		return administradoridAdministrador;
	}

	public void setAdministradoridAdministrador(Administrador administradoridAdministrador) {
		this.administradoridAdministrador = administradoridAdministrador;
	}

	public Propietario getPropietarioidPropietario() {
		return propietarioidPropietario;
	}

	public void setPropietarioidPropietario(Propietario propietarioidPropietario) {
		this.propietarioidPropietario = propietarioidPropietario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(estadoCuenta);
		result = prime * result + Objects.hash(administradoridAdministrador, apellidos, clave, idUsuario, nombres,
				propietarioidPropietario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(administradoridAdministrador, other.administradoridAdministrador)
				&& Objects.equals(apellidos, other.apellidos) && Objects.equals(clave, other.clave)
				&& Arrays.equals(estadoCuenta, other.estadoCuenta) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(nombres, other.nombres)
				&& Objects.equals(propietarioidPropietario, other.propietarioidPropietario);
	}

}
