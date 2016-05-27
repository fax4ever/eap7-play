package it.redhat.demo.producer;

import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
public class CacheContainerProducer {

    private CacheContainer cacheManager;

    @Produces
    @ApplicationScoped
    @HelloCache
    public CacheContainer getCacheManager() {

        if (cacheManager == null) {
            cacheManager = new DefaultCacheManager();
        }

        return cacheManager;

    }

}
