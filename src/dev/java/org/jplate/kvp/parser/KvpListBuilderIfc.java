package org.jplate.kvp.parser;


import java.util.List;

import org.jplate.foundation.parser.JPlateListBuilderIfc;

import org.jplate.kvp.KvpIfc;


/**
 
    A list builder called when KVP (key value pair) tokens have been parsed.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/parser/KvpListBuilderIfc.java $
    </pre>

    @param <V>  The KVP value type to build.

*/
public interface KvpListBuilderIfc <V extends KvpIfc>
    extends KvpBuilderIfc <List <V>>, JPlateListBuilderIfc <V>
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
}
