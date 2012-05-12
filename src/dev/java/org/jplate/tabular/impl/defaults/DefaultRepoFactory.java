package org.jplate.tabular.impl.defaults;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.tabular.RepoFactoryIfc;
import org.jplate.tabular.RepoIfc;

public class DefaultRepoFactory extends AbstractFactory <RepoIfc>
    implements RepoFactoryIfc
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
     * Used in serialization.
     *
     */
    private static final long serialVersionUID = -5202291317143823229L;


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
        LogFactory.getLog ( DefaultRepoFactory.class );


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
    public DefaultRepoFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultRepoFactory created" );
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
    public RepoIfc create ()
    {
        final RepoIfc retVal = new DefaultRepo ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created [" + retVal + "]" );
        }

        return retVal;
    }
}
