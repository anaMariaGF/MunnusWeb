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

	//  devuelve una lista de todos los tipos de gastos en el sistema. 
        //No tiene parámetros y simplemente delega en el DAO correspondiente 
        //para realizar la consulta.

	@Override
	public List<TipoGastos> listarTipoGastos() {
		return tipoGastosDao.findAllTipoGasto();
	}
        /*
        dado un ID, devuelve el tipo de gasto correspondiente si existe. Si no
        se encuentra, lanza una excepción ExcepcionNegocio. Este método también 
        delega en el DAO correspondiente.
        */
	@Override
	public TipoGastos encontrarTipoGastosPorID(int id)throws ExcepcionNegocio  {
		return tipoGastosDao.findByIdTipoGasto(id);
	}
        
        /*
        registra un nuevo tipo de gasto en el sistema. El parámetro gasto es el 
        objeto que se va a insertar. Este método simplemente delega en el DAO 
        correspondiente.
        */

	@Override
	public void registrarTipoGasto(TipoGastos gasto) throws ExcepcionNegocio {
		System.out.println(
				"com.mycompany.munnusweb."
                          + "service.TipoGastosServiceImp."
                          + "registrarTipoGasto()" + " se va a registar");
		tipoGastosDao.insertTipoGasto(gasto);
	}
        
        /*
         modifica un tipo de gasto existente en el sistema. El parámetro gasto 
        es el objeto modificado. Este método también delega en el DAO 
        correspondiente.   
        */
	@Override
	public void modificarTipoGastos(TipoGastos gasto)throws ExcepcionNegocio  {
		tipoGastosDao.updateTipoGasto(gasto);
	}
        
        /*
        elimina un tipo de gasto del sistema dado su ID. Este método también 
        delega en el DAO correspondiente.
        
        */
	@Override
	public void eliminarTipoGasto(int id)throws ExcepcionNegocio  {
		tipoGastosDao.deleteTipoGasto(id);
	}
        /*
        busca un tipo de gasto por su descripción. Si existe, devuelve el
        objeto correspondiente. Si no se encuentra, lanza una excepción 
        ExcepcionNegocio. Este método también delega en el DAO correspondiente.
        */

    @Override
    public TipoGastos encontrarTipoGastosPorDescripcion(String descripcion)
            throws ExcepcionNegocio  {
        return tipoGastosDao.findByDescripcion(descripcion).
                orElseThrow(() -> new ExcepcionNegocio("No se puede encontrar "
                        + "la vivienda, ya que no se encuentra la dirección: " 
                        + descripcion));
    }

}
