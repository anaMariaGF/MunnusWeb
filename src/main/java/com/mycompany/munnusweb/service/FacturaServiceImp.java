/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.FacturaDao;
import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.time.LocalDateTime;

/**
 *
 * @author ana
 */
@Stateless
public class FacturaServiceImp implements FacturaService {
    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
    // usuarioDao

    @Inject
    private FacturaDao facturaDao;

    // Ahora nos apoyamos de la interfaz para completar los servicios
    @Override
    public List<Factura> listarFacturas() {
        return facturaDao.findAllFacturas();
    }

    @Override
    public Factura encontrarFacturaPorID(int id) {
        return facturaDao.findFacturaByID(id);
    }
    /*
    Este método tiene como función registrar una nueva factura 
    en el sistema. En el código, se usa una anotación @Override para indicar 
    que este método está sobrescribiendo un método de una clase padre.

    Luego, se obtienen todas las facturas existentes a través del método 
    findAllFacturas() del objeto facturaDao, que se asume es un objeto de una
    clase que implementa la lógica de acceso a datos para facturas.

    A continuación, se recorre la lista de facturas y se comprueba si existe
    una factura emitida en la misma fecha o en el mismo periodo que la factura
    que se quiere registrar. En caso de que exista una factura emitida en la
    misma fecha, se muestra un mensaje de error con los detalles de la factura 
    existente. Si existe una factura en el mismo periodo, se muestra un mensaje 
    de error con el estado, fecha de emisión y valor de la factura existente.

    Finalmente, se crea un nuevo objeto de tipo Factura y se establecen los 
    valores de sus atributos correspondientes a los parámetros del método. 
    Luego, se inserta la nueva factura en el sistema a través del método 
    insertFactura() de facturaDao. Por último, se muestra un mensaje indicando 
    que la factura ha sido registrada con éxito.
    */

    @Override
    public void registrarFactura(String estado, LocalDateTime fechaEmision, String periodo, Double valor)throws ExcepcionNegocio{

        System.out.println("Servicio registara factura ");
        List<Factura> facturas = facturaDao.findAllFacturas();
        System.err.println("Trae facturas  " + facturas.size());
        
        for (Factura factura : facturas) {
            boolean existeUnaFacturaEmitidaLaMismaFecha = factura.getFechaEmision().equals(fechaEmision);
            boolean existeLaFacturaDeEstePeriodo = factura.getPeriodo().equals(periodo);

            if (existeUnaFacturaEmitidaLaMismaFecha) {
                System.err.println("Esta factura fue registrada el: " 
                        + factura.getFechaEmision() + " Su valor es de " 
                        + factura.getValor() + " y su estado es: " 
                        + factura.getEstadoF());

            }
            if (existeLaFacturaDeEstePeriodo) {
                System.err.println("Esta factura ya esta registrada y su estado es:  " + estado 
                        + " Su fecha de emision es: " + factura.getFechaEmision() 
                        + " Y su valor es de " + factura.getValor());
            }
        }
        //Nueva factura:

        Factura factura = new Factura();
        factura.setEstadoF(estado);
        factura.setFechaEmision(fechaEmision);
        factura.setPeriodo(periodo);
        factura.setValor(valor);

        facturaDao.insertFactura(factura);
        System.out.println("Se ha registrado la factura con éxito ");
    }
    
    @Override
    public void modificarFactura(String estado, LocalDateTime fechaEmision, String periodo, Double valor) throws ExcepcionNegocio{
        Factura factura = facturaDao.findFacturaByFechaEmision(fechaEmision).orElseThrow(()->
                new ExcepcionNegocio("No se puede modificar la factura, ya que no se encuentra en la fecha de emisión especificada" + fechaEmision));
        facturaDao.updateFactura(factura);
    }
    
    @Override
    public void eliminarFactura(LocalDateTime fechaEmision)throws ExcepcionNegocio{
        Factura factura = facturaDao.findFacturaByFechaEmision(fechaEmision).orElseThrow(()->
                new ExcepcionNegocio("No se puede eliminar la factura, ya que no se encuentra en la fecha de emisión especificada" + fechaEmision));
        facturaDao.deleteFactura(factura);
    }
    
    @Override
    public Factura encontrarFacturaPorFechaEmision(LocalDateTime fechaEmision)throws ExcepcionNegocio{
        return facturaDao.findFacturaByFechaEmision(fechaEmision).orElseThrow(()->
                new ExcepcionNegocio("No se puede encontrar la factura, ya que no se encuentra en la fecha de emisión especificada" + fechaEmision));
 
    }

    @Override
    public Factura encontrarFacturaPorPeriodo(String periodo) throws ExcepcionNegocio {
        return facturaDao.findFacturaByPeriodo(periodo).orElseThrow(()->
                new ExcepcionNegocio("No se puede encontrar la factura, ya que no se encuentra en el periodo especificado" + periodo));
    }

    @Override
    public Factura encontrarFacturaPorEstadoF(String estatadoF) throws ExcepcionNegocio {
        return facturaDao.findFacturaByEstadoF(estatadoF).orElseThrow(()->
                new ExcepcionNegocio("No se puede encontrar la factura, ya que no se encuentra en el estatdo de la factura especificado" + estatadoF));
    }

    @Override
    public Factura encontrarFacturaPorValor(Double valor) throws ExcepcionNegocio {
        return facturaDao.findFacturaByValor(valor).orElseThrow(()->
                new ExcepcionNegocio("No se puede encontrar la factura, ya que no se encuentra en el valor especificado" + valor));
    }
    
    
}
