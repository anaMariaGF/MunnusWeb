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

import com.mycompany.munnusweb.domain.TipoGastos;
import com.mycompany.munnusweb.service.TipoGastosService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/tipoGastos")
public class TipoGastosServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    TipoGastosService tipoGastosService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");

        if (descripcion != null) {

            try {
                TipoGastos tipoGastos = tipoGastosService.encontrarTipoGastosPorDescripcion(descripcion);

                ArrayList arrayList = new ArrayList();
                arrayList.add(tipoGastos);
                request.setAttribute("Tipo de Gasto: ", arrayList);

                // Redirigimos al JSP, a la url donde muestrro esta lista
                request.getRequestDispatcher("/listadoPropietarios.jsp").forward(request, response);
            } catch (ExcepcionNegocio ex) {
                Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);

                ///redireigiria a lun apagina de error 
            }

        } else {

            /**
             * Ahora este método va acceder al listado de personas por medio de
             * la instancia que estamos recibiendo el EJB
             */
            List<TipoGastos> tipoGastosL = tipoGastosService.listarTipoGastos();
            System.out.println("Tipos de gastos: " + tipoGastosL);

            // Ponemos personas en un alcance, a request se le pueden setear uno o varios
            // atributos
            request.setAttribute("tipoGastos", tipoGastosL);

            // Redirigimos al JSP
            request.getRequestDispatcher("/listadoTipoGastos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // se elee el parametro que llegue oir urk
        String descripcion = req.getParameter("descripcion");

        TipoGastos gasto = new TipoGastos();
        gasto.setDescripcion(descripcion);

        try {
            tipoGastosService.registrarTipoGasto(gasto);
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(TipoGastosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // redirgimos a la siguiente pagina
        req.getRequestDispatcher("listadoTipoGastos.jsp"); // .forward(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id_gasto = Integer.parseInt(req.getParameter("id_TipoGasto"));

        try {
            tipoGastosService.eliminarTipoGasto(id_gasto);
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(TipoGastosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
