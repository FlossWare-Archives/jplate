package org.jplate.foundation.parser.impl;


import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.parser.JPlateListBuilderIfc;
import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;


/**
 
    Abstract JPlate builder of {@link List}'s.  <b>Please note:</b>
    {@link #getResult} returns an unmodifiable list.  Additionally, subclasses
    are left to figure out what <code>buildEnd()</code> does as a builder may be
    building information that will need to be processes at the end of a parse.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/impl/AbstractJPlateListBuilder.java $
    </pre>

    @param <V>  The value type that will be stored in a {@link List}.

*/
public abstract class AbstractJPlateListBuilder <V>
    implements JPlateListBuilderIfc <V>
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
        LogFactory.getLog ( AbstractJPlateListBuilder.class );


    /**
     *
     * The list to hold KVP objects parsed.
     *
     */
    private final List <V> _resultList;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the factory used to hold the collection of
     * <code>V</code>'s.
     *
     * @param listFactory Factory to create a list that will be used to hold the
     *        implementations <code>V</code>
     *
     */
    public AbstractJPlateListBuilder ( final ListFactoryIfc <V> listFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New AbstractJPlateListBuilder created:  listFactory = [" +
                listFactory + "]"
            );
        }

        _resultList = listFactory.create ();
    }


    /**
     *
     * Default constructor.  Uses a {@link UnsynchronizedLinkedListFactory} to
     * create the list to hold the result.
     *
     */
    public AbstractJPlateListBuilder ()
    {
        this ( new UnsynchronizedLinkedListFactory <V> () );
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
    public List <V> getResult ()
    {
        return Collections.unmodifiableList ( _resultList );
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

        _resultList.clear ();
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

        _resultList.clear ();
    }


    /**
     *
     * This method returns the actual result and is available to subclasses.
     *
     * @return The actual result.
     *
     */
    protected List <V> getActualResultList ()
    {
        return _resultList;
    }
}
