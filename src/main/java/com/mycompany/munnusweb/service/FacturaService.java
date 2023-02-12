/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local; //java been de tipo local 

import com.mycompany.munnusweb.domain.Factura;
import java.time.LocalDateTime;


/**
 *
 * @author ana
 */
@Local
public interface FacturaService {
	public List<Factura> listarFacturas();

	public Factura encontrarFacturaPorID(int id);

	public void registrarFactura(String estadoF, LocalDateTime fechaEmision, String periodo, Double valor);

	//public void modificarFactura(Factura factura);
        //eliminar factura
	// generar factura
	// calcular factura
}
