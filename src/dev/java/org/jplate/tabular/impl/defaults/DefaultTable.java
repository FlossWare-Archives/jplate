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

import org.jplate.tabular.RecordFactoryIfc;
import org.jplate.tabular.RecordIfc;
import org.jplate.tabular.TableIfc;


/**
 
    Default implementation of a {@link org.jplate.tabular.TableIfc}.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultTable.java $
    </pre>

*/
public class DefaultTable implements TableIfc
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


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default table name.  Used when one is not supplied on construction.
     *
     */
    public static final String DEFAULT_TABLE_NAME = "Default Table";


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
        LogFactory.getLog ( DefaultTable.class );


    /**
     *
     * Used to create records.
     *
     */
    private RecordFactoryIfc _recordFactory;


    /**
     *
     * Holds all records that belong to a table.
     *
     */
    private final List <RecordIfc> _recordList;


    /**
     *
     * The name of the table.
     *
     */
    private final String _tableName;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the table name and uses <code>listFactory</code> to
     * create a {@link java.util.List} to hold records that are part of a table.
     *
     * @param listFactory Used to create a list to hold associated records.
     *
     * @param tableName The name of this table.
     *
     */
    public DefaultTable
        ( final RecordFactoryIfc recordFactory,
          final ListFactoryIfc <RecordIfc> listFactory, final String tableName )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultTable created - recordFactory = [" + recordFactory +
                "]  listFactory = [" + listFactory + "]  tableName = [" +
                tableName + "]"
            );
        }

        _recordFactory = recordFactory;
        _recordList    = listFactory.create ();
        _tableName     = tableName;
    }


    /**
     *
     * This constructor uses <code>listFactory</code> to create a
     * {@link java.util.List} to hold tables that are logically part of a repo.  The
     * repo name is set to {@link #DEFAULT_TABLE_NAME}
     *
     * @param listFactory Used to create a list to hold associated tables.
     *
     */
    public DefaultTable ( final ListFactoryIfc <RecordIfc> listFactory )
    {
        this ( new DefaultRecordFactory (), listFactory, DEFAULT_TABLE_NAME );
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
    public DefaultTable ( final String repoName )
    {
        this
        (
            new DefaultRecordFactory (),
            new UnsynchronizedLinkedListFactory <RecordIfc> (), repoName
        );
    }


    /**
     *
     * Default constructor.  Set the repo name to {@link #DEFAULT_TABLE_NAME} and
     * uses a
     * {@link org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory} as
     * the list factory.
     *
     */
    public DefaultTable ()
    {
        this
        (
            new DefaultRecordFactory (),
            new UnsynchronizedLinkedListFactory <RecordIfc> (), DEFAULT_TABLE_NAME
        );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * {@inheritDoc}
     *
     */
    public RecordIfc createRecord ()
    {
        final RecordIfc retVal = _recordFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String getTableName ()
    {
        return _tableName;
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
            _log.debug ( "Opening table" );
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
            _log.debug ( "Closing table" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void addRecord ( RecordIfc record ) throws AddException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Adding record [" + record + "]" );
        }

        _recordList.add ( record );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void removeRecords () throws RemoveException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Removing all records" );
        }

        _recordList.clear ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public boolean removeRecord ( RecordIfc record ) throws RemoveException
    {
        final boolean retVal = _recordList.remove ( record );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Removing record [" + record + "] = [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public List <RecordIfc> getRecords ()
    {
        final List <RecordIfc> retVal =
            Collections.unmodifiableList ( _recordList );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Return all records [" + retVal + "]" );
        }

        return retVal;
    }
}
