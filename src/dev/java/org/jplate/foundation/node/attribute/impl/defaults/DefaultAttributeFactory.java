package org.jplate.foundation.node.attribute.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.impl.AbstractContextFactory;

import org.jplate.foundation.node.attribute.AttributeFactoryIfc;
import org.jplate.foundation.node.attribute.AttributeIfc;


/**
 
    Default implementation of {@link AttributeFactoryIfc} that creates
    DefaultAttribute's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/attribute/impl/defaults/DefaultAttributeFactory.java $
    </pre>


    @param <V> The value type of the attribute.

    @param <N> The name type of the attribute.

*/
public final class DefaultAttributeFactory <V, N>
    extends     AbstractContextFactory <DefaultAttribute <N, V>, N>
    implements  AttributeFactoryIfc    <DefaultAttribute <N, V>, N>
{
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
     * For serialization purposes.
     *
     */
    private static final long serialVersionUID = -3041201445741803606L;


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
        LogFactory.getLog ( DefaultAttributeFactory.class );

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
    public DefaultAttributeFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New DefaultAttributeFactory created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Creates an attribute whose name is <code>name</code>
     *
     * @param name The name of the attribute.
     *
     * @return A new DefaultAttribute.
     *
     */
    public DefaultAttribute <N, V> create ( final N name )
    {
        DefaultAttribute <N, V> retVal = new DefaultAttribute <N, V> ( name );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Created attribute for name [" + name + "]:  [" + retVal + "]"
            );
        }

        return retVal;
    }
}
