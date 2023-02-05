/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.service;

import com.mycompany.munnusweb.data.AdministradorDao;
import com.mycompany.munnusweb.domain.Administrador;
import com.mycompany.munnusweb.util.Encriptador;
import com.mycompany.munnusweb.util.ExcepcionNegocio;
import com.mycompany.munnusweb.util.Validador;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ana
 */

/*este código define una clase de servicio llamada AdministradorServiceImp 
que implementa la interfaz AdministradorService, esta clase es anotada con 
@Stateless lo cual significa que esta clase proveerá servicios sin estado. 
Esto quiere decir que los datos o estado no se guardarán entra las llamadas 
a los métodos de esta clase.*/
@Stateless
public class AdministradorServiceImp implements AdministradorService {

    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
    /*Esta linea de código es parte de una clase y está usando la anotación @Inject.
   Esto indica que se está inyectando una dependencia de la clase AdministradorDao,
   para que se pueda usar en la clase actual.*/
    @Inject
    private AdministradorDao administradorDao;

    // Ahora nos apoyamos de la interfaz para completar los servicios
    @Override
    public List<Administrador> listarAdministradores() {
        return administradorDao.findAllAdministrador();
    }

    @Override
    public Optional<Administrador> encontrarAdministradorPorID(int id) {
        return administradorDao.findAdministradorByID(id);
    }

    @Override
    public Optional<Administrador> encontrarAdministradorPorMatriculaAbogado(String matricula) {
        return administradorDao.findAdministradorByMatriculaAbogado(matricula);
    }

    @Override
    public void registrarAdministrador(Administrador administrador) {
        administradorDao.insertAdministrador(administrador);
    }

    @Override
    public void modificarUsuario(Administrador administrador) {
        administradorDao.updateAdministrador(administrador);
    }

    @Override
    public void eliminarUsuario(Administrador administrador) {
        administradorDao.deleteAdministrador(administrador);
    }


    /*El método "registrarAdministrador" se encarga de registrar un nuevo
    administrador en el sistema. Para ello, solicita al usuario los datos 
    necesarios para el administrador, como el email, su nombre, apellidos, 
    NIF, número de matrícula de abogado, teléfono y contraseña. Luego, 
    verifica que el email y el número de matrícula de abogado no se encuentren 
    en uso, para evitar duplicidades. Finalmente, guarda los datos del 
    administrador en la base de datos.*/
    public void registrarAdministrador(String nif,
            String matriculaAbogado, String nombres, String apellidos,
            String telefono, String email, String clave) throws ExcepcionNegocio {

        List<Administrador> administradores = administradorDao.findAllAdministrador();

        boolean esCorreoValido = Validador.validarCorreo(email);

        if (!esCorreoValido) {
            throw new ExcepcionNegocio("Correo no cumple conel formato establecido  ");

        }

        // Verificamos que no exista un correo igual al introducido y si es igual
        // comparamos el estado de su cuenta
        /**
         * VA VER SI EXIWT EL ADMIN Y SI ES ASI CMBIAR EL ESTADO DEL ADMI
         */
        for (Administrador admin : administradores) {

            boolean existeElcoreo = admin.getEmail().equals(email);

            boolean existeLaMatricula = admin.getMatriculaAbogado().equals(matriculaAbogado);

            if (existeElcoreo && existeLaMatricula) {
                throw new ExcepcionNegocio("e}l usaurio ya eta registrado   e");
            }
            if (existeElcoreo) {
                //TODO: BUSCAR TECNICA PAOFUSCAR LNIF 
                throw new ExcepcionNegocio("Correo ya existe y esta signado al nif  " + admin.getMatriculaAbogado() + " si no es us nifo constactese con soporte ");
            }

            if (existeLaMatricula) {
                //TODO: BUSCAR TECNICA PAOFUSCAR L ECOOREO 
                throw new ExcepcionNegocio(" La matricticulado ya registado con el correo " + admin.getEmail());

            }

        }

        /**
         * va ha ser un admin nuevo
         */
        Administrador adminNuevo = new Administrador();
        adminNuevo.setNif(nif);
        adminNuevo.setMatriculaAbogado(matriculaAbogado);
        adminNuevo.setMatriculaAbogado(nombres);
        adminNuevo.setApellidos(apellidos);
        adminNuevo.setTelefono(telefono);
        adminNuevo.setEmail(email);
        try {
            //TODO: AQUI SE PUEDE ENCRITAR LA CONTASEÑA
            adminNuevo.setClave(Encriptador.encriptadoMD5(clave));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionNegocio("No se eguarda por que hay un problema conla excrptaciond de la clave ");
        }

        administradorDao.insertAdministrador(adminNuevo);

    }


    /* El metodo administradorDeBaja() imprime los administradores con la 
    cuenta desactivada usando una instancia de la clase Administrador_Dao.
    Además, utiliza un ArrayList para recorrer los administradores y verificar 
    su estado de cuenta.
    
     */
    public void administradorDeBaja(String matriculaAbogado) throws ExcepcionNegocio {

        Administrador administrador = administradorDao.findAdministradorByMatriculaAbogado(matriculaAbogado).orElseThrow(() -> new ExcepcionNegocio("Nos epuee dar de baja , ya que no dese encuntra la matricula"));

        administrador.setEstadoCuentaA("N");

        administradorDao.updateAdministrador(administrador);

    }

    /*El método "validarAdministrador" se encarga de permitir que un 
    administrador inicie sesión en el sistema. Para ello, solicita al usuario su
    número de matrícula de abogado y su contraseña. Luego, verifica que los datos
    ingresados se encuentren en la base de datos y que la cuenta no se encuentre 
    desactivada. Finalmente, devuelve un objeto de tipo Administrador para ser
    utilizado en el inicio de sesión.
    
     */
    public boolean inicarSesionAdministrador(String matricula, String clave) throws ExcepcionNegocio {

        try {

            String claveEncriptada = Encriptador.encriptadoMD5(clave);

            Optional<Administrador> adminMatricula = administradorDao.findAdministradorByMatriculaAbogado(matricula);

            if (adminMatricula.isPresent()) {

                // extraemoe l svor , ya qabemos que no enull 
                Administrador admin = adminMatricula.get();

                if (admin.getClave().equals(claveEncriptada)) {

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

    /*El método "cambioClaveAdministrador" se encarga de permitir que un
    administrador cambie su contraseña. Para ello, recibe como parámetro un 
    objeto de tipo Administrador, solicita al usuario una nueva contraseña y la
    encripta. Luego, guarda la nueva contraseña encriptada en la base de datos.
   
     */
    public void cambioClaveAdministrador(String matricula, String claveVieja, String claveNueva) throws ExcepcionNegocio, NoSuchAlgorithmException {

        // 1. identificar a la persona
        Administrador personaEncontrada = administradorDao.findAdministradorByMatriculaAbogado(matricula).orElseThrow(() -> new ExcepcionNegocio("No se encuentra"));

        // 2. Sí está entocnes verificar antigua clave
        if (!personaEncontrada.getClave().equals(Encriptador.encriptadoMD5(claveVieja))) {
            throw new ExcepcionNegocio("Verifique su antigua contraseña");
        } else {

            // 3. si se cumple entonces actualizar clave
            personaEncontrada.setClave(Encriptador.encriptadoMD5(claveNueva));
            administradorDao.updateAdministrador(personaEncontrada);
        }

    }

}
