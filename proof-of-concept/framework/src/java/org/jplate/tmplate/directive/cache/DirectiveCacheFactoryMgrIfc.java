package org.jplate.tmplate.directive.cache;

import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API to create implementation of
 * DirectiveCacheFactoryIfc's.
 *
 */
public interface DirectiveCacheFactoryMgrIfc extends FactoryMgrIfc
{
    /**
     *
     * This method will return our default factory.
     *
     * @return the default factory.
     *
     */
    public DirectiveCacheFactoryIfc getDefaultFactory ();

    /**
     *
     * This method return an implementation of DirectiveCacheFactoryIfc
     * based upon context.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of DirectiveCacheFactoryIfc.
     *
     */
    public DirectiveCacheFactoryIfc getFactory ( Class classContext );
}
