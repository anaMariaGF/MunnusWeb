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
		return em.createNamedQuery("Administrador.findAll").getResultList();
	}

	@Override
	public Propietario findPropietarioByID(Propietario propietario) {
		// Especificamos la clase que queremos buscar y luego el campo por el
		// que queremos buscar
		return em.find(Propietario.class, propietario.getIdPropietario());
	}

	@Override
	public Propietario findPropietarioByEmail(Propietario propietario) {
		// En este caso no vamos a usar un NamedQuery, que podríamos haber
		// agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
		Query query = em.createQuery("Propietario.findByEmail");
		query.setParameter("email", propietario.getEmail());
		return (Propietario) query.getSingleResult();
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
