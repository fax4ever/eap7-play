package it.redhat.demo.producer;

import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
@Singleton
@Startup
public class CacheContainerProducer {

    @Inject
    private Logger log;

    private CacheContainer cacheManager;

    @PostConstruct
    private void start() {
        log.trace("starting library mode container");
        cacheManager = new DefaultCacheManager(true);
    }

    @PreDestroy
    private void end() {
        log.trace("stopping library mode container");
        cacheManager.stop();
    }

    @Produces
    public CacheContainer getCacheManager() {
        return cacheManager;
    }

}
