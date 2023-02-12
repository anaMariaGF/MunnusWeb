/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.munnusweb.data;

import java.util.List;

import com.mycompany.munnusweb.domain.Propietario;
import java.util.Optional;

/**
 *
 * @author ana
 */
public interface PropietarioDao {

    public List<Propietario> findAllPropietario();

    public Optional<Propietario> findPropietarioByID(int id);

    public Optional<Propietario> findPropietarioByEmail(String email);

    public void insertPropietario(Propietario propietario);

    public void updatePropietario(Propietario propietario);

    public void deletePropietario(Propietario propietario);
}
