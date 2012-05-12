package org.jplate.foundation.parser;

import org.jplate.foundation.gof.builder.BuilderIfc;
import org.jplate.foundation.gof.builder.BuildException;

/**

    This interface defines a builder.  Essentially methods are called on
    implementations of this interface as items have been parsed.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/JPlateBuilderIfc.java $
    </pre>

    @param <V> The value being built.

*/
public interface JPlateBuilderIfc <V> extends BuilderIfc <V>
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
     * This method is called when parsing is to begin.
     *
     * @throws JPlateBuilderException If parsing should not proceed.
     *
     */
    public void buildStart () throws JPlateBuildingException;


    /**
     *
     * This method is called when parsing has completed.
     *
     * @param line The line where parsing ended.
     *
     * @param column The column number where parsing ended.
     *
     * @throws JPlateBuilderException If there is a problem with parsing being
     *         completed.
     *
     */
    public void buildEnd ( int line, int column ) throws JPlateBuildingException;
}
