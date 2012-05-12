package org.jplate.tabular.impl.defaults;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.tabular.FieldFactoryIfc;
import org.jplate.tabular.FieldIfc;


/**
 
    Default field factory implementation.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultFieldFactory.java $
    </pre>

*/
public class DefaultFieldFactory extends AbstractFactory <FieldIfc>
    implements FieldFactoryIfc
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
     * Used during serialization.
     *
     */
    private static final long serialVersionUID = -4736566561720585246L;


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
        LogFactory.getLog ( DefaultFieldFactory.class );


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
    public DefaultFieldFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultFieldFactory created" );
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
    public FieldIfc create ()
    {
        final FieldIfc retVal = new DefaultField ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning [" + retVal + "]" );
        }

        return retVal;
    }
}
