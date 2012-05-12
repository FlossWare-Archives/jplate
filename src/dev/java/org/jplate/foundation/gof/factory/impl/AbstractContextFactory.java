package org.jplate.foundation.gof.factory.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.ContextFactoryIfc;


/**
 
    Abstract implementation of a
    {@link org.jplate.foundation.gof.factory.ContextFactoryIfc}.  In many instances,
    the {@link #destroy} method is not required and is therefore being implemented
    here.  The implementation does nothing.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/factory/impl/AbstractContextFactory.java $
    </pre>

    @param <V> The type of object to be created or destroyed.

    @param <C> The context in which <code>V</code> will be created.  Consider this
               akin to a param or data needed in order to successfully create an
               object.

*/
public abstract class AbstractContextFactory <V, C>
    implements ContextFactoryIfc <V, C>
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
        LogFactory.getLog ( AbstractContextFactory.class );


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
    protected AbstractContextFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New AbstractContextFactory" );
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
