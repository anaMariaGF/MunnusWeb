/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author ana
 */
@Stateless
public class PresupuestoDaoImp implements PresupuestoDao {
     
    // El EJB se encarga de forma automática de hacer las transacciones.
    
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName="munnusPU")
    EntityManager em;
    
    // Con este objeto de em ya podemos interactuar con nuestra BD
    

    @Override
    public List<Presupuesto> findAllPresupuestos() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Presupuesto.findAllPresupuestos").getResultList();
    }

    @Override
    public Presupuesto findPresupuestoByID(PresupuestoPK presupuesto) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Presupuesto.class, presupuesto.getIdPresupuesto());
    }


    @Override
    public void insertPresupuesto(Presupuesto presupuesto) {
        em.persist(presupuesto);
    }

    @Override
    public void updatePresupuesto(Presupuesto presupuesto){
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(presupuesto);
    }
    
    @Override
    public void deletePresupuesto(Presupuesto presupuesto) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(presupuesto));
    }
}
