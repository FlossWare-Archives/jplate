package org.jplate.tabular;


import java.util.List;

import org.jplate.foundation.exception.AddException;
import org.jplate.foundation.exception.CloseException;
import org.jplate.foundation.exception.OpenException;
import org.jplate.foundation.exception.RemoveException;

/**
 
    Defines the concept of a table.  A table is a collection of RecordIfc's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/TableIfc.java $
    </pre>

*/
public interface TableIfc 
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


    public RecordIfc createRecord ();

    /**
     *
     * Return the name of the table.
     *
     * @return The name of the table.
     *
     */
    public String getTableName ();


    /**
     *
     * This method will open an existing table.
     *
     * @throws OpenException If a problem arose opening the table.
     *
     */
    public void open () throws OpenException;


    /**
     *
     * This method will close a table.
     *
     * @throws CloseException If a problem arose closing the table.
     *
     */
    public void close () throws CloseException;


    /**
     *
     * Add a record.
     *
     * @param record The record to add.
     *
     * @throws AddException if any issues arise adding <code>record</code>.
     *
     */
    public void addRecord ( RecordIfc record ) throws AddException;


    /**
     *
     * This method will force the removal of all records.
     *
     * @throws RemoveException if a problem arose removing all records.
     *
     */
    public void removeRecords () throws RemoveException;


    /**
     *
     * Remove <code>record</code>.
     *
     * @param record The record to remove.
     *
     * @return true if successful or false if not.
     *
     * @throws RemoveException if any issues arise removing <code>record</code>.
     *
     */
    public boolean removeRecord ( RecordIfc record ) throws RemoveException;


    /**
     *
     * Return the collection of records.
     *
     * @return the collection of records.
     *
     */
    public List <RecordIfc> getRecords ();
}
