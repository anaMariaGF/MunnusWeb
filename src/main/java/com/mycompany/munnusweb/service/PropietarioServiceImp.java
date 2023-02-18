/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mycompany.munnusweb.data.PropietarioDao;
import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.util.Encriptador;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import com.mycompany.munnusweb.util.Validador;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */

/*
El código muestra la inyección de dependencias de la clase PropietarioDao 
y el uso de la clase Encriptador para encriptar la clave del propietario.
La anotación @Stateless indica que la clase PropietarioServiceImpl 
es un bean sin estado.
*/
@Stateless
public class PropietarioServiceImp implements PropietarioService {
    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar
    // usuarioDao

    @Inject
    private PropietarioDao propietarioDao;

    // Este método se encarga de listar todos los propietarios registrados.
    @Override
    public List<Propietario> listarPropietarios() {
        return propietarioDao.findAllPropietario();
    }
    /*
    Este método se encarga de busca y devuelve el propietario con el id 
    proporcionado, y lanza una ExcepcionNegocio si no se encuentra.
    */

    @Override
    public Propietario encontrarPropietarioPorID(int id) throws ExcepcionNegocio {

        return propietarioDao.findPropietarioByID(id).orElseThrow(() -> new ExcepcionNegocio("El porpietario no se enciuentra con el id: " + id));
    }
    
    /*
    Este método se encarga de busca y devuelve el propietario con el correo 
    electrónico proporcionado, y lanza una ExcepcionNegocio si no se encuentra.
    
    */
    @Override
    public Propietario econtrarPropietarioPorEmail(String email) throws ExcepcionNegocio {
        return propietarioDao.findPropietarioByEmail(email).orElseThrow(() -> new ExcepcionNegocio("El porpietario no se enciuentra con el email: " + email));
    }
    
    /*
    Este método se encarga de registra un nuevo propietario con los datos
    proporcionados y lanza una ExcepcionNegocio si ya hay un propietario 
    registrado con el mismo correo electrónico o número de cuenta bancaria, 
    o si el correo electrónico no cumple con el formato establecido.    
    */

    @Override
    public void registrarPropietario(String apellidos, String clave, String email, String nombres, String numeroCuentaBancaria, String telefono) throws ExcepcionNegocio {

        List<Propietario> propietarios = propietarioDao.findAllPropietario();
        System.err.println("Trae propietarios  " + propietarios.size());

        boolean esCorreoValido = Validador.validarCorreo(email);

        if (!esCorreoValido) {
            throw new ExcepcionNegocio("Correo no cumple con el formato establecido");
        }

        // Verificamos que no exista un correo igual al introducido y si es igual comparamos el estado de su cuenta
        /**
         * VA VER SI EXISTE EL PROPIETARIO Y SI ES ASI CAMBIAR EL ESTADO DEL
         * PROPIETARIO
         */
        for (Propietario propietario : propietarios) {
            boolean existeElcorreo = propietario.getEmail().equals(email);
            boolean existeNumCuenta = propietario.getNumeroCuentaBancaria().equals(numeroCuentaBancaria);

            if (existeElcorreo && existeNumCuenta) {
                throw new ExcepcionNegocio("El usuario ya está registrado");
            }
            if (existeElcorreo) {
                throw new ExcepcionNegocio("Correo ya existe y está asociado con el número de cuenta bancaria " + propietario.getNumeroCuentaBancaria()
                        + " Si no es su número de cuenta, por favor contáctese con soporte.");
            }

            if (existeNumCuenta) {
                throw new ExcepcionNegocio("El número de cuenta bancaria ya está registrado con el correo " + propietario.getEmail());
            }
        }

        /**
         * va a ser un propietario nuevo
         */
        Propietario propietarioNuevo = new Propietario();
        propietarioNuevo.setNombres(nombres);
        propietarioNuevo.setApellidos(apellidos);
        propietarioNuevo.setTelefono(telefono);
        propietarioNuevo.setEmail(email);
        propietarioNuevo.setNumeroCuentaBancaria(numeroCuentaBancaria);
        //propietarioNuevo.setEstadoCuentaA(estadoCuentaA);
        try {
            // TODO: AQUI SE PUEDE ENCRIPTAR LA CONTRASEÑA
            String claveEncriptada = Encriptador.encriptadoMD5(clave);

            propietarioNuevo.setClave(claveEncriptada);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("No se guarda por que hay un problema con la excriptación de la clave");
        }
        propietarioDao.insertPropietario(propietarioNuevo);
        System.out.println("Se ha registrado el administrador con éxito ");
    }

