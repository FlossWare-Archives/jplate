package org.jplate.foundation.parser.impl;


import java.util.Collections;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.parser.JPlateMapBuilderIfc;
import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.foundation.util.MapFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedHashMapFactory;



/**
 
    Abstract JPlate builder of {@link Map}'s.  <b>Please note:</b>
    {@link #getResult} returns an unmodifiable map.  Additionally, subclasses
    are left to figure out what {@link #buildEnd} does as a builder may be building
    information that will need to be processes at the end of a parse.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/impl/AbstractJPlateMapBuilder.java $
    </pre>

    @param <K> The key type stored in the @{link Map}.
    @param <V> The value type stored in the @{link Map}.

*/
public abstract class AbstractJPlateMapBuilder <K, V>
    implements JPlateMapBuilderIfc <K, V>
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
     * Holds the result.
     *
     */
    private Map <K, V> _mapResult;


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( AbstractJPlateMapBuilder.class );


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
    public AbstractJPlateMapBuilder ( final MapFactoryIfc <K, V> mapFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New AbstractJPlateMapBuilder created:  " +
                "mapFactory = [" + mapFactory + "]"
            );
        }

        _mapResult = mapFactory.create ();
    }


    /**
     *
     * Default constructor.  The map factory created is
     * {@link UnsynchronizedHashMapFactory}.
     *
     */
    public AbstractJPlateMapBuilder ()
    {
        this ( new UnsynchronizedHashMapFactory <K, V> () );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New AbstractJPlateMapBuilder created" );
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
    public Map <K, V> getResult ()
    {
        return Collections.unmodifiableMap ( _mapResult );
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

        _mapResult.clear ();
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

        _mapResult.clear ();
    }


    /**
     *
     * This method returns the actual result and is available to subclasses.
     *
     * @return The actual result.
     *
     */
    protected Map <K, V> getActualResultMap ()
    {
        return _mapResult;
    }
}

