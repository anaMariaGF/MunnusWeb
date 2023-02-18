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
import com.mycompany.munnusweb.util.ExcepcionNegocio;

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
	public TipoGastos encontrarTipoGastosPorID(int id)throws ExcepcionNegocio  {
		return tipoGastosDao.findByIdTipoGasto(id);
	}

	@Override
	public void registrarTipoGasto(TipoGastos gasto) throws ExcepcionNegocio {
		System.out.println(
				"com.mycompany.munnusweb.service.TipoGastosServiceImp.registrarTipoGasto()" + " se va a registar");
		tipoGastosDao.insertTipoGasto(gasto);
	}

	@Override
	public void modificarTipoGastos(TipoGastos gasto)throws ExcepcionNegocio  {
		tipoGastosDao.updateTipoGasto(gasto);
	}

	@Override
	public void eliminarTipoGasto(int id)throws ExcepcionNegocio  {
		tipoGastosDao.deleteTipoGasto(id);
	}

    @Override
    public TipoGastos encontrarTipoGastosPorDescripcion(String descripcion)throws ExcepcionNegocio  {
        return tipoGastosDao.findByDescripcion(descripcion).
                orElseThrow(() -> new ExcepcionNegocio("No se puede encontrar la vivienda, ya que no se encuentra la dirección: " + descripcion));
    }

}
