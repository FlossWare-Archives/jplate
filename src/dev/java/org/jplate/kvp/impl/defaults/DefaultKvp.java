package org.jplate.kvp.impl.defaults;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.kvp.KvpIfc;

/**
 
    Default implementation of a KvpIfc.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/impl/defaults/DefaultKvp.java $
    </pre>

*/
public class DefaultKvp implements KvpIfc
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
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
    private final transient Log _log =
        LogFactory.getLog ( DefaultKvp.class );


    /**
     *
     * Holds the key.
     *
     */
    private String _key;


    /**
     *
     * Holds the value.
     *
     */
    private String _value;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Copy constructor.
     *
     * @param toCopy The object to copy.
     *
     */
    public DefaultKvp ( final DefaultKvp toCopy )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Copy constructor called:  [" + toCopy + "]" );
        }

        _key   = toCopy._key;
        _value = toCopy._value;
    }


    /**
     *
     * Copy constructor.
     *
     * @param toCopy The object to copy.
     *
     */
    public DefaultKvp ( final KvpIfc toCopy )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "KvpIfc constructor called:  [" + toCopy + "]" );
        }

        _key   = toCopy.getKey   ();
        _value = toCopy.getValue ();
    }


    /**
     *
     * Default constructor.
     *
     */
    public DefaultKvp ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultKvp created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * {@inheritDoc}
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
        else if ( toCompare.getClass () == DefaultKvp.class )
        {
            DefaultKvp dk = ( DefaultKvp ) toCompare;

            retVal =
                ( _key   != null ? _key.equals   ( dk._key   ) : false ) &&
                ( _value != null ? _value.equals ( dk._value ) : false );
        }
        else if ( toCompare instanceof KvpIfc )
        {
            KvpIfc k = ( KvpIfc ) toCompare;

            retVal =
                ( _key   != null ? _key.equals   ( k.getKey   () ) : false ) &&
                ( _value != null ? _value.equals ( k.getValue () ) : false );
        }
        else
        {
            retVal = false;
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int hashCode ()
    {
        return
            ( _key   != null ? _key.hashCode   () : 0 ) +
            ( _value != null ? _value.hashCode () : 0 );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String toString ( final String prepend )
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( prepend ).append ( "_key = [" ).append ( _key );
        sb.append ( "] _value [" ).append ( _value  ).append ( "]" );

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String getKey ()
    {
        return _key;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setKey ( final String key )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New key = [" + key + "]" );
        }

        _key = key;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String getValue ()
    {
        return _value;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setValue ( final String value )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New value = [" + value + "]" );
        }

        _value = value;
    }


}
