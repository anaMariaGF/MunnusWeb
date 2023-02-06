/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Vivienda;

/**
 *
 * @author ana
 */
@Local
public interface ViviendaService {
	public List<Vivienda> listarViviendas();

	public Vivienda encontrarViviendaPorID(Vivienda vivienda);

	public Vivienda econtrarViviendaPorPropietario(Vivienda vivienda);

	public void registrarVivienda(Vivienda vivienda);

	public void modificarVivienda(Vivienda vivienda);

	public void eliminarVivienda(Vivienda vivienda);
}
