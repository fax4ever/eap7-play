package it.redhat.demo.rs;

import it.redhat.demo.CiaoWS;
import it.redhat.demo.gateway.CiaoGateway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@Path("ciao")
public class CiaoRestService {

    @Inject
    private CiaoGateway ciaoGateway;

    @GET
    @Path("{name}")
    public String ciao(@PathParam("name") String name) {

        return ciaoGateway.ciao(name);

    }

}
