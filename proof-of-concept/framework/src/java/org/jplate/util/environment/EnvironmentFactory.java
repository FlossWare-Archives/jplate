package org.jplate.util.environment;

/**
 *
 * This class satisfies the EnvironmentFactoryIfc interface.  It also adheres to
 * the Singleton pattern.
 *
 */
final class EnvironmentFactory implements EnvironmentFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class EnvironmentFactorySingleton
    {
        static final EnvironmentFactoryIfc _singleton =
            new EnvironmentFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private EnvironmentFactory ()
    {
    }

    /**
     *
     * This method returns our singleton.
     *
     * @return the singleton.
     *
     */
    static EnvironmentFactoryIfc getSingleton ()
    {
        return EnvironmentFactorySingleton._singleton;
    }

    /**
     *
     * This method will create an implementation of EnvironmentIfc.
     *
     * @return an implementation of EnvironmentIfc.
     *
     */
    public EnvironmentIfc createEnvironment ()
    {
        return new Environment ();
    }
}

