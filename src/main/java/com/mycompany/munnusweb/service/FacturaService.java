/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local; //java been de tipo local 

import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.time.LocalDateTime;


/**
 *
 * @author ana
 */
@Local
public interface FacturaService {
	public List<Factura> listarFacturas();

	public Factura encontrarFacturaPorID(int id);

	public void registrarFactura(String estadoF, LocalDateTime fechaEmision, String periodo, Double valor)throws ExcepcionNegocio;

	public void modificarFactura(String estado, LocalDateTime fechaEmision, String periodo, Double valor)throws ExcepcionNegocio;

	public void eliminarFactura(LocalDateTime fechaEmision)throws ExcepcionNegocio;
        
        public Factura encontrarFacturaPorFechaEmision(LocalDateTime fechaEmision)throws ExcepcionNegocio;

        public Factura encontrarFacturaPorPeriodo(String periodo)throws ExcepcionNegocio;
        
        public Factura encontrarFacturaPorEstadoF(String estatadoF)throws ExcepcionNegocio;
        
        public Factura encontrarFacturaPorValor(Double valor)throws ExcepcionNegocio;
}
