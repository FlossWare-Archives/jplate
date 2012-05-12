package org.jplate.tmplate.directive.def;

import org.jplate.tmplate.directive.NamedDirectiveDefIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This class satisfies the NamedDirectiveDefIfc interface.  It defines a named
 * directive.
 *
 */
final class NamedDirectiveDef implements NamedDirectiveDefIfc
{
    /**
     *
     * Denotes name is null.
     *
     */
    private static final String NAME_IS_NULL_MSG = "name == null";

    /**
     *
     * Denotes named directive is null.
     *
     */
    private static final String NAMED_DIRECTIVE_IS_NULL_MSG =
        "namedDirective == null";
    
    /**
     *
     * This is the name of the directive.
     *
     */
    private final String _name;

    /**
     *
     * This is the directive.
     *
     */
    private final NamedDirectiveIfc _namedDirective;

    /**
     *
     * Default constructor.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private NamedDirectiveDef ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor sets the name and named directive.
     *
     * @param name represents the name of the named directive.
     *
     * @param namedDirective represents the named directive.
     *
     * @throws NullPointerException if either name or namedDirectiveDef are
     *         null.
     *
     */
    NamedDirectiveDef
        ( final String name, NamedDirectiveIfc namedDirective )
    {
        if ( name == null )
        {
            throw new NullPointerException ( NAME_IS_NULL_MSG );
        }
        else if ( namedDirective == null )
        {
            throw new NullPointerException ( NAMED_DIRECTIVE_IS_NULL_MSG );
        }

        _name           = name;
        _namedDirective = namedDirective;
    }

    /**
     *
     * This is the copy constructor.
     *
     * @param namedDirectiveDef represents the name directive def to copy.
     *
     */
    private NamedDirectiveDef ( final NamedDirectiveDef namedDirectiveDef )
    {
        _name           = namedDirectiveDef._name;
        _namedDirective = namedDirectiveDef._namedDirective;
    }

    /**
     *
     * This method will return the name.
     *
     * @return the name.
     *
     */
    public String getName ()
    {
        return _name;
    }

    /**
     *
     * This method will return the named directive.
     *
     * @return the named directive.
     *
     */
    public NamedDirectiveIfc getNamedDirective ()
    {
        return _namedDirective;
    }


    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public NamedDirectiveDefIfc createCopy ()
    {
        return new NamedDirectiveDef ( this );
    }
}
