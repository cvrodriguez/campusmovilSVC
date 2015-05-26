/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movilcampus.servicios;

import com.mycompany.movilcampus.model.Estudiante;
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
@Path("login")
@Stateless

public class LoginSvc {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{identificacion}/{clave}")
    public JsonObject login(@PathParam("identificacion") String identificacion, @PathParam("clave") String clave) {

        try {
            Estudiante estudiante = em.createNamedQuery("Estudiante.findByIdentificacion", Estudiante.class)
                    .setParameter("identificacion", identificacion)
                    .setParameter("clave", clave)
                    .getSingleResult();

            return Json.createObjectBuilder()
                    .add("identificacion", estudiante.getIdentificacion())
                    .add("ingresar", true)
                    .add("mensaje","Bienvenido")
                    .build();
        } catch (NoResultException e) {
            return Json.createObjectBuilder()
                    .add("ingresar", false)
                    .add("mensaje","Error de usuario o contraseña")
                    .build();
            
        }

    }

}
