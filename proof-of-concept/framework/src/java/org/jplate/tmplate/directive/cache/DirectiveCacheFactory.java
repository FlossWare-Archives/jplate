package org.jplate.tmplate.directive.cache;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveDefIfc;

/**
 *
 * This class satisfies the DirectiveCacheFactoryIfc interface.  It also adheres
 * to the Singleton pattern.
 *
 */
final class DirectiveCacheFactory implements DirectiveCacheFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveCacheFactorySingleton
    {
        static final DirectiveCacheFactoryIfc _singleton =
            new DirectiveCacheFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveCacheFactory ()
    {
    }

    /**
     *
     * This method returns our singleton.
     *
     * @return the singleton.
     *
     */
    static DirectiveCacheFactoryIfc getSingleton ()
    {
        return DirectiveCacheFactorySingleton._singleton;
    }

    /**
     *
     * This method will create a directive cache.
     *
     * @return a directive cache.
     *
     */
    public DirectiveCacheIfc createDirectiveCache ()
    {
        return new DirectiveCache ();
    }

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
        ( final NamedDirectiveDefIfc namedDirectives[] )
    {
        return new DirectiveCache ( namedDirectives );
    }
}
