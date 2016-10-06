package it.redhat.demo;

import it.redhat.demo.model.Ext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void server(String content, @Context HttpHeaders headers) {

        log.info("content {}", content);

        for (Map.Entry<String, List<String>> entry : headers.getRequestHeaders().entrySet()) {
            log.info("header {} :: value {}", entry.getKey(), entry.getValue());
        }

    }

    @Path("obj")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void serverWithObject(Ext content, @Context HttpHeaders headers) {

        log.info("content {}", content);

        for (Map.Entry<String, List<String>> entry : headers.getRequestHeaders().entrySet()) {
            log.info("header {} :: value {}", entry.getKey(), entry.getValue());
        }

    }

}
