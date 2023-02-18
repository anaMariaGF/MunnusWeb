/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ana
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByIdPropietario", query = "SELECT p FROM Propietario p WHERE p.idPropietario = :idPropietario"),
    @NamedQuery(name = "Propietario.findByApellidos", query = "SELECT p FROM Propietario p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Propietario.findByClave", query = "SELECT p FROM Propietario p WHERE p.clave = :clave"),
    @NamedQuery(name = "Propietario.findByEmail", query = "SELECT p FROM Propietario p WHERE p.email = :email"),
    @NamedQuery(name = "Propietario.findByEstadoCuentaA", query = "SELECT p FROM Propietario p WHERE p.estadoCuentaA = :estadoCuentaA"),
    @NamedQuery(name = "Propietario.findByNombres", query = "SELECT p FROM Propietario p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Propietario.findByNumeroCuentaBancaria", query = "SELECT p FROM Propietario p WHERE p.numeroCuentaBancaria = :numeroCuentaBancaria"),
    @NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Propietario")
    private Integer idPropietario;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 255)
    @Column(name = "clave")
    private String clave;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 1)
    @Column(name = "estadoCuentaA")
    private String estadoCuentaA;
    @Size(max = 255)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 255)
    @Column(name = "numeroCuentaBancaria")
    private String numeroCuentaBancaria;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;
    @ManyToMany(mappedBy = "propietarioCollection")
    private Collection<Vivienda> viviendaCollection;
  
    public Propietario() {
    }

    public Propietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCuentaA() {
        return estadoCuentaA;
    }

    public void setEstadoCuentaA(String estadoCuentaA) {
        this.estadoCuentaA = estadoCuentaA;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Vivienda> getViviendaCollection() {
        return viviendaCollection;
    }

    public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
        this.viviendaCollection = viviendaCollection;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPropietario != null ? idPropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.idPropietario == null && other.idPropietario != null) || (this.idPropietario != null && !this.idPropietario.equals(other.idPropietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.munnusweb.domain.Propietario[ idPropietario=" + idPropietario + " ]";
    }
    
}
