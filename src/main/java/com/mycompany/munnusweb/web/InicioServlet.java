package com.mycompany.munnusweb.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.munnusweb.service.AdministradorService;
import com.mycompany.munnusweb.service.CargarDatosService;
import com.mycompany.munnusweb.service.FacturaService;
import com.mycompany.munnusweb.service.PropietarioService;
import com.mycompany.munnusweb.service.ViviendaService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("") // para servir el index
public class InicioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    @Inject
    AdministradorService adminService;
    @Inject
    PropietarioService propService;

    @Inject
    FacturaService facService;
    
    @Inject
    ViviendaService viviendaService;
    
    @Inject
    CargarDatosService cargador;

    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.err.println("Iniciando...");
        pruebas();
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        //PrintWriter out = response.getWriter();
        //out.write("Hola ALE");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void pruebas() {


        
        try {
            adminService.registrarAdministrador("1234", "1234", "Ana","1234", "123456","anamgfandi@gmail.com","2142003");

            propService.registrarPropietario("Fandiño", "1234", "pepe@gmail.com", "pepe", "12345678", "6358005");
            
            //viviendaService.registrarVivienda(ascensor, serialVersionUID, direccionVivienda, parking, portal, serialVersionUID);
            
            
            cargador.registrarDatos();
            
        } catch (ExcepcionNegocio e) {
            System.out.println(e.getMessage());


            

        }
    }
}
