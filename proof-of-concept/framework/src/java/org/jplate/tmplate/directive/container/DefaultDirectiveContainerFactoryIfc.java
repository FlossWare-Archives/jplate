package org.jplate.tmplate.directive.container;

/**
 *
 * This interface defines the API for determining the default address factory.
 *
 */
interface DefaultDirectiveContainerFactoryIfc
{
    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveContainerFactoryIfc getDefaultFactory ();
}
