package org.jplate.kvp.parser.impl.defaults;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.kvp.KvpIfc;

import org.jplate.kvp.parser.KvpParseContextIfc;


/**
 
    Default implementation of KvpParseIfc.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/impl/defaults/DefaultKvpParseContext.java $
    </pre>

*/
public class DefaultKvpParseContext
    implements KvpParseContextIfc <DefaultKvpParseContext>
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
        LogFactory.getLog ( DefaultKvpParseContext.class );


    /**
     *
     * The parsed key.
     *
     */
    private String _key;


    /**
     *
     * The line where key was found.
     *
     */
    private int _keyLine;


    /**
     *
     * The column where key was found.
     *
     */
    private int _keyColumn;


    /**
     *
     * The parsed value.
     *
     */
    private String _value;


    /**
     *
     * The line where value was found.
     *
     */
    private int _valueLine;


    /**
     *
     * The column where value was found.
     *
     */
    private int _valueColumn;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This is the copy constructor.
     *
     */
    public DefaultKvpParseContext ( final DefaultKvpParseContext toCopy )
    {
        _key         = toCopy._key;
        _keyLine     = toCopy._keyLine;
        _keyColumn   = toCopy._keyColumn;
        _value       = toCopy._value;
        _valueLine   = toCopy._valueLine;
        _valueColumn = toCopy._valueColumn;

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Copy constructor:  toCopy = [" + toCopy + "]" );
        }
    }


    /**
     *
     * Default constructor.
     *
     */
    public DefaultKvpParseContext ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultKvpParseContext created" );
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
    public String toString ( final String prepend )
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( prepend );
        sb.append ( "_key ["           ).append ( _key         );
        sb.append ( "] _keyLine ["     ).append ( _keyLine     );
        sb.append ( "] _keyColumn ["   ).append ( _keyColumn   );
        sb.append ( "] _value ["       ).append ( _value       );
        sb.append ( "] _valueLine ["   ).append ( _valueLine   );
        sb.append ( "] _valueColumn [" ).append ( _valueColumn );
        sb.append ( "]\n" );

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public DefaultKvpParseContext createCopy ()
    {
        return new DefaultKvpParseContext ( this );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public DefaultKvpParseContext createInstance ()
    {
        return new DefaultKvpParseContext ();
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
    public int getKeyLine ()
    {
        return _keyLine;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int getKeyColumn ()
    {
        return _keyColumn;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setKey ( final String key, final int line, final int column )
    {
        _key       = key;
        _keyLine   = line;
        _keyColumn = column;

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New key set:  key = [" + key + "]  line = [" + line +
                "]  column = [" + column + "]"
            );
        }
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
    public int getValueLine ()
    {
        return _valueLine;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int getValueColumn ()
    {
        return _valueColumn;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setValue ( final String value, final int line, final int column )
    {
        _value       = value;
        _valueLine   = line;
        _valueColumn = column;

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New value set:  key = [" + value + "]  line = [" + line +
                "]  column = [" + column + "]"
            );
        }
    }
    

    /**
     *
     * {@inheritDoc}
     *
     */
    public void populate ( final KvpIfc kvp )
    {
        kvp.setKey   ( _key   );
        kvp.setValue ( _value );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Newly populated kvp:\n" + kvp.toString ( "    " ) );
        }
    }
}
