package org.jplate.tmplate.directive.cache;

import org.jplate.util.factorycontext.FactoryContextIfc;
import org.jplate.util.factorycontext.FactoryContext;

/**
 *
 * This class satisfies the DirectiveCacheFactoryMgrIfc and adheres to the
 * Singleton pattern.
 *
 */
public final class DirectiveCacheFactoryMgr
    implements DirectiveCacheFactoryMgrIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveCacheFactoryMgrSingleton
    {
        static final DirectiveCacheFactoryMgrIfc _singleton =
            new DirectiveCacheFactoryMgr ();
    }

    /**
     *
     * This is our default factory.
     *
     */
    private final DirectiveCacheFactoryIfc _defaultFactory;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveCacheFactoryMgr ()
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveCacheFactoryIfc defaultFactory =
            ( DirectiveCacheFactoryIfc )
                factoryContext.getDefaultFactory ( this );

        if ( defaultFactory == null )
        {
            defaultFactory =
                DefaultDirectiveCacheFactory.getSingleton ().getDefaultFactory ();
        }

        _defaultFactory = defaultFactory;
    }

    /**
     *
     * This method will retunr our singleton.
     *
     * @return our singleton.
     *
     */
    public static DirectiveCacheFactoryMgrIfc getSingleton ()
    {
        return DirectiveCacheFactoryMgrSingleton._singleton;
    }

    /**
     *
     * This method will return our default address data factory.
     *
     * @return the default address data factory.
     *
     */
    public DirectiveCacheFactoryIfc getDefaultFactory ()
    {
        return _defaultFactory;
    }

    /**
     *
     * This method return an implementation of DirectiveCacheFactoryIfc.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveCacheFactoryIfc.
     *
     *
     */
    public DirectiveCacheFactoryIfc getFactory ( final Class classContext )
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveCacheFactoryIfc retVal = 
            ( DirectiveCacheFactoryIfc )
                factoryContext.getFactoryForContext ( this, classContext );

        if ( retVal == null )
        {
            retVal = getDefaultFactory ();
        }

        return retVal;
    }
}
