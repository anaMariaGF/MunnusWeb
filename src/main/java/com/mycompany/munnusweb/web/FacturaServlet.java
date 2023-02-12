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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ana
 */
@WebServlet("/facturas")
public class FacturaServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    FacturaService facturaService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {

        /**
         * Ahora este método va acceder al listado de personas por medio de la
         * instancia que estamos recibiendo el EJB
         */
        List<Factura> facturas = facturaService.listarFacturas();
        System.out.println("" + "Facturas : " + facturas);

        // Ponemos personas en un alcance, a request se le pueden setear uno o varios
        // atributos
        request.setAttribute("Facturas", facturas);

        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoFacturas.jsp").forward(request, respose);
    }

    /*
    Este código es un método procesa una solicitud HTTP POST.
    Recibe parámetros de la solicitud y los convierte a los tipos necesarios 
    para llamar a un método registrarFactura en un objeto facturaService. 
    Luego, este método registra una nueva factura con los datos proporcionados.
   
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("entrando");
        String estadoF = req.getParameter("estadoF");
        String fechaEmision = req.getParameter("fechaEmision"); //aqui lo puse STRING esta bien?
        String periodo = req.getParameter("periodo");
        String valor = req.getParameter("valor");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime fechaEmisionLocalDateTime = LocalDate.parse(fechaEmision, formatter).atTime(LocalTime.MIN);


        Double valorDouble = Double.parseDouble(valor);

        facturaService.registrarFactura(estadoF, fechaEmisionLocalDateTime, periodo, valorDouble);

    }
    /*
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            LocalDateTime fechaEmisionLocalDateTime = LocalDateTime.parse("fechaEmisionLoca");
            
            facturaService.
  
        }*/

}
