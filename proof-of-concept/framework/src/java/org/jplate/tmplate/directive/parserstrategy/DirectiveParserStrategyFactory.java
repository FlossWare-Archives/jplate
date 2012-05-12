package org.jplate.tmplate.directive.parserstrategy;

import org.jplate.tmplate.directive.DirectiveCacheIfc;

/**
 *
 * This class satisfies the DirectiveParserStrategyFactoryIfc interface.  It
 * also adheres to the Singleton pattern.
 *
 */
final class DirectiveParserStrategyFactory
    implements DirectiveParserStrategyFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveParserStrategyFactorySingleton
    {
        static final DirectiveParserStrategyFactoryIfc _singleton =
            new DirectiveParserStrategyFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveParserStrategyFactory ()
    {
    }

    /**
     *
     * This method returns our singleton.
     *
     * @return the singleton.
     *
     */
    static DirectiveParserStrategyFactoryIfc getSingleton ()
    {
        return DirectiveParserStrategyFactorySingleton._singleton;
    }

    /**
     *
     * This method will create an implementation of
     * DirectiveParserStrategyIfc.
     *
     * @param directiveCache represents the cache to use during parsing when a
     *        named directive must be found.
     *
     * @return an implementation of DirectiveParserStrategyIfc.
     *
     */
    public DirectiveParserStrategyIfc createDirectiveParserStrategy
        ( final DirectiveCacheIfc directiveCache )
    {
        return new DirectiveParserStrategy ( directiveCache );
    }

    /**
     *
     * This method will create an implementation of DirectiveParserStrategyIfc.
     *
     * @return an implementation of DirectiveParserStrategyrIfc.
     *
     */
    public DirectiveParserStrategyIfc createDirectiveParserStrategy ()
    {
        return new DirectiveParserStrategy ();
    }
}

