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

import com.mycompany.munnusweb.domain.Administrador;
import com.mycompany.munnusweb.service.AdministradorService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
@WebServlet("/administradores")
public class AdministradorServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    AdministradorService administradorService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {

        /*
		 * //Especificamos formato de respuesta
		 * 
		 * PrintWriter salida=respose.getWriter();
		 * 
		 * //generar respuesta de la peticion salida.println("<html><body>");
		 * salida.println("<h1 style = 'text-align:center'>Prueba Servlet</h1>");
		 * salida.println("Fecha y hora actual: " + new Date());
		 * salida.println("</body></html>");
         */
        /**
         * Ahora este método va acceder al listado de personas por medio de la
         * instancia que estamos recibiendo el EJB
         */
        String matricula = request.getParameter("matricula");
        String nif = request.getParameter("nif");

        if (matricula != null) {

            try {
                Administrador admin = administradorService.encontrarAdministradorPorMatriculaAbogado(matricula);

                ArrayList arrayList = new ArrayList();
                arrayList.add(admin);
                request.setAttribute("administradores", arrayList);

                // Redirigimos al JSP, a la url donde muestrro esta lista
                request.getRequestDispatcher("/listadoAdministradores.jsp").forward(request, respose);

                ///redireigiria a la pagina requerida, 
            } catch (ExcepcionNegocio ex) {
                Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);

                ///redireigiria a lun apagina de error 
            }

        } else {
            List<Administrador> administradores = administradorService.listarAdministradores();
            System.out.println("Administradores: " + administradores);

            // Ponemos personas en un alcance, a request se le pueden setear uno o varios
            // atributos
            request.setAttribute("administradores", administradores);

            // Redirigimos al JSP, a la url donde muestrro esta lista
            request.getRequestDispatcher("/listadoAdministradores.jsp").forward(request, respose);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.err.println("entrando");
        String nif = req.getParameter("nif");
        String nombres = req.getParameter("nombres");
        String matriculaAbogado = req.getParameter("matriculaAbogado");
        String apellidos = req.getParameter("apellidos");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");
        String clave = req.getParameter("clave");

        System.err.println("mensaje " + nombres);

        try {
            administradorService.registrarAdministrador(nif, matriculaAbogado, nombres, apellidos, telefono, email, clave);
        } catch (ExcepcionNegocio ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String matriculaAbogado = req.getParameter("matriculaAbogado");

        try {
            administradorService.administradorDeBaja(matriculaAbogado);
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
