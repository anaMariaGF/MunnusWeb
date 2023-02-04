/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.FacturaDao;
import com.mycompany.munnusweb.domain.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */
@Stateless
public class FacturaServiceImp implements FacturaService {
     // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
    @Inject    
    private FacturaDao facturaDao;
    
           
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Factura> listarFacturas() {       
        return facturaDao.findAllFacturas();
    }

    @Override
    public Factura encontrarFacturaPorID(Factura factura) {
        return facturaDao.findFacturaByID(factura);
    }

    @Override
    public void registrarUsuario(Factura factura) {
        facturaDao.insertFactura(factura);
    }

    @Override
    public void modificarUsuario(Factura factura) {
        facturaDao.updateFactura(factura);
    }

    @Override
    public void eliminarUsuario(Factura factura) {
        facturaDao.deleteFactura(factura);
    } 
}
