package org.jplate.tabular.csv.parser;

import org.jplate.tabular.parser.TabularBuilderFactoryIfc;

/**
 
    Factory for creating implementations of CsvBuilderIfc's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/csv/parser/CsvBuilderFactoryIfc.java $
    </pre>

    @param <V> The CDV builder type created.

*/
public interface CsvBuilderFactoryIfc <V extends CsvBuilderIfc <?>>
    extends TabularBuilderFactoryIfc <V>
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
