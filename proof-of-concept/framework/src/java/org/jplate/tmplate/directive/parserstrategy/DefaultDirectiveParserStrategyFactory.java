package org.jplate.tmplate.directive.parserstrategy;

/**
 *
 * This class contains the default implementation of
 * DirectiveParserStrategyFactoryIfc.
 *
 */
final class DefaultDirectiveParserStrategyFactory
    implements DefaultDirectiveParserStrategyFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DefaultDirectiveParserStrategyFactorySingleton
    {
        static final DefaultDirectiveParserStrategyFactoryIfc _singleton =
            new DefaultDirectiveParserStrategyFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultDirectiveParserStrategyFactory () 
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    static DefaultDirectiveParserStrategyFactoryIfc getSingleton ()
    {
        return DefaultDirectiveParserStrategyFactorySingleton._singleton;
    }

    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveParserStrategyFactoryIfc getDefaultFactory ()
    {
        return DirectiveParserStrategyFactory.getSingleton ();
    }
}
