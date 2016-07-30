package it.redhat.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@WebService(serviceName = "CiaoService", portName = "Ciao", name = "Ciao", endpointInterface = "it.redhat.demo.ws.CiaoWS")
public class CiaoWSImpl implements CiaoWS {

    @WebMethod
    public String ciao(String name) {
        return "ciao " + name;
    }

}
