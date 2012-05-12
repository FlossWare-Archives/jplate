package org.jplate.tmplate.directive.cache;

/**
 *
 * This class contains the default implementation of DirectiveCacheFactoryIfc.
 *
 */
final class DefaultDirectiveCacheFactory
    implements DefaultDirectiveCacheFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DefaultDirectiveCacheFactorySingleton
    {
        static final DefaultDirectiveCacheFactoryIfc _singleton =
            new DefaultDirectiveCacheFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultDirectiveCacheFactory () 
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    static DefaultDirectiveCacheFactoryIfc getSingleton ()
    {
        return DefaultDirectiveCacheFactorySingleton._singleton;
    }

    /**
     *
     * This method returns the default cache.
     *
     * @return the default cache.
     *
     */
    public DirectiveCacheFactoryIfc getDefaultFactory ()
    {
        return DirectiveCacheFactory.getSingleton ();
    }
}
