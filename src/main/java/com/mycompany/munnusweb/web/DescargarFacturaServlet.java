/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import com.mycompany.munnusweb.util.GeneradoFacturas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/facturaD")
public class DescargarFacturaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

GeneradoFacturas f = new GeneradoFacturas();
//f.geneerarFactura(null, null, null);

        // copio la informacio  de comptadr a la repsusto 
        response.setHeader("Content-diposition", "attachment;filename=factura.txt");
        response.setContentType("txt/plain");
        Files.copy(Paths.get("factura.txt"),response.getOutputStream());

        //descargar
       response.flushBuffer();


    }


}
