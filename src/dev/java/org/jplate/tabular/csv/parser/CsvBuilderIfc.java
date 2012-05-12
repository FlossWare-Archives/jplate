package org.jplate.tabular.csv.parser;

import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.tabular.TableIfc;

import org.jplate.tabular.parser.TabularBuilderIfc;


/**
 
    Defines a CSV (comma separated values) builder.  Methods will be called to build
    as CSV tokens are parsed.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/csv/parser/CsvBuilderIfc.java $
    </pre>

    @param <V> The type of CSV data built.

*/
public interface CsvBuilderIfc <V> extends TabularBuilderIfc <V>
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
     * This method is called when a quoted field is found.
     *
     * @param field A quoted field.
     *
     * @param line The line where the <code>field</code> starts.
     *
     * @param column The column number where the <code>field</code> starts.
     *
     * @throws JPlateBuildingException If there is a problem building
     *         <code>field</code>.
     *
     */
    public void buildQuotedField ( String field, int line, int column )
        throws JPlateBuildingException;
}
