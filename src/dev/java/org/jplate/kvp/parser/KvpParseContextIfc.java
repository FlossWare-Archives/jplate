package org.jplate.kvp.parser;


import org.jplate.foundation.FormattableIfc;

import org.jplate.foundation.gof.prototype.PrototypeIfc;

import org.jplate.kvp.KvpIfc;


/**
 
    Used when parsing to hold state.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/KvpParseContextIfc.java $
    </pre>

*/
public interface KvpParseContextIfc <P extends KvpParseContextIfc> 
    extends FormattableIfc, PrototypeIfc <P>
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
     * Return the key.
     *
     * @return The key.
     *
     */
    public String getKey ();


    /**
     *
     * Return the line where <code>key</code> was found.
     *
     * @return The line where <code>key</code> was found.
     *
     */
    public int getKeyLine ();


    /**
     *
     * Return the column where <code>key</code> was found.
     *
     * @return The column where <code>key</code> was found.
     *
     */
    public int getKeyColumn ();


    /**
     *
     * This method sets information about the key.
     *
     * @param key The key encountered.
     *
     * @param line The line where <code>key</code> begins.
     *
     * @param column The column number where </code>key</code> begins.
     *
     */
    public void setKey ( String key, int line, int column );


    /**
     *
     * Return the value.
     *
     * @return The value.
     *
     */
    public String getValue ();


    /**
     *
     * Return the line where <code>value</code> was found.
     *
     * @return The line where <code>value</code> was found.
     *
     */
    public int getValueLine ();


    /**
     *
     * Return the column where <code>value</code> was found.
     *
     * @return The column where <code>value</code> was found.
     *
     */
    public int getValueColumn ();


    /**
     *
     * This method sets information about the value.
     *
     * @param value The value encountered.
     *
     * @param line The line where <code>value</code> begins.
     *
     * @param column The column number where </code>value</code> begins.
     *
     */
    public void setValue ( String value, int line, int column );
    

    /**
     *
     * Use the values contained within to populatete <code>kvp</code>.
     *
     * @param kvp The key/value pair to populate.
     *
     */
    public void populate ( KvpIfc kvp );
}
