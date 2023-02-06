/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * w
 *
 * @author ana
 */
@Embeddable
public class PresupuestoTipoGastosPK implements Serializable {

	@Column(name = "presuesto_id_Presupuesto")
	private Integer idPresupuesto;

	@Column(name = "presuesto_id_administrador")
	private Integer idPresupuestoAdmin;

	@Column(name = "TIPO_GASTOS_ID_TIPO_GASTOS")
	private Integer idTipoGastos;

	public Integer getIdPresupuesto() {
		return idPresupuesto;
	}

	public void setIdPresupuesto(Integer idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	public Integer getIdPresupuestoAdmin() {
		return idPresupuestoAdmin;
	}

	public void setIdPresupuestoAdmin(Integer idPresupuestoAdmin) {
		this.idPresupuestoAdmin = idPresupuestoAdmin;
	}

	public Integer getIdTipoGastos() {
		return idTipoGastos;
	}

	public void setIdTipoGastos(Integer idTipoGastos) {
		this.idTipoGastos = idTipoGastos;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.idPresupuesto);
		hash = 97 * hash + Objects.hashCode(this.idPresupuestoAdmin);
		hash = 97 * hash + Objects.hashCode(this.idTipoGastos);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PresupuestoTipoGastosPK other = (PresupuestoTipoGastosPK) obj;
		if (!Objects.equals(this.idPresupuesto, other.idPresupuesto)) {
			return false;
		}
		if (!Objects.equals(this.idPresupuestoAdmin, other.idPresupuestoAdmin)) {
			return false;
		}
		return Objects.equals(this.idTipoGastos, other.idTipoGastos);
	}

}
