/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.movilcampus.servicios;

import com.mycompany.movilcampus.model.Materia;
import com.mycompany.movilcampus.model.Matricula;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
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
@Path("matricula")
@Stateless
public class MatriculaSvc {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Path("/{idestudiante}")
    public JsonObject verMatricula( @PathParam("idestudiante") int idestudiante ) {
       
        Matricula matricula = em.createNamedQuery("Matricula.findByIdestudiante", Matricula.class)
                .setParameter("idestudiante", idestudiante)
                .getSingleResult();
                
        
        return Json.createObjectBuilder()
              .add("idMatricula",matricula.getIdmatricula())
                .add("idestudiante", idestudiante)
                .add("idsemestre", 0)
                .add("estado", matricula.getEstado())
                .add("ano", matricula.getAno())
                .add("periodo", matricula.getPeriodo())
                .build();
    }
    
}
