package org.jplate.tmplate.directive.parserstrategy;

import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API to create implementation of
 * DirectiveParserStrategyFactoryIfc's.
 *
 */
public interface DirectiveParserStrategyFactoryMgrIfc extends FactoryMgrIfc
{
    /**
     *
     * This method will return our default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveParserStrategyFactoryIfc getDefaultFactory ();

    /**
     *
     * This method return an implementation of DirectiveParserStrategyFactoryIfc
     * based upon context.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveParserStrategyFactoryIfc.
     *
     */
    public DirectiveParserStrategyFactoryIfc getFactory ( Class classContext );
}
