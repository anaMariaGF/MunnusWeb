/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.PresupuestoDao;
import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;

/**
 *
 * @author ana
 */
@Stateless
public class PresupuestoServiceImp implements PresupuestoService {

	// Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
	// usuarioDao
	@Inject
	private PresupuestoDao presupuestoDao;

	// Ahora nos apoyamos de la interfaz para completar los servicios

	@Override
	public List<Presupuesto> listarPresupuestos() {
		return presupuestoDao.findAllPresupuestos();
	}

	@Override
	public Presupuesto encontrarPresupuestoPorID(PresupuestoPK presupuesto) {
		return presupuestoDao.findPresupuestoByID(presupuesto);
	}

	@Override
	public void registrarPresupuesto(Presupuesto presupuesto) {
		presupuestoDao.insertPresupuesto(presupuesto);
	}

	@Override
	public void modificarPresupuesto(Presupuesto presupuesto) {
		presupuestoDao.updatePresupuesto(presupuesto);
	}

	@Override
	public void eliminarPresupuesto(Presupuesto presupuesto) {
		presupuestoDao.deletePresupuesto(presupuesto);
	}

}
