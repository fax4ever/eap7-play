package it.redhat.demo.rs;

import it.redhat.demo.CiaoService;
import it.redhat.demo.CiaoWS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.ws.BindingProvider;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@Path("ciao")
public class CiaoRestService {

    @GET
    @Path("{name}")
    public String ciao(@PathParam("name") String name) {

        CiaoWS port = new CiaoService().getPort(CiaoWS.class);
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, System.getProperty("ciaoWsdlUrl"));

        return port.ciao(name);

    }

}
