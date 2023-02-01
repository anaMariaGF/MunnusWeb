/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.PropietarioDao;
import com.mycompany.munnusweb.domain.Propietario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */
@Stateless
public class PropietarioServiceImp implements PropietarioService {
      // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
    @Inject    
    private PropietarioDao propietarioDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Propietario> listarPropietarios() {       
        return propietarioDao.findAllPropietario() ;
    }

    @Override
    public Propietario encontrarPropietariPorID(Propietario propietario) {
        return propietarioDao.findPropietarioByID(propietario);
    }

    @Override
    public Propietario econtrarUsuarioPorEmail (Propietario propietario) {
        return propietarioDao.findPropietarioByEmail(propietario);
    }

    @Override
    public void registrarUsuario(Propietario propietario) {
        propietarioDao.insertPropietario(propietario);
    }

    @Override
    public void modificarUsuario(Propietario propietario) {
        propietarioDao.updatePropietario(propietario);
    }

    @Override
    public void eliminarUsuario(Propietario propietario) {
        propietarioDao.deletePropietario(propietario);
    }
    
    
}
