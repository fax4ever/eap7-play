package it.redhat.demo.gateway;

import it.redhat.demo.CiaoService;
import it.redhat.demo.CiaoWS;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 31/07/16
 */

public class CiaoGateway {

    public static final String WSDL_URL = "http://localhost:8080/eap7-ws/CiaoService?wsdl";

    private final CiaoWS port;

    public CiaoGateway() {

        URL url = null;

        try {
            url = new URL(WSDL_URL);
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
