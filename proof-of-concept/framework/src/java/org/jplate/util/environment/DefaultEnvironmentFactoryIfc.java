package org.jplate.util.environment;

/**
 *
 * This interface defines the API for determining the default environment
 * factory.
 *
 */
interface DefaultEnvironmentFactoryIfc
{
    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public EnvironmentFactoryIfc getDefaultFactory ();
}
