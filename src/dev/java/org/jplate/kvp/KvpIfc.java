package org.jplate.kvp;

import org.jplate.foundation.FormattableIfc;


/**
 
    Defines a key value pair.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/KvpIfc.java $
    </pre>

*/
public interface KvpIfc extends FormattableIfc
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
     * Returns the key.
     *
     * @return the key.
     *
     */
    public String getKey ();


    /**
     *
     * Sets the key.
     *
     * @param key The new key.
     *
     */
    public void setKey ( String key );


    /**
     *
     * Returns the value.
     *
     * @return the value.
     *
     */
    public String getValue ();


    /**
     *
     * Sets the value.
     *
     * @param value The new value.
     *
     */
    public void setValue ( String value );


}
