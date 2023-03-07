package com.mycompany.munnusweb.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class PresupuestoHasTipoGastosPK {

    @Column(name = "ID_TIPO_GASTOS")
    private Integer idTipoGasto;


    @Column(name = "id_Presupuesto")
    private int idPresupuesto;


    @Column(name = "id_Administrador")
    private int idAdministrador;


    public Integer getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresupuestoHasTipoGastosPK that = (PresupuestoHasTipoGastosPK) o;
        return idPresupuesto == that.idPresupuesto && idAdministrador == that.idAdministrador && Objects.equals(getIdTipoGasto(), that.getIdTipoGasto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTipoGasto(), idPresupuesto, idAdministrador);
    }
}
