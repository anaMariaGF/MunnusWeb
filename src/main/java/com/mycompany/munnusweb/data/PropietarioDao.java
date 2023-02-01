/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Propietario;
import java.util.List;

/**
 *
 * @author ana
 */
public interface PropietarioDao {
    
    public List<Propietario> findAllPropietario() ;
    
    public Propietario findPropietarioByID(Propietario propietario);
    
    public Propietario findPropietarioByEmail(Propietario propietario);
    
    public void insertPropietario(Propietario propietario) ;

    public void updatePropietario(Propietario propietario);
    
    public void  deletePropietario(Propietario propietario);  
}
