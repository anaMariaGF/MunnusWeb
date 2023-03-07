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

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.service.PresupuestoService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/presupuestos")
public class PresupuestoServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    PresupuestoService presupuestoService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombreComunidad = request.getParameter("nombreComunidad");

        if (nombreComunidad != null) {

            try {
                Presupuesto presupuesto = presupuestoService.encontrarPresupuestoPorNombreComunidad(nombreComunidad);

                ArrayList arrayList = new ArrayList();
                arrayList.add(presupuesto);
                request.setAttribute("presupuestos", arrayList);

                // Redirigimos al JSP, a la url donde muestrro esta lista
                request.getRequestDispatcher("/listadoFacturas.jsp").forward(request, response);
            } catch (ExcepcionNegocio ex) {
                Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        List<Presupuesto> presupuestos = presupuestoService.listarPresupuestos();
        System.out.println("" + "Presupuestos : " + presupuestos);

        request.setAttribute("Presupuestos", presupuestos);

        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoPresupuestos.jsp").forward(request, response);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("entrando");
        String nombreComunidad = req.getParameter("nombreComunidad");
        int numPortales = Integer.parseInt(req.getParameter("numPortales"));
        double totalPresupuesto = Double.parseDouble(req.getParameter("totalPresupuesto"));

        System.err.println("mensaje " + nombreComunidad);

        try {
            presupuestoService.registrarPresupuesto(nombreComunidad, numPortales, totalPresupuesto);
        } catch (ExcepcionNegocio ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPresupuesto = Integer.parseInt(req.getParameter("idPresupuesto"));
        int idAdmin = Integer.parseInt(req.getParameter("idAdmin"));

        try {
            presupuestoService.eliminarPresupuesto(idAdmin, idPresupuesto);
        } catch (ExcepcionNegocio ex) {
            ex.printStackTrace();
        }

    }
}
