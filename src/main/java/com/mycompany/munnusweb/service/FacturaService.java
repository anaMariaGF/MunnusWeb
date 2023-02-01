/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.domain.Factura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local
interface FacturaService {
    public List<Factura> listarFacturas();
    public Factura encontrarFacturaPorID(Factura factura);
    public void registrarUsuario(Factura factura);
    public void modificarUsuario(Factura factura);
    public void eliminarUsuario(Factura factura);
}
