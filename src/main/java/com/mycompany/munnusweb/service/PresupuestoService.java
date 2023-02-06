/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;

/**
 *
 * @author ana
 */
@Local
public interface PresupuestoService {
	public List<Presupuesto> listarPresupuestos();

	public Presupuesto encontrarPresupuestoPorID(PresupuestoPK presupuesto);

	public void registrarPresupuesto(Presupuesto presupuesto);

	public void modificarPresupuesto(Presupuesto presupuesto);

	public void eliminarPresupuesto(Presupuesto presupuesto);

}
