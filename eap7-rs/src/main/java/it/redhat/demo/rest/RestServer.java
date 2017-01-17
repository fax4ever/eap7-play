package it.redhat.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fabio.ercoli@redhat.com on 14/01/17.
 */
@Path("")
public class RestServer {

    private static Logger log = LoggerFactory.getLogger(RestServer.class);

    @GET
    public String ciao() {
        return "ciao";
    }

    @GET
    @Path("debug")
    public String debug() {

        log.debug("invoke debug");
        return "debug";

    }

    @GET
    @Path("info")
    public String info() {

        log.info("invoke info");
        return "info";

    }

    @GET
    @Path("warn")
    public String warn() {

        log.warn("invoke warn");
        return "warn";

    }

    @GET
    @Path("error")
    public String error() {

        log.error("invoke error");
        return "error";

    }

}
