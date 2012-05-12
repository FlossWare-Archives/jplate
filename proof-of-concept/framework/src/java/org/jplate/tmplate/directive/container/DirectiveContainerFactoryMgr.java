package org.jplate.tmplate.directive.container;

import org.jplate.util.factorycontext.FactoryContextIfc;
import org.jplate.util.factorycontext.FactoryContext;

/**
 *
 * This class satisfies the DirectiveContainerFactoryMgrIfc and adheres to the
 * Singleton pattern.
 *
 */
public final class DirectiveContainerFactoryMgr
    implements DirectiveContainerFactoryMgrIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveContainerFactoryMgrSingleton
    {
        static final DirectiveContainerFactoryMgrIfc _singleton =
            new DirectiveContainerFactoryMgr ();
    }

    /**
     *
     * This is our default factory.
     *
     */
    private final DirectiveContainerFactoryIfc _defaultFactory;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveContainerFactoryMgr ()
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveContainerFactoryIfc defaultFactory =
            ( DirectiveContainerFactoryIfc )
                factoryContext.getDefaultFactory ( this );

        if ( defaultFactory == null )
        {
            defaultFactory =
                DefaultDirectiveContainerFactory.getSingleton ().getDefaultFactory ();
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
    public static DirectiveContainerFactoryMgrIfc getSingleton ()
    {
        return DirectiveContainerFactoryMgrSingleton._singleton;
    }

    /**
     *
     * This method will return our default address data factory.
     *
     * @return the default address data factory.
     *
     */
    public DirectiveContainerFactoryIfc getDefaultFactory ()
    {
        return _defaultFactory;
    }

    /**
     *
     * This method return an implementation of DirectiveContainerFactoryIfc.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveContainerFactoryIfc.
     *
     *
     */
    public DirectiveContainerFactoryIfc getFactory ( final Class classContext )
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveContainerFactoryIfc retVal = 
            ( DirectiveContainerFactoryIfc )
                factoryContext.getFactoryForContext ( this, classContext );

        if ( retVal == null )
        {
            retVal = getDefaultFactory ();
        }

        return retVal;
    }
}
