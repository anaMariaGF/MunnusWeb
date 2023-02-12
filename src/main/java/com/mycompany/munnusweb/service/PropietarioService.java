/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */
@Local
public interface PropietarioService {

	public List<Propietario> listarPropietarios();

	public Propietario encontrarPropietarioPorID(int id) throws ExcepcionNegocio;

	public Propietario econtrarPropietarioPorEmail(String Email) throws ExcepcionNegocio;

	public void registrarPropietario(String apellidos, String clave, String email, String nombres, String numeroCuentaBancaria, String telefono) throws ExcepcionNegocio;
        
        public boolean inicarSesionPropietario(String email, String clave) throws ExcepcionNegocio;
        
        public void cambioClavePropietario(String email, String claveVieja, String claveNueva) throws ExcepcionNegocio;

	public void modificarPropietario(Propietario propietario);

	public void eliminarPropietario(Propietario propietario);
        
        public void propietarioDeBaja(String email) throws ExcepcionNegocio;
}