   /*Este método se encarga de deshabilitar la cuenta del propietario con el 
    correo electrónico proporcionado.*/ 
    
    @Override
    public void propietarioDeBaja(String email) throws ExcepcionNegocio {

        Propietario propietario = propietarioDao.findPropietarioByEmail(email)
                .orElseThrow(
                        () -> new ExcepcionNegocio("No se puede dar de baja, "
                                + "ya que no se encuentra dicho email"));

        propietario.setEstadoCuentaA("N");

        propietarioDao.updatePropietario(propietario);

    }
    /*
    Este método se encarga de verificar si el correo electrónico y la clave
    proporcionados coinciden con los de algún propietario registrado y lanza 
    una ExcepcionNegocio si no se encuentran.
 
    */

    @Override
    public boolean inicarSesionPropietario(String email, String clave)
            throws ExcepcionNegocio {
        
                if(clave == null || clave.trim().isEmpty()){
            
            throw new ExcepcionNegocio("La clave no puede ser nula");
            
        }
        
        if(email == null || email.trim().isEmpty()){
            throw new ExcepcionNegocio("El email no puede ser nula");
        }
        
        try {

            String claveEncriptada = Encriptador.encriptadoMD5(clave);

            Optional<Propietario> emailPorp = propietarioDao.findPropietarioByEmail(email);

            if (emailPorp.isPresent()) {

                // extraemoe l svor , ya qabemos que no enull
                Propietario prop = emailPorp.get();

                if (prop.getClave().equals(claveEncriptada)) {

                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("Hay un problema con la  ");
        }

    }
    
    /*
    Este método se encarga de cambiar la contraseña de un propietario 
    identificado por su correo electrónico.
    */
    
    @Override
    public void cambioClavePropietario(String email, String claveVieja, 
            String claveNueva) throws ExcepcionNegocio {

        // 1. identificar a la persona
        Propietario personaEncontrada = propietarioDao.findPropietarioByEmail(email)
                .orElseThrow(() -> new ExcepcionNegocio("No se encuentra"));

        try {
            // 2. Sí está entocnes verificar antigua clave
            if (!personaEncontrada.getClave().equals(Encriptador.encriptadoMD5(claveVieja))) {
                throw new ExcepcionNegocio("Verifique su antigua contraseña");
            } else {

                // 3. si se cumple entonces actualizar clave
                personaEncontrada.setClave(Encriptador.encriptadoMD5(claveNueva));

                propietarioDao.updatePropietario(personaEncontrada);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServiceImp.class.getName()).log(Level.SEVERE, null, ex);

            throw new ExcepcionNegocio("Existe un probelma con el eencitrador a");
        }

    }
    
    /*
    Este método se encarga de deshabilitar la cuenta del propietario con 
    el correo electrónico proporcionado.
    */
    @Override
    public void modificarPropietario(Propietario propietario
    ) {
        propietarioDao.updatePropietario(propietario);
    }
    
    /*
    Este método se encarga de verificar si el correo electrónico y la clave
    proporcionados coinciden con los de algún propietario registrado y lanza 
    una ExcepcionNegocio si no se encuentran.
    */
    @Override
    public void eliminarPropietario(Propietario propietario
    ) {
        propietarioDao.deletePropietario(propietario);
    }

}
