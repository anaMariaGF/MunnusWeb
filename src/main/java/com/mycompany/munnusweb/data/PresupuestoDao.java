/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;
import java.util.Optional;

/**
 *
 * @author ana
 */

public interface PresupuestoDao {

	public List<Presupuesto> findAllPresupuestos();

	public Optional <Presupuesto> findPresupuestoByID(PresupuestoPK presupuesto);
        
        public Optional <Presupuesto>  findPresupuestoByNombreComunidad(String nombreComunidad);

	public void insertPresupuesto(Presupuesto presupuesto);

	public void updatePresupuesto(Presupuesto presupuesto);

	public void deletePresupuesto(Presupuesto presupuesto);

}
