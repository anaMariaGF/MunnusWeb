/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ana
 */
@Entity // indica que se trata de una clase de entidad, es decir, que hace referencia a
		// una tabla de la base de datos.
@Table(name = "propietario_has_vivienda") // indica el nombre de la tabla a la que hace referencia.
public class ViendaPropietario implements Serializable {

	private static final long serialVersionUID = -2923089152498294408L;

	@EmbeddedId // indica que la clave primaria va a estar contenida en la clase
				// viviendaPropietario.
	private ViendaPropietarioPK id;

	@ManyToOne // indica que la clase viviendaPropietario está relacionada con la clase
				// Propietario y Vivienda.
	@JoinColumn(name = "propietario_id_Propietario", referencedColumnName = "id_Propietario", insertable = false, updatable = false)

	private Propietario propietario;

	@ManyToOne
	@JoinColumn(name = "vivienda_id_Vivienda", referencedColumnName = "id_Vivienda", insertable = false, updatable = false)
	private Vivienda vienda;

	public ViendaPropietarioPK getId() {
		return id;
	}

	public void setId(ViendaPropietarioPK id) {
		this.id = id;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vivienda getVienda() {
		return vienda;
	}

	public void setVienda(Vivienda vienda) {
		this.vienda = vienda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, propietario, vienda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ViendaPropietario))
			return false;
		ViendaPropietario other = (ViendaPropietario) obj;
		return Objects.equals(id, other.id) && Objects.equals(propietario, other.propietario)
				&& Objects.equals(vienda, other.vienda);
	}

}
