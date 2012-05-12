package org.jplate.tmplate.directive.container;

/**
 *
 * This class contains the default implementation of
 * DirectiveContainerFactoryIfc.
 *
 */
final class DefaultDirectiveContainerFactory
    implements DefaultDirectiveContainerFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DefaultDirectiveContainerFactorySingleton
    {
        static final DefaultDirectiveContainerFactoryIfc _singleton =
            new DefaultDirectiveContainerFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultDirectiveContainerFactory () 
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    static DefaultDirectiveContainerFactoryIfc getSingleton ()
    {
        return DefaultDirectiveContainerFactorySingleton._singleton;
    }

    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveContainerFactoryIfc getDefaultFactory ()
    {
        return DirectiveContainerFactory.getSingleton ();
    }
}
