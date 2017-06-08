package it.redhat.demo.start;

/**
 * Created by fabio.ercoli@redhat.com on 08/06/2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Singleton
@Startup
public class OnStartSignleton {

    private static final Logger LOG = LoggerFactory.getLogger(OnStartSignleton.class);

    @PostConstruct
    public void go() {
        LOG.info("go");

        Response response = null;

        try {

            response = getClient()
                    .target("https://host:8080/kie-server/services/rest/server/queries/tasks/instances/pot-owners")
                    .request()
                    .get();

            int status = response.getStatus();
            if (status < 200 || status >= 300) {
                throw new RuntimeException(response.readEntity(String.class));
            }

            LOG.info("response: {}", response.readEntity(String.class));

        } finally {
            response.close();
        }

    }

    private Client getClient() {

        SSLContext sslContext = null;

        SecureRestClientTrustManager secureRestClientTrustManager = new SecureRestClientTrustManager();

        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new javax.net.ssl.TrustManager[] { secureRestClientTrustManager }, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }


        return ClientBuilder.newBuilder()
                .property("connection.timeout", 100)
                .sslContext(sslContext)
                .register(new Authenticator("username","password"))
                .build();
    }



}
