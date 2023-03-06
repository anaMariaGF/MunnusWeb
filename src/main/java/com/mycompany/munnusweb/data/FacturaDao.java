/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.Factura;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author ana
 */

public interface FacturaDao {

	public List<Factura> findAllFacturas();

	public Factura findFacturaByID(int id);

	public void insertFactura(Factura factura);

	public void updateFactura(Factura factura);

	public void deleteFactura(Factura factura);
        
        public Optional<Factura> findFacturaByFechaEmision(LocalDate fechaEmision);

        public Optional<Factura> findFacturaByPeriodo(String periodo);
        
        public Optional<Factura> findFacturaByEstadoF(String estatadoF);
        
        public Optional<Factura> findFacturaByValor(Double valor);

}
