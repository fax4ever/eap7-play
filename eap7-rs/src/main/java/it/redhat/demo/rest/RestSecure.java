package it.redhat.demo.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fabio.ercoli@redhat.com on 13/02/17.
 */

@Path("secure")
@RolesAllowed("rest-all")
public class RestSecure {

    @GET
    public String ciao() {
        return "secure ciao";
    }

}
