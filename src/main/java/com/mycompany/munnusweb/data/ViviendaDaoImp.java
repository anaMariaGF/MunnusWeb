/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Vivienda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ana
 */
@Stateless
public class ViviendaDaoImp implements ViviendaDao{
     
    // El EJB se encarga de forma automática de hacer las transacciones.
    
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName="munnusPU")
    EntityManager em;
    
    // Con este objeto de em ya podemos interactuar con nuestra BD
    

    @Override
    public List<Vivienda> findAllViviendas() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Vivienda.findAll").getResultList();
    }

    @Override
    public Vivienda findViviendaByID(Vivienda vivienda) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Vivienda.class, vivienda.getIdVivienda());
    }

    @Override
    public Vivienda findViviendaByPropietario(Vivienda vivienda) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createQuery("Vivienda.findByPropietario");
        query.setParameter("propietarios",vivienda.getPropietarioCollection());
        return (Vivienda) query.getResultList();                
    }

    @Override
    public void insertVivienda(Vivienda vivienda) {
        em.persist(vivienda);
    }

    @Override
    public void updateVivienda(Vivienda vivienda){
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(vivienda);
    }
    
    @Override
    public void deleteUsuario(Vivienda vivienda) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(vivienda));
    }
    
}
