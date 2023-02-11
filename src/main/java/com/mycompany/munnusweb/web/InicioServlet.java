package com.mycompany.munnusweb.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.munnusweb.service.AdministradorService;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import java.io.PrintWriter;

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

    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.err.println("ingresando");
        pruebas();
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        //PrintWriter out = response.getWriter();
        //out.write("Hola ALE");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void pruebas()  {
        
        System.out.println("Ejecutadno pruebas)");


    }
}
