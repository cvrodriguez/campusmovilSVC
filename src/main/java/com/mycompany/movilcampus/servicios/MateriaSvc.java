package com.mycompany.movilcampus.servicios;

import com.mycompany.movilcampus.model.Materia;
import com.mycompany.movilcampus.model.Nota;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
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
@Path("materia")
@Stateless
public class MateriaSvc {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{idestudiante}")
    public JsonArray listarMaterias(@PathParam("idestudiante") Long idMatricula) {
        List<Materia> materias = em.createNamedQuery("Materia.findByIdestudiante", Materia.class)
                .setParameter("idestudiante", idMatricula)
                .getResultList();

        JsonArrayBuilder retorno = Json.createArrayBuilder();

        for (Materia materia : materias) {
            retorno.add(materiaToJson(materia));
        }

        return retorno.build();
    }

    public JsonObjectBuilder materiaToJson(Materia materia) {
        Nota nota = materia.getNotaList().get(0);

        Double definitiva = (nota.getPrimerp()
                + nota.getNotaproyecto()
                + nota.getNotasvarias()
                + nota.getSegundop()
                + nota.getTercerp()) / 5;

        return Json.createObjectBuilder()
                .add("idmateria", materia.getIdmateria())
                .add("nombre", materia.getNombre())
                .add("nota", definitiva);
    }
}
