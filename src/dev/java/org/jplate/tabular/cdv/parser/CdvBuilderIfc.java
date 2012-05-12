package org.jplate.tabular.cdv.parser;

import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.tabular.TableIfc;

import org.jplate.tabular.parser.TabularBuilderIfc;


/**
 
    Defines a CDV (colon delimited values) builder.  Methods will be called to
    build as CDV tokens are parsed.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/cdv/parser/CdvBuilderIfc.java $
    </pre>

    @param <V> The type of CDV data built.

*/
public interface CdvBuilderIfc <V> extends TabularBuilderIfc <V>
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
