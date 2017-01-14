package it.redhat.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fabio.ercoli@redhat.com on 14/01/17.
 */
@Path("")
public class RestService {

    @GET
    public String ciao() {
        return "ciao";
    }

}
