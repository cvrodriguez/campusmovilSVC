/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movilcampus.servicios;

import com.mycompany.movilcampus.model.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author cvrodriguez
 */
@Path("materiaXSemestre")
@Stateless

public class MateriaXSemesSvc {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{idsemestre}")

    public JsonArray verMateriaXSeme(@PathParam("idsemestre") int idsemestre) {

        List<Materia> materias = em.createNamedQuery("Materia.findBySemestre", Materia.class)
                .setParameter("idsemestre", idsemestre)
                .getResultList();

        JsonArrayBuilder builderMareriasJson = Json.createArrayBuilder();
        
        for (Materia materia : materias) {
            JsonObjectBuilder builderObjMateriaJson = Json.createObjectBuilder()
                    .add("nombre", materia.getNombre())
                    .add("idsemestre", materia.getIdsemestre())
                    .add("idmateria", materia.getIdmateria());
            
            builderMareriasJson.add(builderObjMateriaJson);
        }
        
        return builderMareriasJson.build();
    }

}
