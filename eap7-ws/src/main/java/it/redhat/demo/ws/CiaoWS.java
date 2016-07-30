package it.redhat.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@WebService
public class CiaoWS {

    @WebMethod
    public String ciao() {
        return "ciao";
    }


}
