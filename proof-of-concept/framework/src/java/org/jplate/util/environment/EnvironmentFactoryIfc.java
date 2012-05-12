package org.jplate.util.environment;

import org.jplate.factory.FactoryIfc;

/**
 *
 * This interface defines the API to create an implementation of
 * EnvironmentIfc.
 *
 */
public interface EnvironmentFactoryIfc extends FactoryIfc
{
    /**
     *
     * This method will create an implementation of EnvironmentIfc.
     *
     * @return an implementation of EnvironmentIfc.
     *
     */
    public EnvironmentIfc createEnvironment ();
}

