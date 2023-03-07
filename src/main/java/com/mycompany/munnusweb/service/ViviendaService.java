/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Vivienda;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Local
public interface ViviendaService {

    public List<Vivienda> listarViviendas();

    public void registrarVivienda(String ascensor, double coeficienteVivienda, String direccionVivienda, String parking, String portal, double totalPagar) throws ExcepcionNegocio;

    public void modificarVivienda(String direccionVivienda, String ascensor, String parking, int idPropietario) throws ExcepcionNegocio;

    public void eliminarVivienda(String direccionVivienda) throws ExcepcionNegocio;

    public Vivienda encontrarViviendaPorID(int id_vivienda);

    public Vivienda econtrarViviendaPorPropietario(int id_Propietario) throws ExcepcionNegocio;
    
    public Vivienda econtrarViviendaPorDireccion(String direccionVivienda) throws ExcepcionNegocio;
}
