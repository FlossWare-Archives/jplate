package org.jplate.tabular;


import java.util.List;

import org.jplate.foundation.exception.AddException;
import org.jplate.foundation.exception.CloseException;
import org.jplate.foundation.exception.OpenException;
import org.jplate.foundation.exception.RemoveException;


/**
 
    Defines the concept of a repo.  A repo is a collection of TableIfc's.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/RepoIfc.java $
    </pre>

*/
public interface RepoIfc
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


    public TableIfc createTable ();

    /**
     *
     * Return the repo name,
     *
     * @return The repo name.
     *
     */
    public String getRepoName ();


    /**
     *
     * This method will open an existing repo.
     *
     * @throws OpenException If a problem arose opening the repo.
     *
     */
    public void open () throws OpenException;


    /**
     *
     * This method will close a repo.
     *
     * @throws CloseException If a problem arose closing the repo.
     *
     */
    public void close () throws CloseException;


    /**
     *
     * Add <code>table</code>.
     *
     * @param table The table to Add.
     *
     * @throws AddException if any issues arise adding <code>table</code>.
     *
     */
    public void addTable ( TableIfc table ) throws AddException;


    /**
     *
     * This method will force the removal of all tables.
     *
     * @throws RemoveException if a problem arose removing all tables.
     *
     */
    public void removeTables () throws RemoveException;


    /**
     *
     * Remove <code>table</code>.
     *
     * @param table The table to remove.
     *
     * @return true if successful or false if not.
     *
     * @throws RemoveException if any issues arise removing <code>table</code>.
     *
     */
    public boolean removeTable ( TableIfc table ) throws RemoveException;


    /**
     *
     * Return the collection of tables.
     *
     * @return the collection of tables.
     *
     */
    public List <TableIfc> getTables ();
}
