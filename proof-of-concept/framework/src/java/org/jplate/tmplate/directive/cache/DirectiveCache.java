package org.jplate.tmplate.directive.cache;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveDefIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;
import org.jplate.tmplate.directive.PCDataDirectiveIfc;
import org.jplate.tmplate.directive.UnknownNamedDirectiveException;

import org.jplate.tmplate.directive.def.NamedDirectiveDefFactoryIfc;
import org.jplate.tmplate.directive.def.NamedDirectiveDefFactoryMgr;

/**
 *
 * This class satisfies the DirectiveCacheIfc interface.
 *
 */
final class DirectiveCache implements DirectiveCacheIfc
{
    /**
     *
     * This message means that a name specified is null.
     *
     */
    private static String NAME_IS_NULL_MSG = "name == null";

    /**
     *
     * This message means that a directive specified is null.
     *
     */
    private static String DIRECTIVE_IS_NULL_MSG = "directive == null";

    /**
     *
     * This is our cache of directives.
     *
     */
    final Map _cache;

    /**
     *
     * Default constructor.
     *
     */
    DirectiveCache ()
    {
        _cache = new HashMap ();
    }

    /**
     *
     * This is the copy constructor.
     *
     * @param directiveCache represents the directive cache to copy.
     *
     */
    private DirectiveCache ( final DirectiveCache directiveCache )
    {
        final Map cache = new HashMap ();

        cache.putAll ( directiveCache._cache );

        _cache = cache;
    }

    /**
     *
     * This constrcutor will set up directives.
     *
     * @param directives represents an array of named directives that will be
     *        used to populate self.
     *
     */
    DirectiveCache ( final NamedDirectiveDefIfc directives[] )
    {
        final Map cache = new HashMap ();

        //
        // If directives were provided, iterate over the array...
        //
        if ( directives != null )
        {
            final int size = directives.length;

            for ( int loop = 0; loop < size; loop++ )
            {
                final NamedDirectiveDefIfc directive = directives [ loop ];

                if ( directive != null )
                {
                    cache.put
                    (
                        directive.getName (), directive.getNamedDirective ()
                    );
                }
            }
        }

        _cache = cache;
    }

    /**
     *
     * This method will validate that name is an actual directive name.
     *
     * @param name represents the name of the directive.
     *
     * @return true if name is a valid directive name or false if not.
     *
     */
    public boolean isValidDirectiveName ( final String name )
    {
        return _cache.get ( name ) != null;
    }

    /**
     *
     * This method will return a named directive.
     *
     * @param name represents the name of the directive.
     *
     * @return a named directive.
     *
     * @throws UnknownNamedDirectiveException if name cannot be found.  Please
     *         note that this should not be thrown if calling
     *         isValidDirectiveName ( name ) returns true!
     *
     */
    public NamedDirectiveIfc getNamedDirective ( final String name )
        throws UnknownNamedDirectiveException
    {
        if ( name == null )
        {
            throw new NullPointerException ( NAME_IS_NULL_MSG );
        }

        final NamedDirectiveIfc retVal =
            ( NamedDirectiveIfc ) _cache.get ( name );

        if ( retVal == null )
        {
            throw new UnknownNamedDirectiveException ( name );
        }

        return retVal;
    }

    /**
     *
     * This method will define a new named directive.
     *
     * @param name represents the name of the named directive.
     *
     * @param directive represents the newly defined directive.
     *
     */
    public void defineNamedDirective
        ( final String name, final NamedDirectiveIfc directive )
    {
        if ( directive == null )
        {
            throw new NullPointerException ( DIRECTIVE_IS_NULL_MSG );
        }

        if ( name == null )
        {
            throw new NullPointerException ( NAME_IS_NULL_MSG );
        }

        _cache.put ( name, directive );
    }

    /**
     *
     * This method will define a new named directive.
     *
     * @param namedDirectiveDef represents the named directive definition.
     *
     */
    public void defineNamedDirective
        ( final NamedDirectiveDefIfc namedDirectiveDef )
    {
        defineNamedDirective
        (
            namedDirectiveDef.getName (), namedDirectiveDef.getNamedDirective ()
        );
    }

    /**
     *
     * This method will define new named directives.
     *
     * @param namedDirectiveDefs represents an array of named directive
     *        definitions.
     *
     */
    public void defineNamedDirectives
        ( final NamedDirectiveDefIfc namedDirectiveDefs[] )
    {
        final int total = namedDirectiveDefs.length;

        for ( int loop = 0; loop < total; loop++ )
        {
            defineNamedDirective ( namedDirectiveDefs [ loop ] );
        }
    }

    /**
     *
     * This method will copy a directive.  By copy, really it maps newName
     * to the same directive as oldName.
     *
     * @param oldName represents the original name of a directive.
     *
     * @param newName represents the new name of a directive.
     *
     * @throws UnknownNamedDirectiveException if no directive exists for
     *         oldName.
     *
     */
    public void copyNamedDirective
        ( final String oldName, final String newName )
            throws UnknownNamedDirectiveException
    {
        final Map cache = _cache;

        final NamedDirectiveIfc directive =
            ( NamedDirectiveIfc ) cache.get ( oldName );

        if ( directive == null )
        {
            throw new UnknownNamedDirectiveException ( oldName );
        }

        cache.put ( newName, directive );
    }

    /**
     *
     * This method will return all the names of directives defined.
     *
     * @return the name of all directives defined.
     *
     */
    public String[] getDirectiveNames ()
    {
        final Set    keySet   = _cache.keySet ();
        final int    size     = keySet.size ();
        final String retVal[] = new String [ size ];

        keySet.toArray ( retVal );

        return retVal;
    }

    /**
     *
     * This method will return all the named directives defined.
     *
     * @return the name of all named directives defined.
     *
     */
    public NamedDirectiveDefIfc[] getNamedDirectives ()
    {
        final Map      cache  = _cache;
        final Set      keySet = cache.keySet ();
        final Iterator keyItr = keySet.iterator ();

        final NamedDirectiveDefIfc retVal[] = 
            new NamedDirectiveDefIfc [ keySet.size () ];

        final NamedDirectiveDefFactoryIfc factory =
            NamedDirectiveDefFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        int index = 0;

        while ( keyItr.hasNext () )
        {
            final String name = ( String ) keyItr.next ();
            
            final NamedDirectiveIfc directive =
                ( NamedDirectiveIfc ) cache.get ( name );

            retVal [ index++ ] =
                factory.createNamedDirectiveDef ( name, directive );
        }

        return retVal;
    }

    /**
     *
     * This method will create a parsed character directive.
     *
     * @return a parsed character directive.
     *
     */
    public PCDataDirectiveIfc createPCDataDirective ()
    {
        return new PCDataDirective ();
    }

    /**
     *
     * This method will create a parsed character directive with the data.
     *
     * @param pcData represents the parsed character data for the PCData
     *        directive.
     *
     * @return a parsed character directive.
     *
     */
    public PCDataDirectiveIfc createPCDataDirective ( String pcData )
    {
        return new PCDataDirective ( pcData );
    }

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public DirectiveCacheIfc createCopy ()
    {
        return new DirectiveCache ( this );
    }
}
