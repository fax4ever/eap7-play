package it.redhat.demo.producer;

import it.redhat.demo.model.Cart;
import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 31/05/16
 */
public class CacheProducer {

    private final static String STRING_CACHE = "stringCache";
    private final static String CART_CACHE = "cartCache";

    @Inject
    private CacheContainer cacheContainer;

    @Produces
    public Cache<String, String> getStringCache() {

        return cacheContainer.getCache(STRING_CACHE);

    }

    @Produces
    public Cache<String, Cart> getCartCache() {

        return cacheContainer.getCache(CART_CACHE);

    }

}
