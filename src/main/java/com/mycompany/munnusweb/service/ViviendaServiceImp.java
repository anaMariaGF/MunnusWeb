/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.ViviendaDao;
import com.mycompany.munnusweb.domain.Vivienda;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Stateless
public class ViviendaServiceImp implements ViviendaService {

    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
    // usuarioDao
    @Inject
    private ViviendaDao viviendaDao;

    // Ahora nos apoyamos de la interfaz para completar los servicios
    @Override
    public List<Vivienda> listarViviendas() {
        return viviendaDao.findAllViviendas();
    }

    @Override
    public Vivienda encontrarViviendaPorID(int id_Vivienda) {
        return viviendaDao.findViviendaByID(id_Vivienda);
    }

    @Override
    public Vivienda econtrarViviendaPorPropietario(int id_propietario) throws ExcepcionNegocio {
        return viviendaDao.findViviendaByPropietario(id_propietario).orElseThrow(() -> new ExcepcionNegocio("No se puede encontrar la vivienda, ya que no se encuentra el propietario "));
    }

    @Override
    public void registrarVivienda(String ascensor, double coeficienteVivienda, String direccionVivienda, String parking, String portal, double totalPagar) throws ExcepcionNegocio {
        List<Vivienda> viviendas = viviendaDao.findAllViviendas();
        System.err.println("Trae viviendas  " + viviendas.size());

        // Verificamos que no exista una vivienda con la misma dirección
        for (Vivienda vivienda : viviendas) {
            if (vivienda.getDireccionVivienda().equals(direccionVivienda)) {
                throw new ExcepcionNegocio("La vivienda ya está registrada con la dirección " + direccionVivienda);
            }
        }

        Vivienda viviendaNueva = new Vivienda();
        viviendaNueva.setAscensor(ascensor);
        viviendaNueva.setCoeficienteVivienda(coeficienteVivienda);
        viviendaNueva.setDireccionVivienda(direccionVivienda);
        viviendaNueva.setParking(parking);
        viviendaNueva.setPortal(portal);
        viviendaNueva.setTotalPagar(totalPagar);

        viviendaDao.insertVivienda(viviendaNueva);
        System.out.println("La vivienda se ha registrado con éxito");

    }

    @Override
    public void modificarVivienda(String direccionVivienda, String ascensor,String parking, int idPropietario)throws ExcepcionNegocio{
        Vivienda vivienda = viviendaDao.findByDireccionVivienda(direccionVivienda).orElseThrow(() -> new ExcepcionNegocio("No se puede modificar la vivienda, ya que no se encuentra en la dirección especificada" + direccionVivienda));
        viviendaDao.updateVivienda(vivienda);
    }

    @Override
    public void eliminarVivienda(String direccionVivienda)throws ExcepcionNegocio{
        Vivienda vivienda = viviendaDao.findByDireccionVivienda(direccionVivienda)
                .orElseThrow(
                        () -> new ExcepcionNegocio("No se puede dar de baja la vivienda, ya que no se encuentra en la dirección especificada"));

        viviendaDao.deleteVivienda(vivienda);
    }
 
}

