package org.jplate.tmplate.directive.container;

import org.jplate.factory.FactoryIfc;

import org.jplate.tmplate.directive.DirectiveContainerIfc;

/**
 *
 * This interface defines the API to create an implementation of
 * DirectiveContainerIfc.
 *
 */
public interface DirectiveContainerFactoryIfc extends FactoryIfc
{
    /**
     *
     * This method will create an implementation of DirectiveContainerIfc.
     *
     * @return an implementation of DirectiveContainerIfc.
     *
     */
    public DirectiveContainerIfc createDirectiveContainer ();
}

