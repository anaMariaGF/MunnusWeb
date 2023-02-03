/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.domain.Propietario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local
public interface PropietarioService {
   
    public List<Propietario> listarPropietarios();
    public Propietario encontrarPropietariPorID(Propietario propietario);
    public Propietario econtrarUsuarioPorEmail (Propietario propietario);
    public void registrarUsuario(Propietario propietario);
    public void modificarUsuario(Propietario propietario);
    public void eliminarUsuario(Propietario propietario);
    
}
