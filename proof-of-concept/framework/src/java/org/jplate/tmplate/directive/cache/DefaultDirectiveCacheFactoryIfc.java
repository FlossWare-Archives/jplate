package org.jplate.tmplate.directive.cache;

/**
 *
 * This interface defines the API for determining the default directive cache
 * factory.
 *
 */
interface DefaultDirectiveCacheFactoryIfc
{
    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveCacheFactoryIfc getDefaultFactory ();
}
