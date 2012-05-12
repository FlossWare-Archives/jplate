package org.jplate.tabular;


import java.util.List;

import org.jplate.foundation.exception.AddException;
import org.jplate.foundation.exception.RemoveException;

/**
 
    Defines the concept of a record.  A record is a collection of FieldIfc's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/RecordIfc.java $
    </pre>
    
*/
public interface RecordIfc
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

    public FieldIfc createField ();


    /**
     *
     * Removes all fields from the record.
     *
     * @throws RemoveException if any issues arise removing <code>field</code>.
     *
     */
    public void removeFields () throws RemoveException;


    /**
     *
     * Remove <code>field</code>.
     *
     * @param field The field to remove.
     *
     * @return true if <code>field</code> was removed or false if not.
     *
     * @throws RemoveException if any issues arise removing <code>field</code>.
     *
     */
    public boolean removeField ( FieldIfc field ) throws RemoveException;


    /**
     *
     * Create a field.
     *
     * @param field tThe field to add.
     *
     * @throws AddException if any issues arise adding a field.
     *
     */
    public void addField ( FieldIfc field ) throws AddException;


    /**
     *
     * Return the collection of fields.
     *
     * @return the collection of fields.
     *
     */
    public List <FieldIfc> getFields ();
}
