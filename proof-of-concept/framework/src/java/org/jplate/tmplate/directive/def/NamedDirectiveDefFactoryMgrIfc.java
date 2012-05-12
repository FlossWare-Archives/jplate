package org.jplate.tmplate.directive.def;

import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API to create implementation of
 * NamedDirectiveDefFactoryIfc's.
 *
 */
public interface NamedDirectiveDefFactoryMgrIfc extends FactoryMgrIfc
{
    /**
     *
     * This method will return our default factory.
     *
     * @return the default factory.
     *
     */
    public NamedDirectiveDefFactoryIfc getDefaultFactory ();

    /**
     *
     * This method return an implementation of NamedDirectiveDefFactoryIfc
     * based upon context.
     *
     * @param classContext represents the class who desires a factory.
     *
     * @return an implementation of NamedDirectiveDefFactoryIfc.
     *
     */
    public NamedDirectiveDefFactoryIfc getFactory ( Class classContext );
}
