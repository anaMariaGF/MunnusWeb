/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.Vivienda;

/**
 *
 * @author ana
 */
public interface ViviendaDao {

	public List<Vivienda> findAllViviendas();

	public Vivienda findViviendaByID(Vivienda vivienda);

	public Vivienda findViviendaByPropietario(Vivienda vivienda);

	public void insertVivienda(Vivienda vivienda);

	public void updateVivienda(Vivienda vivienda);

	public void deleteUsuario(Vivienda vivienda);
}
