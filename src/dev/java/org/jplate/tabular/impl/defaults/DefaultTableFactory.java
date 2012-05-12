package org.jplate.tabular.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.tabular.TableFactoryIfc;
import org.jplate.tabular.TableIfc;


/**
 
    Default table factory implementation.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultTableFactory.java $
    </pre>

*/
public class DefaultTableFactory extends AbstractFactory <TableIfc>
    implements TableFactoryIfc
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


    /**
     *
     * Used in serialization.
     *
     */
    private static final long serialVersionUID = -1468437269116282734L;


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
        LogFactory.getLog ( DefaultTableFactory.class );


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
    public DefaultTableFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultTableFactory created" );
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
    public TableIfc create ()
    {
        final TableIfc retVal = new DefaultTable ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created [" + retVal + "]" );
        }

        return retVal;
    }
}
