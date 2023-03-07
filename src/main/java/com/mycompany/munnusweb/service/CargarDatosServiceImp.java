/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.FacturaDao;
import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.domain.ViendaPropietario;
import com.mycompany.munnusweb.domain.Vivienda;
import com.mycompany.munnusweb.util.Encriptador;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */
@Stateless
public class CargarDatosServiceImp implements CargarDatosService{
    
    @Inject
    FacturaDao facturaDao;

    @Override
    public void registrarDatos() {
        // creamo el propietario sin mportar si esta elpropietario
        
               Propietario propietario1 =  new Propietario();
               propietario1.setApellidos("Gomez");
               propietario1.setNombres("Ana");
               propietario1.setEmail("anita@gmail.com");
               propietario1.setTelefono("1234567");
               propietario1.setNumeroCuentaBancaria("AB1234");
               propietario1.setEstadoCuentaA("Y");
               
         
               propietario1.setViviendaCollection(null);
               
        try {
            propietario1.setClave(Encriptador.encriptadoMD5("1234"));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CargarDatosServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ///
       
        
        Vivienda vivienda = new Vivienda();
        vivienda.setAscensor("Y");
        vivienda.setCoeficienteVivienda(0.10);
        vivienda.setDireccionVivienda("Calle greco 4");
        vivienda.setParking("Y");
        vivienda.setPortal("2");
        vivienda.setPropietarioCollection(null);
        
             
         //  revisar si tengo que actualiar la vinculacion     List<ViendaPropietario> escrituras = new ArrayList<>();              
               ViendaPropietario estritura = new ViendaPropietario();
               estritura.setPropietario(propietario1);
               estritura.setVienda(vivienda); 
        //       escrituras.add(estritura);
        
        Factura factura = new Factura();
        
        factura.setEstadoF("Inpago");
        factura.setFechaEmision(LocalDateTime.now());
        factura.setPeriodo("Marzo");
        factura.setVivienda(vivienda);
        factura.setValor(200);
       
                
        factura.setFechaEmision(LocalDateTime.MIN);
        
       // facturaDao.insertFactura(factura);
         
               
    }
    
    
}
