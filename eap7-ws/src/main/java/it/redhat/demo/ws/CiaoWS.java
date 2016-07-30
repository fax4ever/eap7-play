package it.redhat.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@WebService(targetNamespace = "http://ws.demo.redhat.it/")
public interface CiaoWS {

    @WebMethod
    String ciao(String name);

}
