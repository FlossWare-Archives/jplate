package org.jplate.foundation.node.attribute;


import org.jplate.foundation.FormattableIfc;


/**
 
    An attribute is a name/value pair.  As name uniquely identifies an attribute,
    its name is immutable through this interface.  Values, however, are mutable.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/attribute/AttributeIfc.java $
    </pre>


    @param <N> The name type of the attribute.

    @param <V> The value type of the attribute.

*/
public interface AttributeIfc <N, V> extends FormattableIfc
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


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns the name of the attribute.
     *
     * @return the name of the attribute.
     *
     */
    public N getName ();


    /**
     *
     * Returns the value of the attribute.
     *
     * @return the value of the attribute.
     *
     */
    public V getValue ();


    /**
     *
     * Sets the value of the attribute.
     *
     * @param value represents the new value of the attribute.
     *
     */
    public void setValue ( V value );
}
