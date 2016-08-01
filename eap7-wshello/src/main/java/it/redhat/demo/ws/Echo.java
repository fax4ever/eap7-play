package it.redhat.demo.ws;

import javax.jws.WebService;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 31/07/16
 */

@WebService
public class Echo {

    public String echo(String input) {
        return input;
    }

}
