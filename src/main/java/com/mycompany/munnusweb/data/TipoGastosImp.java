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

import com.mycompany.munnusweb.domain.TipoGastos;
import com.mycompany.munnusweb.util.Constantes;
import java.util.Optional;

/**
 *
 * @author ana
 */
@Stateless
public class TipoGastosImp implements TipoGastosDao {
    // El EJB se encarga de forma automática de hacer las transacciones.

    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = Constantes.PU)
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<TipoGastos> findAllTipoGasto() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("TipoGastos.findAllTipoGasto").getResultList();
    }

    @Override
    public TipoGastos findByIdTipoGasto(int id) {
        // Especificamos la clase que queremos buscar y luego el campo por el
        // que queremos buscar
        return em.find(TipoGastos.class, id);
    }

    @Override
    public Optional<TipoGastos> findByDescripcion(String descripcion) {

        Query query = em.createQuery("TipoGastos.findByDescripcion");
        query.setParameter("tipoGasto", descripcion);
        return Optional.ofNullable((TipoGastos) query.getResultList());
    }

    @Override
    public void insertTipoGasto(TipoGastos tipoGasto) {

        System.out.println("com.mycompany.munnusweb.data.TipoGastosImp.insertTipoGasto()" + "se hace persiset ");
        em.persist(tipoGasto);

        System.out.println("com.mycompany.munnusweb.data.TipoGastosImp.insertTipoGasto()" + "se ha alamcendao ");

    }

    @Override
    public void updateTipoGasto(TipoGastos tipoGasto) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(tipoGasto);
    }

    @Override
    public void deleteTipoGasto(int id) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(id));
    }

}
