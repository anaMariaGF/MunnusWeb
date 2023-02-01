/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.AdministradorDao;
import com.mycompany.munnusweb.domain.Administrador;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */

/*este código define una clase de servicio llamada AdministradorServiceImp 
que implementa la interfaz AdministradorService, esta clase es anotada con 
@Stateless lo cual significa que esta clase proveerá servicios sin estado. 
Esto quiere decir que los datos o estado no se guardarán entra las llamadas 
a los métodos de esta clase.*/
@Stateless
public class AdministradorServiceImp implements AdministradorService {
    
    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
   
   /*Esta linea de código es parte de una clase y está usando la anotación @Inject.
   Esto indica que se está inyectando una dependencia de la clase AdministradorDao,
   para que se pueda usar en la clase actual.*/
    @Inject    
    private AdministradorDao administradorDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Administrador> listarAdministradores() {       
        return administradorDao.findAllAdministrador();
    }

    @Override
    public Administrador encontrarAdministradorPorID(Administrador administrador) {
        return administradorDao.findAdministradorByID(administrador);
    }

    @Override
    public Administrador encontrarAdministradorPorMatriculaAbogado(Administrador administrador){
        return administradorDao.findAdministradorByMatriculaAbogado(administrador);
    }

    @Override
    public void registrarAdministrador(Administrador administrador) {
        administradorDao.insertAdministrador(administrador);
    }

    @Override
    public void modificarUsuario(Administrador administrador) {
        administradorDao.updateAdministrador(administrador);
    }

    @Override
    public void eliminarUsuario(Administrador administrador) {
        administradorDao.deleteAdministrador(administrador);
    }

    
}
