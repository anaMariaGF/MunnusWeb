/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author DAHM1
 */
@Embeddable
class ViendaPropietarioPK  implements  Serializable{
    
    
   //indica que la clase viviendaPropietario está relacionada con la clase Propietario y Vivienda.
   @Column(name = "propietario_id_Propietario")

    private Integer idPropietario;

   @Column(name = "vivienda_id_Vivienda")
    private Integer idVivienda;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.idPropietario);
        hash = 19 * hash + Objects.hashCode(this.idVivienda);
        return hash;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }
    
    
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ViendaPropietarioPK other = (ViendaPropietarioPK) obj;
        if (!Objects.equals(this.idPropietario, other.idPropietario)) {
            return false;
        }
        return Objects.equals(this.idVivienda, other.idVivienda);
    }
   
   
   
    
}
