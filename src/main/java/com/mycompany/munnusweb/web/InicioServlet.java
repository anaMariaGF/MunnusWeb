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
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pruebas();
		request.getRequestDispatcher("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void pruebas() {
		try {
			adminService.registrarAdministrador("a", "1234", "ana", "gomez", "555", "anit@gmail.com", "hola");
		} catch (ExcepcionNegocio ex) {

			// reidirgia una pagian de eror en veira envoar jsp . con atributo de erores
			Logger.getLogger(InicioServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
                catch(Exception e){
                    System.out.println("com.mycompany.munnusweb.web.InicioServlet.pruebas()");
                    System.out.println(e.getMessage());
                }
                        

	}

}
