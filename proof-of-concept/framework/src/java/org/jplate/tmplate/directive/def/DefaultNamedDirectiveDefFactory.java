package org.jplate.tmplate.directive.def;

/**
 *
 * This class contains the default implementation of
 * NamedDirectiveDefFactoryIfc.
 *
 */
final class DefaultNamedDirectiveDefFactory
    implements DefaultNamedDirectiveDefFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DefaultNamedDirectiveDefFactorySingleton
    {
        static final DefaultNamedDirectiveDefFactoryIfc _singleton =
            new DefaultNamedDirectiveDefFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultNamedDirectiveDefFactory () 
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    static DefaultNamedDirectiveDefFactoryIfc getSingleton ()
    {
        return DefaultNamedDirectiveDefFactorySingleton._singleton;
    }

    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public NamedDirectiveDefFactoryIfc getDefaultFactory ()
    {
        return NamedDirectiveDefFactory.getSingleton ();
    }
}
