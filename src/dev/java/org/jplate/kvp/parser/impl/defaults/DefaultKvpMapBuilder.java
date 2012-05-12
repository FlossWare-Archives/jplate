package org.jplate.kvp.parser.impl.defaults;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.foundation.util.MapFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedHashMapFactory;

import org.jplate.kvp.parser.KvpMapBuilderIfc;
import org.jplate.kvp.parser.KvpParseContextIfc;


/**
 
    Kvp builder that constructs {@link Map}'s containing String name/value pairs.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/impl/defaults/DefaultKvpMapBuilder.java $
    </pre>

*/
public class DefaultKvpMapBuilder implements KvpMapBuilderIfc
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
     * Used to create Map's.
     *
     */
    private final MapFactoryIfc <String, String> _mapFactory;


    /**
     *
     * Holds the result.
     *
     */
    private Map <String, String> _mapResult;


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( DefaultKvpMapBuilder.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the map factory that is use to hold name/value pairs.
     *
     * @param mapFactory Factory to create a map that will be used to hold the
     *        name/value pairs.
     *
     */
    public DefaultKvpMapBuilder ( final MapFactoryIfc <String, String> mapFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultKvpMapBuilder created:  mapFactory = [" + mapFactory +
                "]"
            );
        }

        _mapFactory = mapFactory;
    }


    /**
     *
     * Default constructor.  The map factory created is
     * {@link UnsynchronizedHashMapFactory}.
     *
     */
    public DefaultKvpMapBuilder ()
    {
        this ( new UnsynchronizedHashMapFactory <String, String> () );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultKvpMapBuilder created" );
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
    public Map <String, String> getResult ()
    {
        return _mapResult;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void reset ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Restting result" );
        }

        if ( _mapResult != null )
        {
            _mapResult.clear ();
        }
        else
        {
            _log.warn ( "Result was not set, cannot clear" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildStart () throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Building start" );
        }

        _mapResult = _mapFactory.create ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildEnd ( final int line, final int column )
        throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Done building" );
        }
    }
    

    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildKeyValuePair ( final KvpParseContextIfc parseContext )
        throws JPlateBuildingException
    {
        _mapResult.put ( parseContext.getKey (), parseContext.getValue () );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Build key/value pair:  [" + parseContext.getKey () + ", " +
                parseContext.getValue () + "]"
            );
        }
    }
}
