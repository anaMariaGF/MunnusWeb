/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.TipoGastos;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Local
public interface TipoGastosService {

	public List<TipoGastos> listarTipoGastos();

	public TipoGastos encontrarTipoGastosPorID(int id) throws ExcepcionNegocio ;

	public void registrarTipoGasto(TipoGastos gasto) throws ExcepcionNegocio ;

	public void modificarTipoGastos(TipoGastos gasto)throws ExcepcionNegocio ;

	public void eliminarTipoGasto(int id) throws ExcepcionNegocio ;
        
        public TipoGastos encontrarTipoGastosPorDescripcion(String descripcion)throws ExcepcionNegocio;

}
