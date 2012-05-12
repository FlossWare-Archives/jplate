package org.jplate.util.environment;

/**
 *
 * This class contains the default implementation of
 * EnvironmentFactoryIfc.
 *
 */
final class DefaultEnvironmentFactory implements DefaultEnvironmentFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DefaultEnvironmentFactorySingleton
    {
        static final DefaultEnvironmentFactoryIfc _singleton =
            new DefaultEnvironmentFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultEnvironmentFactory () 
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    static DefaultEnvironmentFactoryIfc getSingleton ()
    {
        return DefaultEnvironmentFactorySingleton._singleton;
    }

    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public EnvironmentFactoryIfc getDefaultFactory ()
    {
        return EnvironmentFactory.getSingleton ();
    }
}
