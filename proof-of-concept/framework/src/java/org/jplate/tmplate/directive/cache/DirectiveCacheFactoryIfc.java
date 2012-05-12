package org.jplate.tmplate.directive.cache;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveDefIfc;

/**
 *
 * This interface defines the API to create/define directives.
 *
 */
public interface DirectiveCacheFactoryIfc
{
    /**
     *
     * This method will create a directive cache.
     *
     * @return a directive cache.
     *
     */
    public DirectiveCacheIfc createDirectiveCache ();

    /**
     *
     * This method will create a directive cache populated with namedDirectives.
     *
     * @param namedDirectives represents an array of named directives to be
     *        used to populate the return value.
     *
     * @return a directive cache.
     *
     */
    public DirectiveCacheIfc createDirectiveCache
        ( NamedDirectiveDefIfc namedDirectives[] );
}
