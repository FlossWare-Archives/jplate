package org.jplate.util.environment;

import org.jplate.util.factorycontext.FactoryContextIfc;
import org.jplate.util.factorycontext.FactoryContext;

/**
 *
 * This class satisfies the EnvironmentFactoryMgrIfc and adheres to the
 * Singleton pattern.  Use this class to get an environment factory.  The
 * environment factory is used to create environments.
 *
 * <p>
 * To get an environment factory, perform the following:
 *
 * <pre>
 * final EnvironmentFactoryMgrIfc envFactoryMgr =
 *     EnvironmentFactoryMgr.getSingleton ();
 *
 * final EnvironmentFactoryIfc envFactory = envFactoryMgr.getFactory ( this );
 * </pre>
 *
 * To understand the parameter passed to the <code>getFactory()</code> method,
 * please refer to <code>org.jplate.util.factorycontext.FactoryContextIfc
 * </code>.
 *
 * @see org.jplate.util.factorycontext.FactoryContextIfc
 *
 */
public final class EnvironmentFactoryMgr
    implements EnvironmentFactoryMgrIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class EnvironmentFactoryMgrSingleton
    {
        static final EnvironmentFactoryMgrIfc _singleton =
            new EnvironmentFactoryMgr ();
    }

    /**
     *
     * This is our default factory.
     *
     */
    private final EnvironmentFactoryIfc _defaultFactory;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private EnvironmentFactoryMgr ()
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        EnvironmentFactoryIfc defaultFactory =
            ( EnvironmentFactoryIfc )
                factoryContext.getDefaultFactory ( this );

        if ( defaultFactory == null )
        {
            defaultFactory =
                DefaultEnvironmentFactory.getSingleton ().getDefaultFactory ();
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
    public static EnvironmentFactoryMgrIfc getSingleton ()
    {
        return EnvironmentFactoryMgrSingleton._singleton;
    }

    /**
     *
     * This method will return our default address data factory.
     *
     * @return the default address data factory.
     *
     */
    public EnvironmentFactoryIfc getDefaultFactory ()
    {
        return _defaultFactory;
    }

    /**
     *
     * This method return an implementation of EnvironmentFactoryIfc.
     *
     * @param classContext represents the class that desires a factory.
     *
     * @return an implementation of EnvironmentFactoryIfc.
     *
     *
     */
    public EnvironmentFactoryIfc getFactory ( final Class classContext )
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        EnvironmentFactoryIfc retVal = 
            ( EnvironmentFactoryIfc )
                factoryContext.getFactoryForContext ( this, classContext );

        if ( retVal == null )
        {
            retVal = getDefaultFactory ();
        }

        return retVal;
    }
}
