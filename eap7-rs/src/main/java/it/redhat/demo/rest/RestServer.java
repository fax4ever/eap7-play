package it.redhat.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
    public String debug(@QueryParam("times") int times) {

        if (times == 0) {
            times = 1;
        }

        for (int i = 0; i < times; i++) {
            log.debug("invoke debug");
        }
        return "debug";

    }

    @GET
    @Path("info")
    public String info(@QueryParam("times") int times) {

        if (times == 0) {
            times = 1;
        }

        for (int i = 0; i < times; i++) {
            log.info("invoke info");
        }
        return "info";

    }

    @GET
    @Path("warn")
    public String warn(@QueryParam("times") int times) {

        if (times == 0) {
            times = 1;
        }

        for (int i = 0; i < times; i++) {
            log.warn("invoke warn");
        }
        return "warn";

    }

    @GET
    @Path("error")
    public String error(@QueryParam("times") int times) {

        if (times == 0) {
            times = 1;
        }

        for (int i = 0; i < times; i++) {
            log.error("invoke error");
        }
        return "error";

    }

}
