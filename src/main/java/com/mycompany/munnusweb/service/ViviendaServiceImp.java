/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.ViviendaDao;
import com.mycompany.munnusweb.domain.Vivienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */
@Stateless
public class ViviendaServiceImp implements ViviendaService{
    
    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
    @Inject    
    private ViviendaDao viviendaDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Vivienda> listarViviendas() {       
        return viviendaDao.findAllViviendas();
    }

    @Override
    public Vivienda encontrarViviendaPorID(Vivienda vivienda) {
        return viviendaDao.findViviendaByID(vivienda);
    }

    @Override
    public Vivienda econtrarViviendaPorPropietario(Vivienda vivienda) {
        return viviendaDao.findViviendaByPropietario(vivienda);
    }

    @Override
    public void registrarVivienda(Vivienda vivienda) {
        viviendaDao.insertVivienda(vivienda);
    }

    @Override
    public void modificarVivienda(Vivienda vivienda) {
        viviendaDao.updateVivienda(vivienda);
    }

    @Override
    public void eliminarVivienda(Vivienda vivienda) {
        viviendaDao.deleteUsuario(vivienda);
    }
}
