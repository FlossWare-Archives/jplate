package org.jplate.foundation.parser;


import java.util.Map;

import org.jplate.foundation.gof.builder.BuildException;

/**

    This interface defines a JPlate builder of {@link Map}'s.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/JPlateMapBuilderIfc.java $
    </pre>

    @param <K> The key type built that will be stored in {@link Map}'s.
    @param <V> The value type built that will be stored in {@link Map}'s.

*/
public interface JPlateMapBuilderIfc <K, V> extends JPlateBuilderIfc <Map <K, V>>
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
