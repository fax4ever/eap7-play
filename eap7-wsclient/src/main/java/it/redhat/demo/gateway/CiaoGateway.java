package it.redhat.demo.gateway;

import it.redhat.demo.CiaoService;
import it.redhat.demo.CiaoWS;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 31/07/16
 */
public class CiaoGateway {

    private CiaoWS port;

    @PostConstruct
    private void init() {
        URL url;

        try {
            url = new URL(System.getProperty("ciaoWsdlUrl"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        CiaoService service = new CiaoService(url);
        port = service.getPort(CiaoWS.class);
    }

    public String ciao(String name) {

        return port.ciao(name);

    }

}
