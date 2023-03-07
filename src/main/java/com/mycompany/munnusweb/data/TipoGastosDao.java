/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.TipoGastos;
import java.util.Optional;

/**
 *
 * @author ana
 */
public interface TipoGastosDao {
	public List<TipoGastos> findAllTipoGasto();

	public TipoGastos findByIdTipoGasto(int id);

	public Optional <TipoGastos> findByDescripcion(String descripcion);

	public void insertTipoGasto(TipoGastos tipoGasto);

	public void updateTipoGasto(TipoGastos tipoGasto);

	public void deleteTipoGasto(int id);

}
