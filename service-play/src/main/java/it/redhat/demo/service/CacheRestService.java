package it.redhat.demo.service;

import it.redhat.demo.producer.HelloCache;
import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
@Stateless
@Path("{key}")
public class CacheRestService {

    @Inject
    @HelloCache
    private CacheContainer cacheContainer;

    @GET
    public String get(@PathParam("key") String key) {

        Cache<String, String> cache = cacheContainer.getCache("hello");
        return cache.get(key);

    }

    @PUT
    public void put(@PathParam("key") String key, String value) {

        Cache<String, String> cache = cacheContainer.getCache("hello");
        cache.put(key, value);

    }

}
