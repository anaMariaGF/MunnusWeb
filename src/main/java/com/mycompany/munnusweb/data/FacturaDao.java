/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Factura;
import java.util.List;

/**
 *
 * @author ana
 */
public interface FacturaDao {
    
    public List<Factura> findAllFacturas();
    
    public Factura findFacturaByID(Factura factura);
        
    public void insertFactura(Factura factura);

    public void updateFactura(Factura factura);
    
    public void deleteFactura(Factura factura);  
}
