package org.jplate.tabular.impl.defaults;


import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.exception.AddException;
import org.jplate.foundation.exception.CloseException;
import org.jplate.foundation.exception.OpenException;
import org.jplate.foundation.exception.RemoveException;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;

import org.jplate.tabular.RepoIfc;
import org.jplate.tabular.TableFactoryIfc;
import org.jplate.tabular.TableIfc;


/**
 
    Default repo implementation.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultRepo.java $
    </pre>

*/
public class DefaultRepo implements RepoIfc
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
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


    /**
     *
     * Default repo name.  Used when one is not supplied on construction.
     *
     */
    public static final String DEFAULT_REPO_NAME = "Default Repo";


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( DefaultRepo.class );


    /**
     *
     * Used to create tables.
     *
     */
    private TableFactoryIfc _tableFactory;


    /**
     *
     * Holds all tables that belong to a repo.
     *
     */
    private final List <TableIfc> _tableList;


    /**
     *
     * The name of the repo.
     *
     */
    private final String _repoName;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the repo name and uses <code>listFactory</code> to
     * create a {@link java.util.List} to hold tables that are logically part of
     * a repo.
     *
     * @param listFactory Used to create a list to hold associated tables.
     *
     * @param repoName The name of this repo.
     *
     */
    public DefaultRepo
        ( final TableFactoryIfc tableFactory,
          final ListFactoryIfc <TableIfc> listFactory, final String repoName )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultRepo created - tableFactory = [" + tableFactory +
                "]  listFactory = [" + listFactory + "]  repoName = [" +
                repoName + "]"
            );
        }

        _tableFactory = tableFactory;
        _tableList    = listFactory.create ();
        _repoName     = repoName;
    }


    /**
     *
     * This constructor uses <code>listFactory</code> to create a
     * {@link java.util.List} to hold tables that are logically part of a repo.  The
     * repo name is set to {@link #DEFAULT_REPO_NAME}
     *
     * @param listFactory Used to create a list to hold associated tables.
     *
     */
    public DefaultRepo ( final ListFactoryIfc <TableIfc> listFactory )
    {
        this ( new DefaultTableFactory (), listFactory, DEFAULT_REPO_NAME );
    }


    /**
     *
     * This constructor sets the repo name and uses a
     * {@link org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory} as
     * the list factory.
     *
     * @param repoName The name of this repo.
     *
     */
    public DefaultRepo ( final String repoName )
    {
        this
        (
            new DefaultTableFactory (), 
            new UnsynchronizedLinkedListFactory <TableIfc> (), repoName
        );
    }


    /**
     *
     * Default constructor.  Set the repo name to {@link #DEFAULT_REPO_NAME} and
     * uses a
     * {@link org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory} as
     * the list factory.
     *
     */
    public DefaultRepo ()
    {
        this
        (
            new DefaultTableFactory (),
            new UnsynchronizedLinkedListFactory <TableIfc> (), DEFAULT_REPO_NAME
        );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------

    public TableIfc createTable ()
    {
        final TableIfc retVal = _tableFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created table [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String getRepoName ()
    {
        return _repoName;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void open () throws OpenException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Opening repo" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void close () throws CloseException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Closing repo" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void addTable ( final TableIfc table ) throws AddException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Adding table [" + table + "]" );
        }

        _tableList.add ( table );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void removeTables () throws RemoveException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Clearing tables" );
        }

        _tableList.clear ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public boolean removeTable ( final TableIfc table ) throws RemoveException
    {
        final boolean retVal = _tableList.remove ( table );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Removing table [" + table + "] = [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public List <TableIfc> getTables ()
    {
        final List <TableIfc> retVal = Collections.unmodifiableList ( _tableList );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning tables [" + retVal + "]" );
        }

        return retVal;
    }
}
