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

import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.service.PropietarioService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/propietarios")
public class PropietarioServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    PropietarioService propietarioService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        if (email != null) {

            try {
                Propietario prop = propietarioService.econtrarPropietarioPorEmail(email);

                ArrayList arrayList = new ArrayList();
                arrayList.add(prop);
                request.setAttribute("propietarios", arrayList);

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
            List<Propietario> propietarios = propietarioService.listarPropietarios();
            System.out.println("Propietarios: " + propietarios);

            // Ponemos personas en un alcance, a request se le pueden setear uno o varios
            // atributos
            request.setAttribute("Propietarios", propietarios);

            // Redirigimos al JSP
            request.getRequestDispatcher("/listadoPropietarios.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("entrando");
        String apellidos = req.getParameter("apellido").trim();
        String clave = req.getParameter("clave").trim();
        String email = req.getParameter("email").trim();
        String nombres = req.getParameter("nombre").trim();
        String numeroCuentaBancaria = req.getParameter("numero_cuenta").trim();
        String telefono = req.getParameter("telefono").trim();

       

        try {
            propietarioService.registrarPropietario(apellidos, clave, email, nombres, numeroCuentaBancaria, telefono);
            req.getRequestDispatcher("/inicioSesionProp.jsp").forward(req, resp);
        } catch (ExcepcionNegocio ex) {
            System.out.println("Error:" + ex.getMessage());

          req.setAttribute("msgError", ex.getMessage());
          req.getRequestDispatcher("/formProp.jsp").forward(req, resp);
        }
        

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        try {
            propietarioService.propietarioDeBaja(email);
        } catch (ExcepcionNegocio ex) {
            ex.printStackTrace(); //luego cambiarlo por el usuario (red a pag o a la misma)

            req.setAttribute("Error", ex.getMessage());

            req.getRequestDispatcher("/listadoPropietarios.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = "s";
        String claveVieja = "";
        String claveNueva = ";";

        try {
            propietarioService.cambioClavePropietario(email, claveVieja, claveNueva);
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(PropietarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
