package org.jplate.tmplate.directive.parserstrategy;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.DirectiveContainerIfc;

import org.jplate.tmplate.parser.JPlateParserStrategyIfc;

/**
 *
 * This interface defines the API for a directive parser strategy.
 *
 */
public interface DirectiveParserStrategyIfc extends JPlateParserStrategyIfc
{
    /**
     *
     * This method will return the directive cache being used.
     *
     * @return the directive cache being used.
     *
     */
    public DirectiveCacheIfc getDirectiveCache ();
    
    /**
     *
     * This method will return the directive container that was built when
     * parsing.
     * 
     * @return the directive container that was built when parsing.
     *
     */
    public DirectiveContainerIfc getDirectiveContainer ();
}
