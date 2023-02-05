/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Administrador;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author ana
 */

public interface AdministradorDao {
    
    public List<Administrador> findAllAdministrador();
    
    public Optional<Administrador> findAdministradorByID(int idAdmin);
    
    public Optional<Administrador> findAdministradorByMatriculaAbogado(String matriculaABuscar);
    
    public void insertAdministrador(Administrador administrador);

    public void updateAdministrador(Administrador administrador);
    
    public void deleteAdministrador(Administrador administrador); 
    
}
