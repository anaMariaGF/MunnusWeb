/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import com.mycompany.munnusweb.domain.Presupuesto;
import com.mycompany.munnusweb.domain.PresupuestoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ana
 */
@Local
public interface PresupuestoDao {
    
    public List<Presupuesto> findAllPresupuestos() ;
    
    public Presupuesto findPresupuestoByID(PresupuestoPK presupuesto);
    
    public void insertPresupuesto(Presupuesto presupuesto);
   
    public void updatePresupuesto(Presupuesto presupuesto);
    
    public void deletePresupuesto(Presupuesto presupuesto);  

}
