/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mycompany.munnusweb.domain.Propietario;
import com.mycompany.munnusweb.util.Constantes;
import java.util.Optional;
import javax.persistence.NoResultException;

/**
 *
 * @author ana
 */
@Stateless
public class PropietarioDaoImp implements PropietarioDao {

    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = Constantes.PU)
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Propietario> findAllPropietario() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Propietario.findAll").getResultList();
    }

    @Override
    public Optional<Propietario> findPropietarioByID(int id) {
        // Especificamos la clase que queremos buscar y luego el campo por el
        // que queremos buscar
        return Optional.ofNullable(em.find(Propietario.class, id));
    }

    @Override
    public Optional<Propietario> findPropietarioByEmail(String email) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.+
     
        
        Query query = em.createNativeQuery("SELECT * FROM propietario WHERE email = ?1",Propietario.class);

        Propietario res = null;
        query.setParameter(1, email);
        try {
            res= (Propietario) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No se encuntra el correo "+ email);
        }

        return Optional.ofNullable(res);
    }

    @Override
    public void insertPropietario(Propietario propietario) {
        em.persist(propietario);
    }

    @Override
    public void updatePropietario(Propietario propietario) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(propietario);
    }

    @Override
    public void deletePropietario(Propietario propietario) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(propietario));
    }
}
