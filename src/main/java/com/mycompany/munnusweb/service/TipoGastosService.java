/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.domain.TipoGastos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local
public interface TipoGastosService {
       
    public List<TipoGastos> listarTipoGastos();
    public TipoGastos encontrarTipoGastosPorID(TipoGastos gasto);
    public void registrarTipoGasto(TipoGastos gasto);
    public void modificarTipoGastos(TipoGastos gasto);
    public void eliminarTipoGasto(TipoGastos gasto);
    
}
