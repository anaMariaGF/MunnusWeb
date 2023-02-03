/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.domain.Administrador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local 
public interface AdministradorService {
    
    public List<Administrador> listarAdministradores();
    
    public Administrador encontrarAdministradorPorID(Administrador administrador);
    
    public Administrador encontrarAdministradorPorMatriculaAbogado(Administrador administrador);

    public void registrarAdministrador(Administrador administrador);
    
    public void modificarUsuario(Administrador administrador);
    
    public void eliminarUsuario(Administrador administrador);
    
}
