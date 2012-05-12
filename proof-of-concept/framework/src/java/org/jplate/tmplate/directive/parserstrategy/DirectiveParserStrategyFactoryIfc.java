package org.jplate.tmplate.directive.parserstrategy;

import org.jplate.factory.FactoryIfc;

import org.jplate.tmplate.directive.DirectiveCacheIfc;

/**
 *
 * This interface defines the API to create an implementation of
 * DirectiveParserStrategyIfc.
 *
 */
public interface DirectiveParserStrategyFactoryIfc extends FactoryIfc
{
    /**
     *
     * This method will create an implementation of DirectiveParserStrategyIfc.
     *
     * @param directiveCache represents the cache to use during parsing when a
     *        named directive must be found.
     *
     * @return an implementation of DirectiveParserStrategyrIfc.
     *
     */
    public DirectiveParserStrategyIfc createDirectiveParserStrategy
        ( DirectiveCacheIfc directiveCache );

    /**
     *
     * This method will create an implementation of DirectiveParserStrategyIfc.
     *
     * @return an implementation of DirectiveParserStrategyrIfc.
     *
     */
    public DirectiveParserStrategyIfc createDirectiveParserStrategy ();
}

