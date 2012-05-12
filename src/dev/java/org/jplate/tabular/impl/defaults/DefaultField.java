package org.jplate.tabular.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.tabular.FieldIfc;


/**
 
    Default implementation of {@link org.jplate.tabular.FieldIfc}.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultField.java $
    </pre>

*/
public class DefaultField implements FieldIfc
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
        LogFactory.getLog ( DefaultField.class );


    /**
     *
     * The value of the field.
     *
     */
    private String _value;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the value.
     *
     * @param value The value of the field.
     *
     */
    public DefaultField ( final String value )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultField created.  value = [" + value + "]" );
        }

        _value = value;
    }


    /**
     *
     * Default constructor.
     *
     */
    public DefaultField ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultField created" );
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
    public String getValue ()
    {
        return _value;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setValue ( final String value )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New value [" + value + "]" );
        }

        _value= value;
    }
}
