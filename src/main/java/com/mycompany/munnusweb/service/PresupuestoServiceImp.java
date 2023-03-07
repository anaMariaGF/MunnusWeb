/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.PresupuestoDao;
import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Stateless
public class PresupuestoServiceImp implements PresupuestoService {

    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
    // usuarioDao
    @Inject
    private PresupuestoDao presupuestoDao;


    @Override
    public List<Presupuesto> listarPresupuestos() {
        return presupuestoDao.findAllPresupuestos();
    }

    @Override
    public Presupuesto encontrarPresupuestoPorID(int idAdmin, int idPresupuesto) 
            throws ExcepcionNegocio{
        PresupuestoPK presupuestoId = new PresupuestoPK();
        presupuestoId.setIdAdministrador(idAdmin);
        presupuestoId.setIdPresupuesto(idPresupuesto);
        Presupuesto presupuesto = presupuestoDao.
                findPresupuestoByID(presupuestoId).orElseThrow(() -> new
         ExcepcionNegocio("No se encontro el presupuesto."));
        return presupuesto;
    }

    @Override
    public void registrarPresupuesto(String nombreComunidad,
            int numProtales, Double totalPresupuesto) throws ExcepcionNegocio {

        List<Presupuesto> presupuestos = presupuestoDao.findAllPresupuestos();
        System.err.println("Trae presupuestos  " + presupuestos.size());
/*
        TODO: HAY QU EMIRAR LO DE VIGENCIA DEL PRESUPUESTO
        
        for (Presupuesto presupuesto : presupuestos) {
            boolean existeLaComunidad = presupuesto.getNombreComunidad().equals(nombreComunidad);

            if (existeLaComunidad) {
                throw new ExcepcionNegocio("Ya existe un presupuesto para la comunidad " + nombreComunidad);
            }
        }*/

        Presupuesto presupuestoNuevo = new Presupuesto();
        presupuestoNuevo.setNombreComunidad(nombreComunidad);
        presupuestoNuevo.setNumProtales(numProtales);
        presupuestoNuevo.setTotalPresupuesto(totalPresupuesto);

        presupuestoDao.insertPresupuesto(presupuestoNuevo);

        System.out.println("Se ha registrado el presupuesto para la comunidad " + nombreComunidad + " con éxito "); 
    }

    @Override
    public void modificarPresupuesto(int idAdmin, int idPresupuesto)
            throws ExcepcionNegocio {
        PresupuestoPK presupuestoId = new PresupuestoPK();
        presupuestoId.setIdAdministrador(idAdmin);
        presupuestoId.setIdPresupuesto(idPresupuesto);
        Presupuesto presupuesto = presupuestoDao.findPresupuestoByID
        (presupuestoId).orElseThrow(() -> new ExcepcionNegocio
        ("No se puede actulizar"));
        presupuestoDao.updatePresupuesto(presupuesto);
    }

    @Override
    public void eliminarPresupuesto(int idAdmin, int idPresupuesto)
            throws ExcepcionNegocio{
           PresupuestoPK presupuestoId = new PresupuestoPK();
        presupuestoId.setIdAdministrador(idAdmin);
        presupuestoId.setIdPresupuesto(idPresupuesto);
        Presupuesto presupuesto = presupuestoDao.findPresupuestoByID
        (presupuestoId).orElseThrow(() -> new ExcepcionNegocio
        ("No se puede eliminar"));
        presupuestoDao.deletePresupuesto(presupuesto);
    }

    @Override
    public Presupuesto encontrarPresupuestoPorNombreComunidad
        (String nombreComunidad) throws ExcepcionNegocio {
        return presupuestoDao.findPresupuestoByNombreComunidad(nombreComunidad)
                .orElseThrow(() -> new ExcepcionNegocio
        ("No se ha encontrado el presupuesto de la comunidad: " + nombreComunidad));
         
    }
}
