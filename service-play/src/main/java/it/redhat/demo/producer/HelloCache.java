package it.redhat.demo.producer;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, PARAMETER, METHOD})
public @interface HelloCache {
}
