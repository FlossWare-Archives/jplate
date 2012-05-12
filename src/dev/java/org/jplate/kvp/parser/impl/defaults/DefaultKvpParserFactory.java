package org.jplate.kvp.parser.impl.defaults;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.kvp.KvpIfc;

import org.jplate.kvp.parser.KvpBuilderIfc;
import org.jplate.kvp.parser.KvpParseContextIfc;
import org.jplate.kvp.parser.KvpParserIfc;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;


/**
 
    Default factory implementation for creating implementations of KvpParserIfc's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/impl/defaults/DefaultKvpParserFactory.java $
    </pre>

    @param <B>  The builder who will be called to build objects as they are
                parsed.

*/
public class DefaultKvpParserFactory <B extends KvpBuilderIfc <?>>
    extends AbstractFactory <DefaultKvpParser <B>>
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
        LogFactory.getLog ( DefaultKvpParserFactory.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor.
     *
     */
    public DefaultKvpParserFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultKvpParserFactory created" );
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
    public DefaultKvpParser <B> create ()
    {
        final DefaultKvpParser <B> retVal = new DefaultKvpParser <B> ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created new DefaultKvpParser = [" + retVal + "]" );
        }

        return retVal;
    }

}
