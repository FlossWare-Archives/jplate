package org.jplate.tmplate.directive.def;

import org.jplate.util.factorycontext.FactoryContextIfc;
import org.jplate.util.factorycontext.FactoryContext;

/**
 *
 * This class satisfies the NamedDirectiveDefFactoryMgrIfc and adheres to the
 * Singleton pattern.
 *
 */
public final class NamedDirectiveDefFactoryMgr
    implements NamedDirectiveDefFactoryMgrIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class NamedDirectiveDefFactoryMgrSingleton
    {
        static final NamedDirectiveDefFactoryMgrIfc _singleton =
            new NamedDirectiveDefFactoryMgr ();
    }

    /**
     *
     * This is our default factory.
     *
     */
    private final NamedDirectiveDefFactoryIfc _defaultFactory;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private NamedDirectiveDefFactoryMgr ()
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        NamedDirectiveDefFactoryIfc defaultFactory =
            ( NamedDirectiveDefFactoryIfc )
                factoryContext.getDefaultFactory ( this );

        if ( defaultFactory == null )
        {
            defaultFactory =
                DefaultNamedDirectiveDefFactory.getSingleton ().getDefaultFactory ();
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
    public static NamedDirectiveDefFactoryMgrIfc getSingleton ()
    {
        return NamedDirectiveDefFactoryMgrSingleton._singleton;
    }

    /**
     *
     * This method will return our default address data factory.
     *
     * @return the default address data factory.
     *
     */
    public NamedDirectiveDefFactoryIfc getDefaultFactory ()
    {
        return _defaultFactory;
    }

    /**
     *
     * This method return an implementation of NamedDirectiveDefFactoryIfc.
     *
     * @param clssContext represents the class who desires a factory.
     *
     * @return an implementation of NamedDirectiveDefFactoryIfc.
     *
     *
     */
    public NamedDirectiveDefFactoryIfc getFactory ( final Class classContext )
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        NamedDirectiveDefFactoryIfc retVal = 
            ( NamedDirectiveDefFactoryIfc )
                factoryContext.getFactoryForContext ( this, classContext );

        if ( retVal == null )
        {
            retVal = getDefaultFactory ();
        }

        return retVal;
    }
}
