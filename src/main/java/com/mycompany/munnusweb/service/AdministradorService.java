/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Local;

import com.mycompany.munnusweb.domain.Administrador;
import com.mycompany.munnusweb.util.ExcepcionNegocio;

/**
 *
 * @author ana
 */

@Local
public interface AdministradorService {

	public List<Administrador> listarAdministradores();

	public Administrador encontrarAdministradorPorID(int id)  throws ExcepcionNegocio;

	public Administrador encontrarAdministradorPorMatriculaAbogado(String matricula)  throws ExcepcionNegocio;

	public void registrarAdministrador(String nif, String matriculaAbogado, String nombres, String apellidos,
	String telefono, String email, String clave) throws ExcepcionNegocio;


	public void administradorDeBaja(String matriculaAbogado) throws ExcepcionNegocio;

	public boolean iniciarSesionAdministrador(String matricula, String clave) throws ExcepcionNegocio;

	public void cambioClaveAdministrador(String matricula, String claveVieja, String claveNueva)
			throws ExcepcionNegocio;
}
