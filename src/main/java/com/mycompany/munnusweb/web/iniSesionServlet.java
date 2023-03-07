package com.mycompany.munnusweb.web;

import com.mycompany.munnusweb.service.AdministradorService;
import com.mycompany.munnusweb.service.PropietarioService;
import com.mycompany.munnusweb.service.ViviendaService;
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

@WebServlet("/inicioSesion")
public class iniSesionServlet extends HttpServlet {

    @Inject
    private AdministradorService administradorService;

    @Inject
    private PropietarioService propietarioService;
    
      @Inject
    private ViviendaService viviendaoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/formularioInicioSesion.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String rol = req.getParameter("rol");
        String matriculaA = req.getParameter("matriculaA");
        String email = req.getParameter("email");
        String clave = req.getParameter("clave");

        // Validar los parámetros de la solicitud
        if (rol == null || rol.isEmpty() || 
            (rol.equalsIgnoreCase("admin") && (matriculaA == null || matriculaA.isEmpty())) || 
            (rol.equalsIgnoreCase("prop") && (email == null || email.isEmpty())) || 
            clave == null || clave.isEmpty()) {
            req.setAttribute("mensajeError", "Por favor, completa todos los campos.");
            req.getRequestDispatcher("/formularioInicioSesion.jsp").forward(req, resp);
            return;
        }
        
        try {
            if (rol.equalsIgnoreCase("admin")) {
                if (administradorService.iniciarSesionAdministrador(matriculaA, clave)) {
                    req.getRequestDispatcher("/paneldAdmin.jsp").forward(req, resp);
                } else {
                    req.setAttribute("mensajeError", "Matrícula o clave incorrecta. Por favor, inténtalo de nuevo.");
                    req.getRequestDispatcher("/inicioSesionAdmin.jsp?tipo=admin").forward(req, resp);
                }
            } else if (rol.equalsIgnoreCase("prop")) {
                if (propietarioService.iniciarSesionPropietario(email, clave)) {
                    
                  
                    
                    String nombreImg = "tia.jpg";
                    req.setAttribute("imgUrl", nombreImg);
                    req.setAttribute("propietario",   propietarioService.econtrarPropietarioPorEmail(email));
                    
                    
                    req.setAttribute("viviendas", viviendaoService.listarViviendas());
                    
                    req.getRequestDispatcher("/panelProp.jsp").forward(req, resp);
                } else {
                    req.setAttribute("mensajeError", "Email o clave incorrecta. Por favor, inténtalo de nuevo.");
                    req.getRequestDispatcher("/inicioSesionProp.jsp?tipo=prop").forward(req, resp);
                }
            } else {
                req.setAttribute("mensajeError", "Rol incorrecto. Por favor, selecciona un rol válido.");
                req.getRequestDispatcher("/formularioInicioSesion.jsp").forward(req, resp);
            }
        } catch (ExcepcionNegocio ex) {
            Logger.getLogger(iniSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("mensajeError", "Hubo un error al iniciar sesión. Por favor, inténtalo de nuevo.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
