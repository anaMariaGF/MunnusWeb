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

    /*
    método que devuelve una lista de todas las viviendas registradas en el 
    sistema. Hace uso del método findAllViviendas() de la instancia viviendaDao.
    
    */
    @Override
    public List<Vivienda> listarViviendas() {
        return viviendaDao.findAllViviendas();
    }
    /*
     método que devuelve una vivienda que tiene el ID pasado como parámetro. 
    Hace uso del método findViviendaByID(id_Vivienda) de la instancia viviendaDao.
    
    */

    @Override
    public Vivienda encontrarViviendaPorID(int id_Vivienda) {
        return viviendaDao.findViviendaByID(id_Vivienda);
    }
    /*
     método que devuelve una vivienda que tiene el propietario pasado como 
    parámetro. Hace uso del método findViviendaByPropietario(id_propietario) 
    de la instancia viviendaDao. Si no se encuentra ninguna vivienda con el 
    propietario especificado, se lanza una excepción ExcepcionNegocio.
   
    */

    @Override
    public Vivienda econtrarViviendaPorPropietario(int id_propietario) 
            throws ExcepcionNegocio {
        return viviendaDao.findViviendaByPropietario(id_propietario)
                .orElseThrow(() -> new ExcepcionNegocio("No se puede encontrar "
                        + "la vivienda, ya que no se encuentra el propietario "));
    }
    
    /*
    método que registra una nueva vivienda con los datos pasados como parámetros.
    Primero verifica que no exista una vivienda con la misma dirección. Si ya 
    existe una vivienda con esa dirección, se lanza una excepción 
    ExcepcionNegocio. Si no existe una vivienda con esa dirección, se crea una
    nueva instancia de Vivienda y se asignan los datos pasados como parámetros.
    Finalmente, se usa el método insertVivienda(viviendaNueva) de la instancia 
    viviendaDao para insertar la nueva vivienda en el sistema.
    
    */

    @Override
    public void registrarVivienda(String ascensor, double coeficienteVivienda,
            String direccionVivienda, String parking, String portal, 
            double totalPagar) throws ExcepcionNegocio {
        List<Vivienda> viviendas = viviendaDao.findAllViviendas();
        System.err.println("Trae viviendas  " + viviendas.size());

        // Verificamos que no exista una vivienda con la misma dirección
        for (Vivienda vivienda : viviendas) {
            if (vivienda.getDireccionVivienda().equals(direccionVivienda)) {
                throw new ExcepcionNegocio("La vivienda ya está registrada con "
                        + "la dirección " + direccionVivienda);
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
    /*
    método que modifica una vivienda con los datos pasados como parámetros. 
    Primero se busca la vivienda con la dirección especificada usando el
    método findByDireccionVivienda(direccionVivienda) de la instancia 
    viviendaDao. Si no se encuentra ninguna vivienda con esa dirección, se 
    lanza una excepción ExcepcionNegocio. Si se encuentra la vivienda, se 
    actualiza la información de la vivienda y se guarda en el sistema usando el
    método updateVivienda(vivienda) de la instancia viviendaDao.
    */

    @Override
    public void modificarVivienda(String direccionVivienda, String ascensor, 
            String parking, int idPropietario) throws ExcepcionNegocio {
        Vivienda vivienda = viviendaDao.findByDireccionVivienda
        (direccionVivienda).orElseThrow(() -> new ExcepcionNegocio
        ("No se puede modificar la vivienda, ya que no se encuentra en la "
                + "dirección especificada" + direccionVivienda));
        viviendaDao.updateVivienda(vivienda);
    }
    
    /*
    método que elimina una vivienda con la dirección pasada como parámetro.
    Primero se busca la vivienda con la dirección especificada usando el
    método findByDireccionVivienda(direccionVivienda) de la instancia 
    viviendaDao. Si no se encuentra ninguna vivienda con esa dirección, 
    se lanza una excepción ExcepcionNegocio. Si se encuentra la vivienda, se 
    elimina del sistema usando el método deleteVivienda(vivienda) de la 
    instancia viviendaDao.
    */

    @Override
    public void eliminarVivienda(String direccionVivienda) 
            throws ExcepcionNegocio {
        Vivienda vivienda = viviendaDao.
                findByDireccionVivienda(direccionVivienda)
                .orElseThrow(
                        () -> new ExcepcionNegocio("No se puede dar de baja la"
                                + " vivienda, ya que no se encuentra en la "
                                + "dirección especificada"));

        viviendaDao.deleteVivienda(vivienda);
    }
    /*
    método que devuelve una vivienda que tiene la dirección pasada como
    parámetro. Hace uso del método findByDireccionVivienda(direccionVivienda
    ) de la instancia viviendaDao. Si no se encuentra ninguna vivienda con la 
    dirección especificada, se lanza una excepción ExcepcionNegocio.
    
    */

    @Override
    public Vivienda econtrarViviendaPorDireccion(String direccionVivienda) 
            throws ExcepcionNegocio {
         return viviendaDao.findByDireccionVivienda(direccionVivienda)
                 .orElseThrow(() -> new ExcepcionNegocio("No se puede "
                         + "encontrar la vivienda, ya que no se encuentra "
                         + "la dirección: " + direccionVivienda));
    }

}
