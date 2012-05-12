package org.jplate.kvp.parser.impl.defaults;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.foundation.parser.impl.AbstractJPlateListBuilder;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.kvp.KvpIfc;
import org.jplate.kvp.KvpFactoryIfc;

import org.jplate.kvp.impl.defaults.DefaultKvp;
import org.jplate.kvp.impl.defaults.DefaultKvpFactory;

import org.jplate.kvp.parser.KvpListBuilderIfc;
import org.jplate.kvp.parser.KvpParseContextIfc;


/**
 
    Default implementation of a KvpBuilderIfc.  It uses
    {@link org.jplate.kvp.impl.defaults.DefaultKvp} as its KvpIfc implementation and
    {@link org.jplate.kvp.impl.defaults.DefaultKvpFactory} as the factory for
    creating DefaultKvp.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/impl/defaults/DefaultKvpListBuilder.java $
    </pre>

*/
public class DefaultKvpListBuilder <V extends KvpIfc>
    extends    AbstractJPlateListBuilder <V>
    implements KvpListBuilderIfc <V>
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
        LogFactory.getLog ( DefaultKvpListBuilder.class );


    /**
     *
     * Used to create implementations of KvpIfc.
     *
     */
    private final KvpFactoryIfc <V> _kvpFactory;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the factory to create implementations of
     * <code>KvpIfc</code> as well as the list factory to use to hold the collection
     * of <code>KvpIfc</code>'s.
     *
     * @param kvpFactory Factory to create implementations of <code>KvpIfc</code>.
     *
     * @param listFactory Factory to create a list that will be used to hold the
     *        implementations <code>KvpIfc</code>
     *
     */
    public DefaultKvpListBuilder
        ( final KvpFactoryIfc <V> kvpFactory, final ListFactoryIfc <V> listFactory )
    {
        super ( listFactory );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultKvpListBuilder created:  kvpFactory = [" + kvpFactory +
                "]"
            );
        }

        _kvpFactory = kvpFactory;
    }


    /**
     *
     * This constructor sets defines list factory to use to create a collection to
     * hold implementations of <code>KvpIfc</code>'s.
     *
     * @param kvpFactory Factory to create a implementations <code>KvpIfc</code>
     *
     */
    public DefaultKvpListBuilder ( final KvpFactoryIfc <V> kvpFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultKvpListBuilder created:  kvpFactory = [" + kvpFactory +
                "]"
            );
        }

        _kvpFactory = kvpFactory;
    }


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private DefaultKvpListBuilder ()
    {
        final UnsupportedOperationException uoException =
            new UnsupportedOperationException ();
                
        _log.error ( "New DefaultKvpListBuilder created", uoException );

        throw uoException;
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
    public void buildEnd ( final int line, final int column )
        throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Building end [" + line + ", " + column + "]" );
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
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Building key value pair:\n" + parseContext.toString ( "    " )
            );
        }

        final V newPair = _kvpFactory.create ();

        parseContext.populate ( newPair );

        getActualResultList ().add ( newPair );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Added Kvp:\n" + newPair.toString ( "    " ) );
        }
    }
}
