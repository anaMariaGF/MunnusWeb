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
		 * Ahora este método va acceder al listado de personas por medio de la instancia
		 * que estamos recibiendo el EJB
		 */
		List<Administrador> administradores = administradorService.listarAdministradores();
		System.out.println("Administradores: " + administradores);

		// Ponemos personas en un alcance, a request se le pueden setear uno o varios
		// atributos
		request.setAttribute("administradores", administradores);

		// Redirigimos al JSP, a la url donde muestrro esta lista
		request.getRequestDispatcher("/listadoAdministradores.jsp").forward(request, respose);

	}
}
