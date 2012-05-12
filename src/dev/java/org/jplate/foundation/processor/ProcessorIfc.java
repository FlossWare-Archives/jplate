package org.jplate.foundation.processor;


/**

    Defines an object who can process a value and potentially return a new version
    of said object.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/processor/ProcessorIfc.java $
    </pre>

    @param <V> The object to be processed.

*/
public interface ProcessorIfc <V>
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
     * Requests <code>toProcess</code> to be processed.
     *
     * @param toProcess The object to process.
     *
     * @return The processed object.
     *
     * @throws ProcessException if any problem arises processing
     *         <code>toProcess</code>.
     *
     */
    public V process ( V toProcess ) throws ProcessException;
}
