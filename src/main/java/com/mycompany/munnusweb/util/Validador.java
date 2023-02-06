/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ana
 */
public class Validador {

	// El método "validarCorreo" se encarga de validar que una dirección de email
	// tenga una estructura correcta. Para ello, utiliza una expresión regular para
	// verificar que el formato de la dirección de email sea válido.
	public static boolean validarCorreo(String email) {
		// Patrón para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// El email a validar
		Matcher mather = pattern.matcher(email);
		return mather.find(); // Esto remplaza un boolean OJO
	}
}
