package it.redhat.demo.service;

import it.redhat.demo.Echo;

import javax.jws.WebService;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 01/08/16
 */
@WebService(endpointInterface = "it.redhat.demo.Echo")
public class EchoImpl implements Echo {

    @Override
    public String echo(String arg0) {
        return arg0;
    }

}
