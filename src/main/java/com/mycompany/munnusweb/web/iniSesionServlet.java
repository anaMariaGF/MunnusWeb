package com.mycompany.munnusweb.web;

import com.mycompany.munnusweb.service.AdministradorService;
import com.mycompany.munnusweb.service.PropietarioService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ana
 */
@WebServlet("/inicioSesion")
public class iniSesionServlet extends HttpServlet {

    @Inject
    // Ahora definimos nuestra variable
    private AdministradorService administradorService; // Cremos una instancia de nuestra if local

    @Inject
    private PropietarioService propietarioService; // Cremos una instancia de nuestra if local

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String rol = req.getParameter("rol");
        String matriculaA = req.getParameter("matriculaA");
        String email = req.getParameter("email");
        String clave = req.getParameter("clave");

        try {
            if (rol.equalsIgnoreCase("admin")) {
                administradorService.inicarSesionAdministrador(matriculaA, clave);

            } else if (rol.equalsIgnoreCase("prop")) {

                propietarioService.inicarSesionPropietario(email, clave);

            }
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(iniSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
