/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.TipoGastosDao;
import com.mycompany.munnusweb.domain.TipoGastos;

/**
 *
 * @author ana
 */
@Stateless
public class TipoGastosServiceImp implements TipoGastosService {

	// Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
	// usuarioDao
	@Inject
	private TipoGastosDao tipoGastosDao;

	// Ahora nos apoyamos de la interfaz para completar los servicios

	@Override
	public List<TipoGastos> listarTipoGastos() {
		return tipoGastosDao.findAllTipoGasto();
	}

	@Override
	public TipoGastos encontrarTipoGastosPorID(TipoGastos gasto) {
		return tipoGastosDao.findByIdTipoGasto(gasto);
	}

	@Override
	public void registrarTipoGasto(TipoGastos gasto) {
		System.out.println(
				"com.mycompany.munnusweb.service.TipoGastosServiceImp.registrarTipoGasto()" + " se va a registar");
		tipoGastosDao.insertTipoGasto(gasto);
	}

	@Override
	public void modificarTipoGastos(TipoGastos gasto) {
		tipoGastosDao.updateTipoGasto(gasto);
	}

	@Override
	public void eliminarTipoGasto(TipoGastos gasto) {
		tipoGastosDao.deleteTipoGasto(gasto);
	}

}
