package it.redhat.demo.service;

import org.infinispan.Cache;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
@Stateless
@Path("{key}")
public class CacheRestService {

    @Inject
    private Cache<String, String> cache;

    @GET
    public String get(@PathParam("key") String key) {

        return cache.get(key);

    }

    @PUT
    public void put(@PathParam("key") String key, String value) {

        cache.put(key, value);

    }

}
