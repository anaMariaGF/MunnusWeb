/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
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
@Table(name = "tipo_gastos")

@NamedQuery(name = "TipoGastos.findAllTipoGasto", query = "SELECT t FROM TipoGastos t")
@NamedQuery(name = "TipoGastos.findByIdTipoGasto", query = "SELECT t FROM TipoGastos t WHERE t.idTipoGasto = :idTipoGasto")
@NamedQuery(name = "TipoGastos.findByDescripcion", query = "SELECT t FROM TipoGastos t WHERE t.descripcion = :descripcion")
public class TipoGastos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "TIPO_GASTOS_ID_TIPO_GASTOS")
	private Integer idTipoGasto;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "tipoGastos")
	private List<PresupuestoTipoGastos> presupuestoTipoGastos;

	public TipoGastos() {
	}

	public Integer getIdTipoGasto() {
		return idTipoGasto;
	}

	public void setIdTipoGasto(Integer idTipoGasto) {
		this.idTipoGasto = idTipoGasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PresupuestoTipoGastos> getPresupuestoTipoGastos() {
		return presupuestoTipoGastos;
	}

	public void setPresupuestoTipoGastos(List<PresupuestoTipoGastos> presupuestoTipoGastos) {
		this.presupuestoTipoGastos = presupuestoTipoGastos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idTipoGasto, presupuestoTipoGastos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoGastos))
			return false;
		TipoGastos other = (TipoGastos) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idTipoGasto, other.idTipoGasto)
				&& Objects.equals(presupuestoTipoGastos, other.presupuestoTipoGastos);
	}

}
