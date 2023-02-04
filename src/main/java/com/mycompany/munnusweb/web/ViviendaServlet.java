/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.web;


import com.mycompany.munnusweb.domain.Vivienda;
import com.mycompany.munnusweb.service.ViviendaService;
import com.mycompany.munnusweb.service.ViviendaServiceImp;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ana
 */
@WebServlet("/viviendas")
public class ViviendaServlet extends HttpServlet {
            
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ViviendaService viviendaService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Vivienda> viviendas = viviendaService.listarViviendas();
        System.out.println(""
                + "Viviendas: " + viviendas );
        
        // Ponemos personas en un alcance, a request se le pueden setear uno o varios atributos
        request.setAttribute("Viviendas", viviendas);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoViviendas.jsp").forward(request, 
                respose);
    }
}
