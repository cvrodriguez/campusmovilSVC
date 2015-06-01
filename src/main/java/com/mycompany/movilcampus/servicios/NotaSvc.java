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
import javax.persistence.NoResultException;
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
    @Path("/{idestudiante}/{idmateria}")
    public JsonObject verNotas(@PathParam("idmateria") int materia, @PathParam("idestudiante") int idestudiante) {

        try {
            Nota nota1 = em.createNamedQuery("Nota.findNota", Nota.class)
                    .setParameter("idestudiante", idestudiante)
                    .setParameter("idmateria", materia)
                    .getSingleResult();

            return Json.createObjectBuilder()
                    .add("idmateria", nota1.getMateria().getIdmateria())
                    .add("nombreMateria", nota1.getMateria().getNombre())
                    .add("primerp", nota1.getPrimerp())
                    .add("segundop", nota1.getSegundop())
                    .add("tercerp", nota1.getTercerp())
                    .add("notasvarias", nota1.getNotasvarias())
                    .add("notaproyecto", nota1.getNotaproyecto())
                    .add("matricula", nota1.getMatricula().getIdmatricula())
                                            .build();
        } catch (NoResultException e) {
            return Json.createObjectBuilder()
                    .add("idmateria", 0)
                    .add("nombreMateria", "No tiene notas registradas")
                    .add("primerp", 0)
                    .add("segundop", 0)
                    .add("tercerp", 0)
                    .add("notasvarias", 0)
                    .add("notaproyecto", 0)
                    .add("matricula", 0)
                                            .build();
        }

        
    }

}
