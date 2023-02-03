/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.munnusweb;

import com.mycompany.munnusweb.domain.Administrador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ana
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> {

    @PersistenceContext(unitName = "munnusPU")
    private EntityManager em;

    //@Override
    protected EntityManager getEntityManager() {
        return em;
    }
/*
    public AdministradorFacade() {
        super(Administrador.class);
    }
    */
   // @Override
    public Administrador iniciarSesion(Administrador a) {
        Administrador admin = null; 
        
        try{
            //consulta = "FROM Administrador a WHERE a.MatriculaAbogado =?1 and a.clave=?2";
            Query query = em.createNamedQuery("Administrador.findByClaveMatriculaAbogado");
            query.setParameter("matriculaAbogado", a.getMatriculaAbogado());
            query.setParameter("password", a.getClave());
            List<Administrador> lista = query.getResultList();//obtego la lista de la consulta
            if(!lista.isEmpty())
                admin = lista.get(0);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return admin;
    }
    
}
