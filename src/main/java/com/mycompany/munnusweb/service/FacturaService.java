/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local; //java been de tipo local 

import com.mycompany.munnusweb.domain.Factura;

/**
 *
 * @author ana
 */
@Local
public interface FacturaService {
	public List<Factura> listarFacturas();

	public Factura encontrarFacturaPorID(Factura factura);

	public void registrarUsuario(Factura factura);

	public void modificarUsuario(Factura factura);

	public void eliminarUsuario(Factura factura);

	// generar factura
	// calcular factura
}
