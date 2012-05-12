package org.jplate.foundation.gof.factory.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.FactoryIfc;


/**
 
    Abstract implementation of a
    {@link org.jplate.foundation.gof.factory.FactoryIfc}.  In many instances, the
    {@link #destroy} method is not required and is therefore being implemented here.
    The implementation does nothing.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/factory/impl/AbstractFactory.java $
    </pre>

    @param <V> The type of object to be created or destroyed.

*/
public abstract class AbstractFactory <V> implements FactoryIfc <V>
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
    private final transient Log _log = LogFactory.getLog ( AbstractFactory.class );


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
    protected AbstractFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New AbstractFactory created" );
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
    public void destroy ( final V object )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Requested to destroy [" + object + "]" );
        }
    }
}
