package org.jplate.tmplate.directive.parserstrategy;

import org.jplate.util.factorycontext.FactoryContextIfc;
import org.jplate.util.factorycontext.FactoryContext;

/**
 *
 * This class satisfies the DirectiveParserStrategyFactoryMgrIfc and adheres
 * to the Singleton pattern.
 *
 */
public final class DirectiveParserStrategyFactoryMgr
    implements DirectiveParserStrategyFactoryMgrIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveParserStrategyFactoryMgrSingleton
    {
        static final DirectiveParserStrategyFactoryMgrIfc _singleton =
            new DirectiveParserStrategyFactoryMgr ();
    }

    /**
     *
     * This is our default factory.
     *
     */
    private final DirectiveParserStrategyFactoryIfc _defaultFactory;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveParserStrategyFactoryMgr ()
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveParserStrategyFactoryIfc defaultFactory =
            ( DirectiveParserStrategyFactoryIfc )
                factoryContext.getDefaultFactory ( this );

        if ( defaultFactory == null )
        {
            defaultFactory =
                DefaultDirectiveParserStrategyFactory.getSingleton ().getDefaultFactory ();
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
    public static DirectiveParserStrategyFactoryMgrIfc getSingleton ()
    {
        return DirectiveParserStrategyFactoryMgrSingleton._singleton;
    }

    /**
     *
     * This method will return our default address data factory.
     *
     * @return the default address data factory.
     *
     */
    public DirectiveParserStrategyFactoryIfc getDefaultFactory ()
    {
        return _defaultFactory;
    }

    /**
     *
     * This method return an implementation of
     * DirectiveParserStrategyFactoryIfc.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveParserStrategyFactoryIfc.
     *
     *
     */
    public DirectiveParserStrategyFactoryIfc getFactory
        ( final Class classContext )
    {
        final FactoryContextIfc factoryContext = FactoryContext.getSingleton ();

        DirectiveParserStrategyFactoryIfc retVal = 
            ( DirectiveParserStrategyFactoryIfc )
                factoryContext.getFactoryForContext ( this, classContext );

        if ( retVal == null )
        {
            retVal = getDefaultFactory ();
        }

        return retVal;
    }
}
