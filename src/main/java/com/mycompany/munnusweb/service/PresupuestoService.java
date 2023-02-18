/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Local
public interface PresupuestoService {

    public List<Presupuesto> listarPresupuestos();

    public Presupuesto encontrarPresupuestoPorID(int idAdmin, int idPresupuesto) throws ExcepcionNegocio;
    
    public Presupuesto encontrarPresupuestoPorNombreComunidad(String nombreComunidad) throws ExcepcionNegocio;

    public void registrarPresupuesto(String nombreComunidad, int numProtales, Double totalPresupuesto) throws ExcepcionNegocio;

    public void modificarPresupuesto(int idAdmin, int idPresupuesto) throws ExcepcionNegocio;

    public void eliminarPresupuesto(int idAdmin, int idPresupuesto) throws ExcepcionNegocio;

}
