package org.jplate.tmplate.directive.container;

import org.jplate.tmplate.directive.DirectiveContainerIfc;

/**
 *
 * This class satisfies the DirectiveContainerFactoryIfc interface.  It also
 * adheres to the Singleton pattern.
 *
 */
final class DirectiveContainerFactory implements DirectiveContainerFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveContainerFactorySingleton
    {
        static final DirectiveContainerFactoryIfc _singleton =
            new DirectiveContainerFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveContainerFactory ()
    {
    }

    /**
     *
     * This method returns our singleton.
     *
     * @return the singleton.
     *
     */
    static DirectiveContainerFactoryIfc getSingleton ()
    {
        return DirectiveContainerFactorySingleton._singleton;
    }

    /**
     *
     * This method will create an implementation of DirectiveContainerIfc.
     *
     * @return an implementation of DirectiveContainerIfc.
     *
     */
    public DirectiveContainerIfc createDirectiveContainer ()
    {
        return new DirectiveContainer ();
    }
}

