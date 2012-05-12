package org.jplate.util.environment;

import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API to create implementation of
 * EnvironmentFactoryIfc's.
 *
 */
public interface EnvironmentFactoryMgrIfc extends FactoryMgrIfc
{
    /**
     *
     * This method will return our default factory.
     *
     * @return the default factory.
     *
     */
    public EnvironmentFactoryIfc getDefaultFactory ();

    /**
     *
     * This method return an implementation of EnvironmentFactoryIfc
     * based upon context.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of EnvironmentFactoryIfc.
     *
     */
    public EnvironmentFactoryIfc getFactory ( Class classContext );
}
