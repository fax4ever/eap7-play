package it.redhat.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by fabio on 06/10/16.
 */

@Path("")
public class RestService {

    private static Logger log = LoggerFactory.getLogger(RestService.class);

    @GET
    public String ciao() {
        return "ciao";
    }

    @Consumes(MediaType.APPLICATION_JSON)
    public void server(String content, @Context HttpHeaders headers) {

        log.info("conentet {}", content);
        log.info("headers {}", headers);

    }

}
