package org.jplate.tabular.parser;

import org.jplate.foundation.parser.JPlateBuilderIfc;
import org.jplate.foundation.parser.JPlateBuildingException;


/**
 
    A builder of tabular data.  Called when fields and records are to be built.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/parser/TabularBuilderIfc.java $
    </pre>

    @param <V> The tabular value being built.

*/
public interface TabularBuilderIfc <V> extends JPlateBuilderIfc <V>
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
     * This method is called when a record is to be built.  No column value is
     * presented for any line, the starting column will always be 1.
     *
     * @param line The line number where the record was found.
     *
     * @throws JPlateBuildingException If there is a problem building the record.
     *
     */
    public void buildRecord ( int line ) throws JPlateBuildingException;


    /**
     *
     * This method is called when a field is encountered.
     *
     * @param field The data in the field.
     *
     * @param line The line where <code>field</code> starts.
     *
     * @param column The column number where <code>field</code> starts.
     *
     * @throws JPlateBuildingException If there is a problem building the field.
     *
     */
    public void buildField ( String field, int line, int column )
        throws JPlateBuildingException;


    /**
     *
     * This method is called when a field is omitted.
     *
     * @param line represents the line where the omitted field starts.
     *
     * @param column represents the column where the omitted field starts.
     *
     * @throws JPlateBuildingException if there is a problem building the omitted
     *         field.
     *
     */
    public void buildOmittedField ( int line, int column )
        throws JPlateBuildingException;
}
