package it.redhat.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fabio.ercoli@redhat.com on 13/02/17.
 */

@Path("secure")
@RolesAllowed("rest-all")
public class RestSecure {

    private static Logger log = LoggerFactory.getLogger(RestSecure.class);

    @GET
    public String ciao() {

        log.info("secure ciao invoked");

        return "secure ciao";
    }

}
