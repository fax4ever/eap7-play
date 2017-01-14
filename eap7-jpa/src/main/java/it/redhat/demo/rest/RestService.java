package it.redhat.demo.rest;

import it.redhat.demo.entity.MoveEntity;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by fabio.ercoli@redhat.com on 14/01/17.
 */
@Path("")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestService {

    @Inject
    private EntityManager em;

    @Inject
    private Logger log;

    @GET
    public String ciao() {
        return "ciao";
    }

    @POST
    @Path("from/{from}/to/{to}")
    public void insertMove(@PathParam("from") String from, @PathParam("to") String to) {

        MoveEntity moveEntity = new MoveEntity();
        moveEntity.setFromLocation(from);
        moveEntity.setToLocation(to);
        moveEntity.setMoment(new Date());

        em.persist(moveEntity);
        log.info("new movement {}", moveEntity);

    }


}
