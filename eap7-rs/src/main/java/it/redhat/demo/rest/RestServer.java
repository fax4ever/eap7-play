package it.redhat.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fabio.ercoli@redhat.com on 14/01/17.
 */
@Path("")
public class RestServer {

    @GET
    public String ciao() {
        return "ciao";
    }

}
