/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ana
 */
public class Encriptador {

	// 1= 1 2 = 2 3 =3 4 = 4 5= 0 6 = 1 7 8 9 10 % 5 puede pasar que dos usuarios
	// tenga el mismo hash
	/*
	 * El método "comparadorMD5" se encarga de comparar la contraseña ingresada por
	 * el usuario con la contraseña encriptada almacenada en la base de datos.
	 */
	public static boolean comparadorMD5(String claveEntrada, String claveEncriptada) {
		return claveEntrada.equalsIgnoreCase(claveEncriptada);
	}

	// Metodo de encriptacion de contraseñas formato MD5
	public static String encriptadoMD5(String clave) throws NoSuchAlgorithmException {
		String md5 = null;
		if (null == clave) {
			return null;
		}

		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(clave.getBytes(), 0, clave.length());
		md5 = new BigInteger(1, digest.digest()).toString(16);

		return md5;
	}

}
