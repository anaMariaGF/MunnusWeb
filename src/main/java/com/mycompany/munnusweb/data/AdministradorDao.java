/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Administrador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local
public interface AdministradorDao {
    
    public List<Administrador> findAllAdministrador();
    
    public Administrador findAdministradorByID(Administrador administrador);
    
    public Administrador findAdministradorByMatriculaAbogado(Administrador administrador);
    
    public void insertAdministrador(Administrador administrador);

    public void updateAdministrador(Administrador administrador);
    
    public void deleteAdministrador(Administrador administrador); 
    
}
