package org.jplate.foundation.node.attribute.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.node.attribute.AttributeIfc;

import org.jplate.foundation.util.Assert;


/**
 
    Default implementation of {@link AttributeIfc}.  It represents an attribute
    which is a name/value pair.  As name uniquely identifies an attribute,
    its name is immutable through this interface.  Values, however, are mutable.
    <b>Please note:</b>  Manipulation of the value is not thread safe.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/attribute/impl/defaults/DefaultAttribute.java $
    </pre>


    @param <N> The name type of the attribute.

    @param <V> The value type of the attribute.

*/
public final class DefaultAttribute <N, V> implements AttributeIfc <N, V>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
    //
    // Static class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Denotes the name is null...
     *
     */
    private static final String NAME_IS_NULL_MSG = "name == null";


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log = LogFactory.getLog ( DefaultAttribute.class );


    /**
     *
     * The name of the attribute.
     *
     */
    private final N _name;


    /**
     *
     * The value of the attribute.
     *
     */
    private V _value;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the name the attribute.
     *
     * @param name The name of the attribute.
     *
     * @throws IllegalArgumentException if name is null.
     *
     */
    public DefaultAttribute ( final N name )
    {
        Assert.isReferenced ( NAME_IS_NULL_MSG, name );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New attribute created named:  [" + name + "]" );
        }

        _name = name;
    }


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException If this constructor is called.
     *
     */
    private DefaultAttribute ()
    {
        _log.error ( "Default constructor not supported" );

        throw new UnsupportedOperationException ();
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns the hash code representation of self.
     *
     * @return the hash code of self.
     *
     */
    public int hashCode ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning hashCode [" + _name.hashCode () + "]" );
        }

        return _name.hashCode ();
    }


    /**
     *
     * Returns true if self is equal to <code>toCompare</code> or false if not.
     *
     * @param toCompare The object to compare self for equality.
     *
     * @return true If self equal to <code>toCompare</code> or false if not.
     *
     */
    public boolean equals ( final Object toCompare )
    {
        boolean retVal;

        if ( toCompare == null )
        {
            retVal = false;
        }
        else if ( toCompare == this )
        {
            retVal = true;
        }
        else if ( toCompare instanceof AttributeIfc )
        {
            final AttributeIfc attribute = ( AttributeIfc ) toCompare;

            retVal =
                hashCode () == attribute.hashCode () &&
                _name.equals ( attribute.getName () );
        }
        else
        {
            retVal = false;
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Compared self to [" + toCompare + "] = [" + retVal + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * Returns a string representation of self.
     *
     * @return A string representation of self.
     *
     */
    public String toString ()
    {
        return toString ( "" );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String toString ( final String prepend )
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( prepend ).append ( "_name [" ).append ( _name );
        sb.append ( "] _value [" ).append ( _value ).append ( "]\n" );

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public N getName ()
    {
        return _name;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public V getValue ()
    {
        return _value;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setValue ( final V value )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Setting value to [" + value + "]" );
        }

        _value = value;
    }
}
