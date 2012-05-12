package org.jplate.kvp.parser;


import java.util.List;

import org.jplate.foundation.parser.JPlateBuilderIfc;
import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.kvp.KvpIfc;

/**
 
    A builder called when KVP (key value pair) tokens have been parsed.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/KvpBuilderIfc.java $
    </pre>

    @param <V>  The KVP value type to build.

*/
public interface KvpBuilderIfc <V> extends JPlateBuilderIfc <V>
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
     * This method is called when key / value pairs have been parsed.
     *
     * @param parseContext contains data about the parsed key/value pair.
     *
     * @throws JPlateBuildingException If there is a problem building the key / 
     *         value pair.
     *         
     *
     */
    public void buildKeyValuePair ( KvpParseContextIfc parseContext )
        throws JPlateBuildingException;
}
