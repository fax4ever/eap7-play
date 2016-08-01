package it.redhat.demo.rs;

import it.redhat.demo.CiaoService;
import it.redhat.demo.CiaoWS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@Path("ciao")
public class CiaoRestService {

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ciao(@PathParam("name") String name) {

        CiaoWS port = new CiaoService().getPort(CiaoWS.class);
        return port.ciao(name);

    }

}
