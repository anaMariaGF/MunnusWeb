/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.munnusweb.domain.Factura;
import com.mycompany.munnusweb.util.Constantes;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.persistence.Query;

/**
 *
 * @author ana
 */
@Stateless
public class FacturaDaoImp implements FacturaDao {
    // El EJB se encarga de forma automática de hacer las transacciones.

    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = Constantes.PU)
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Factura> findAllFacturas() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Factura.findAll").getResultList();
    }

    @Override
    public Factura findFacturaByID(int id) {
        // Especificamos la clase que queremos buscar y luego el campo por el
        // que queremos buscar
        return em.find(Factura.class, id);
    }

    @Override
    public void insertFactura(Factura factura) {
        em.persist(factura);
    }

    @Override
    public void updateFactura(Factura factura) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(factura);
    }

    @Override
    public void deleteFactura(Factura factura) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(factura));
    }

    @Override
    public Optional<Factura> findFacturaByFechaEmision(LocalDateTime fechaEmision) {
        Query query = em.createQuery("Factura.findByFechaEmision");
        query.setParameter("factura", fechaEmision);
        return Optional.ofNullable((Factura) query.getResultList());
    }

    @Override
    public Optional<Factura> findFacturaByPeriodo(String periodo) {
        Query query = em.createQuery("Factura.findByPeriodo");
        query.setParameter("factura", periodo);
        return Optional.ofNullable((Factura) query.getResultList());
    }

    @Override
    public Optional<Factura> findFacturaByEstadoF(String estatadoF) {
        Query query = em.createQuery("Factura.findByPeriodo");
        query.setParameter("factura", estatadoF);
        return Optional.ofNullable((Factura) query.getResultList());
    }

    @Override
    public Optional<Factura> findFacturaByValor(Double valor) {
        Query query = em.createQuery("Factura.findByValor");
        query.setParameter("factura", valor);
        return Optional.ofNullable((Factura) query.getResultList());
    }

}
