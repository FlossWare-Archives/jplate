package org.jplate.tmplate.directive.def;

/**
 *
 * This interface defines the API for determining the default address factory.
 *
 */
interface DefaultNamedDirectiveDefFactoryIfc
{
    /**
     *
     * This method returns the default factory.
     *
     * @return the default factory.
     *
     */
    public NamedDirectiveDefFactoryIfc getDefaultFactory ();
}
