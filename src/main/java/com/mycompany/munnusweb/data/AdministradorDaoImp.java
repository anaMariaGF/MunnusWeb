/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mycompany.munnusweb.domain.Administrador;
import com.mycompany.munnusweb.util.Constantes;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author ana
 */
@Stateless
public class AdministradorDaoImp implements AdministradorDao {

	// El EJB se encarga de forma automática de hacer las transacciones.
	// Ahora inyectamos la unidad de persistencia a través del API de JPA
	// Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
	// unidad de persistencia
	@PersistenceContext(unitName = Constantes.PU)
	EntityManager em;

	// Con este objeto de em ya podemos interactuar con nuestra BD
	@Override
	public List<Administrador> findAllAdministrador() {
		// Creamos un NamedQuery, y el listado lo leemos con getResultList
		// Por lo que estamos escribiendo menos código
		return em.createNamedQuery("Administrador.findAll").getResultList();
	}

	@Override
	public Optional<Administrador> findAdministradorByID(int idAdmin) {
		// Especificamos la clase que queremos buscar y luego el campo por el
		// que queremos buscar

		return Optional.ofNullable(em.find(Administrador.class, idAdmin));
	}

	@Override
	public Optional<Administrador> findAdministradorByMatriculaAbogado(String matricula) {

		// En este caso no vamos a usar un NamedQuery, que podríamos haber
		// agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
		Query query = em.createQuery("Administrador.findByMatriculaAbogado");
		query.setParameter("matriculaAbogado", matricula);
		return Optional.ofNullable((Administrador) query.getSingleResult());

	}

	@Override
	public void insertAdministrador(Administrador administrador) {
		/*
		 * ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 * Validator validator = factory.getValidator();
		 * Set<ConstraintViolation<Administrador>> constraintViolations =
		 * validator.validate(administrador); if (constraintViolations.size() > 0) {
		 * Iterator<ConstraintViolation<Administrador>> iterator =
		 * constraintViolations.iterator(); while (iterator.hasNext()) {
		 * ConstraintViolation<Administrador> cv = iterator.next();
		 * System.err.println(cv.getRootBeanClass().getName() + "." +
		 * cv.getPropertyPath() + " " + cv.getMessage());
		 * 
		 * } } else { em.persist(administrador); }
		 */

		try {
			em.persist(administrador);

		} catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(t -> System.err.println(t));
		}
	}

	@Override
	public void updateAdministrador(Administrador administrador) {
		// Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
		em.merge(administrador);
	}

	@Override
	public void deleteAdministrador(Administrador administrador) {
		// 1. actualizamos el estado del objeto en la base de datos => se borra.
		em.remove(em.merge(administrador));
	}

}
