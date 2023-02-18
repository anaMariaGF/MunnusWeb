/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.service.FacturaService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/facturas")
public class FacturaServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    private FacturaService facturaService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String periodo = request.getParameter("periodo");

        if (periodo != null) {

            try {
                Factura fac = facturaService.encontrarFacturaPorPeriodo(periodo);

                ArrayList arrayList = new ArrayList();
                arrayList.add(fac);
                request.setAttribute("facturas", arrayList);

                // Redirigimos al JSP, a la url donde muestrro esta lista
                request.getRequestDispatcher("/listadoFacturas.jsp").forward(request, response);
            } catch (ExcepcionNegocio ex) {
                ex.printStackTrace();
                Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);

                ///redireigiria a lun apagina de error 
            }

        } else {

            /**
             * Ahora este método va acceder al listado de personas por medio de
             * la instancia que estamos recibiendo el EJB
             */
            List<Factura> facturas = facturaService.listarFacturas();
            System.out.println("Facturas : " + facturas);

            // Ponemos personas en un alcance, a request se le pueden setear uno o varios
            // atributos
            request.setAttribute("facturas", facturas);

            // Redirigimos al JSP
            request.getRequestDispatcher("/listadoFacturas.jsp").forward(request, response);
        }
    }

    /*
    Este código es un método procesa una solicitud HTTP POST.
    Recibe parámetros de la solicitud y los convierte a los tipos necesarios 
    para llamar a un método registrarFactura en un objeto facturaService. 
    Luego, este método registra una nueva factura con los datos proporcionados.
   
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Iniciando post ");
        System.out.println("entrando");
        
        String estadoF = req.getParameter("estadoF");
        String fechaEmision = req.getParameter("fechaEmision"); //aqui lo puse STRING esta bien?
        String periodo = req.getParameter("periodo");
        String valor = req.getParameter("valor");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime fechaEmisionLocalDateTime = LocalDate.parse(fechaEmision, formatter).atTime(LocalTime.MIN);

        try {
            Double valorDouble = Double.parseDouble(valor);
            facturaService.registrarFactura(estadoF, fechaEmisionLocalDateTime, periodo, valorDouble);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el valor a double: " + e.getMessage());
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(FacturaServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(); //ponerlo para ver mas detalles 
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDateTime fechaEmisionLocalDateTime = LocalDateTime.parse("fechaEmisionLoca");

        try {
            facturaService.eliminarFactura(fechaEmisionLocalDateTime);
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(FacturaServlet.class.getName()).log(Level.SEVERE, null, ex);

            req.setAttribute("Error", ex.getMessage());

            req.getRequestDispatcher("/listadoFacturas.jsp").forward(req, resp);
        }

    }

}
