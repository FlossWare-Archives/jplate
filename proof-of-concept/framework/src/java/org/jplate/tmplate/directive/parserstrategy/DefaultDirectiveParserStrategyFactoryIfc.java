package org.jplate.tmplate.directive.parserstrategy;

/**
 *
 * This interface defines the API for determining the default address factory.
 *
 */
interface DefaultDirectiveParserStrategyFactoryIfc
{
    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveParserStrategyFactoryIfc getDefaultFactory ();
}
