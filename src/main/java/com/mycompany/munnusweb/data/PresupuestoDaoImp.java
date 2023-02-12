/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;
import com.mycompany.munnusweb.util.Constantes;
import java.util.Optional;
import javax.persistence.Query;

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
	@PersistenceContext(unitName = Constantes.PU)
	EntityManager em;

	// Con este objeto de em ya podemos interactuar con nuestra BD

	@Override
	public List<Presupuesto> findAllPresupuestos() {
		// Creamos un NamedQuery, y el listado lo leemos con getResultList
		// Por lo que estamos escribiendo menos código
		return em.createNamedQuery("Presupuesto.findAllPresupuestos").getResultList();
	}

	@Override
	public Optional <Presupuesto>  findPresupuestoByID(PresupuestoPK presupuesto) {
		// Especificamos la clase que queremos buscar y luego el campo por el
		// que queremos buscar
		return Optional.ofNullable(em.find(Presupuesto.class, presupuesto.getIdPresupuesto()));
	}
        
 
    @Override
        public Optional <Presupuesto> findPresupuestoByNombreComunidad(String nombreComunidad){
            // En este caso no vamos a usar un NamedQuery, que podríamos haber
		Query query = em.createQuery("Presupuesto.findByNombreComunidad");
		query.setParameter("Comundiad: ", nombreComunidad);
		return Optional.ofNullable((Presupuesto) query.getResultList());
	}
        

	@Override
	public void insertPresupuesto(Presupuesto presupuesto) {
		em.persist(presupuesto);
	}

	@Override
	public void updatePresupuesto(Presupuesto presupuesto) {
		// Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
		em.merge(presupuesto);
	}

	@Override
	public void deletePresupuesto(Presupuesto presupuesto) {
		// 1. actualizamos el estado del objeto en la base de datos => se borra.
		em.remove(presupuesto);
	}
}
