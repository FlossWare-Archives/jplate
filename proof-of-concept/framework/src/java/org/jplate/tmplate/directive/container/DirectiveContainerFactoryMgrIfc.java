package org.jplate.tmplate.directive.container;

import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API to create implementation of
 * DirectiveContainerFactoryIfc's.
 *
 */
public interface DirectiveContainerFactoryMgrIfc extends FactoryMgrIfc
{
    /**
     *
     * This method will return our default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveContainerFactoryIfc getDefaultFactory ();

    /**
     *
     * This method return an implementation of DirectiveContainerFactoryIfc
     * based upon context.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveContainerFactoryIfc.
     *
     */
    public DirectiveContainerFactoryIfc getFactory ( Class classContext );
}
