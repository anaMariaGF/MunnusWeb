/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ana
 */
@Entity

@Table(name = "presupuesto_has_tipo_gastos")

public class PresupuestoTipoGastos {
    
   
    @EmbeddedId
    private PresupuestoTipoGastosPK id;
    
    
    @ManyToOne
    @JoinColumn(name=" presupuesto_id_Presupuesto",insertable=false, updatable=false)
    private Presupuesto presupuesto;
    
    @ManyToOne
    @JoinColumn(name=" tipo_gastos_id_tipo_gastos",insertable=false, updatable=false)
    private TipoGastos tipoGastos;
    
   
    
    
    
}
