package org.jplate.tmplate.directive.def;

import org.jplate.tmplate.directive.NamedDirectiveDefIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This class satisfies the NamedDirectiveDefFactoryIfc interface.  It also
 * adheres to the Singleton pattern.
 *
 */
final class NamedDirectiveDefFactory implements NamedDirectiveDefFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class NamedDirectiveDefFactorySingleton
    {
        static final NamedDirectiveDefFactoryIfc _singleton =
            new NamedDirectiveDefFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private NamedDirectiveDefFactory ()
    {
    }

    /**
     *
     * This method returns our singleton.
     *
     * @return the singleton.
     *
     */
    static NamedDirectiveDefFactoryIfc getSingleton ()
    {
        return NamedDirectiveDefFactorySingleton._singleton;
    }

    /**
     *
     * This method will create an implementation of
     * NamedDirectiveDefIfc.
     *
     * @param name represents the name of the named directive.
     *
     * @param namedDirective represents the named directive.
     *
     * @return an implementation of NamedDirectiveDefIfc.
     *
     */
    public NamedDirectiveDefIfc createNamedDirectiveDef
        ( final String name, final NamedDirectiveIfc namedDirective )
    {
        return new NamedDirectiveDef ( name, namedDirective );
    }
}

