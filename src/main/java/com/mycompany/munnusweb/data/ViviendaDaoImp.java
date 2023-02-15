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

import com.mycompany.munnusweb.domain.Vivienda;
import com.mycompany.munnusweb.util.Constantes;
import java.util.Optional;

/**
 *
 * @author ana
 */
@Stateless
public class ViviendaDaoImp implements ViviendaDao {

    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = Constantes.PU)
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Vivienda> findAllViviendas() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Vivienda.findAll").getResultList();
    }

    @Override
    public Vivienda findViviendaByID(int id_vivienda) {
        // Especificamos la clase que queremos buscar y luego el campo por el
        // que queremos buscar
        return em.find(Vivienda.class, id_vivienda);
    }

    @Override
    public Optional<Vivienda> findViviendaByPropietario(int id_propietario) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber
        Query query = em.createQuery("Vivienda.findByPropietario");
        query.setParameter("propietario", id_propietario);
        return Optional.ofNullable((Vivienda) query.getResultList());
    }

    @Override
    public Optional<Vivienda> findByDireccionVivienda(String direccionVvivienda) {
        Query query = em.createQuery("Vivienda.findByDireccionVivienda");
        query.setParameter("vivienda", direccionVvivienda);
        return Optional.ofNullable((Vivienda) query.getResultList());
    }

    @Override
    public void insertVivienda(Vivienda vivienda) {
        em.persist(vivienda);
    }

    @Override
    public void updateVivienda(Vivienda vivienda) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(vivienda);
    }

    @Override
    public void deleteVivienda(Vivienda vivienda) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(vivienda));
    }

}
