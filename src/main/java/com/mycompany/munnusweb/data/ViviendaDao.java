/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.Vivienda;
import java.util.Optional;

/**
 *
 * @author ana
 */
public interface ViviendaDao {

    public List<Vivienda> findAllViviendas();

    public Vivienda findViviendaByID(int id_vivienda);

    public Optional <Vivienda> findViviendaByPropietario(int id_propietario);

    public Optional <Vivienda> findByDireccionVivienda(String direccionVvivienda);

    public void insertVivienda(Vivienda vivienda);

    public void updateVivienda(Vivienda vivienda);

    public void deleteVivienda(Vivienda vivienda);
}
