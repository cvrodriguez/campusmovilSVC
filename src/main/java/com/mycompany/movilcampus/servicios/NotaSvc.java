/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movilcampus.servicios;

import com.mycompany.movilcampus.model.Nota;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author cvrodriguez
 */
@Path("nota")
@Stateless
public class NotaSvc {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{idmateria}/{idmatricula}")
    public JsonObject verNotas(@PathParam("idmateria") int idmateria, @PathParam("idmatricula") int idmatricula) {

        Nota nota1 = em.createNamedQuery("Nota.findNota", Nota.class)
                .setParameter("idmatricula", idmatricula)
                .setParameter("idmateria", idmateria)
                .getSingleResult();

        return Json.createObjectBuilder()
                .add("idmateria", nota1.getMateria().getIdmateria())
                .add("primerp", nota1.getPrimerp())
                .add("segundop", nota1.getSegundop())
                .add("tercerp", nota1.getTercerp())
                .add("notasvarias", nota1.getNotasvarias())
                .add("notaproyecto", nota1.getNotaproyecto())
                                        .build();

        
    }

}
