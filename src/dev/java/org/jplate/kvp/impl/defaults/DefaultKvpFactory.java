package org.jplate.kvp.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.kvp.KvpFactoryIfc;
import org.jplate.kvp.KvpIfc;


/**
 
    Default Kvp factory.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/impl/defaults/DefaultKvpFactory.java $
    </pre>

*/
public class DefaultKvpFactory 
    extends    AbstractFactory <KvpIfc>
    implements KvpFactoryIfc   <KvpIfc>
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


    /**
     *
     * Needed in serialization.
     *
     */
    private static final long serialVersionUID = -8209140481641817513L;


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
        LogFactory.getLog ( DefaultKvpFactory.class );


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
    public DefaultKvpFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultKvpFactory created" );
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
    public KvpIfc create ()
    {
        final DefaultKvp retVal = new DefaultKvp ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created:  " + retVal );
        }

        return retVal;
    }


}
