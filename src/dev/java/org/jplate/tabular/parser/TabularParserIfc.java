package org.jplate.tabular.parser;

import org.jplate.foundation.parser.JPlateParserIfc;



/**
 
    Defines a parser for tabular data.  Table data is data organized in records
    and columns.  Each record has a delimiter as do columns - typically but both
    are not the same delimiters.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/parser/TabularParserIfc.java $
    </pre>

    @param <B> A builder who can build tabular values.

*/
public interface TabularParserIfc <B extends TabularBuilderIfc <?>>
    extends JPlateParserIfc <B>
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
