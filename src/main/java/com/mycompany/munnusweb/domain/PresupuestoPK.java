/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ana
 */
@Embeddable
public class PresupuestoPK implements Serializable {

	@Basic(optional = false)
	@Column(name = "id_Presupuesto")
	private int idPresupuesto;

	@Basic(optional = false)
	@NotNull
	@Column(name = "id_Administrador")
	private int idAdministrador;

	public PresupuestoPK() {
	}

	public PresupuestoPK(int idPresupuesto, int idAdministrador) {
		this.idPresupuesto = idPresupuesto;
		this.idAdministrador = idAdministrador;
	}

	public int getIdPresupuesto() {
		return idPresupuesto;
	}

	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idPresupuesto;
		hash += (int) idAdministrador;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PresupuestoPK)) {
			return false;
		}
		PresupuestoPK other = (PresupuestoPK) object;
		if (this.idPresupuesto != other.idPresupuesto) {
			return false;
		}
		if (this.idAdministrador != other.idAdministrador) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.munnusweb.domain.PresupuestoPK[ idPresupuesto=" + idPresupuesto + ", idAdministrador="
				+ idAdministrador + " ]";
	}

}
