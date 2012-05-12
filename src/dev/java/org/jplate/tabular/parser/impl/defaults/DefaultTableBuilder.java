package org.jplate.tabular.parser.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.exception.AddException;

import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.tabular.FieldIfc;
import org.jplate.tabular.RecordIfc;
import org.jplate.tabular.TableFactoryIfc;
import org.jplate.tabular.TableFactoryIfc;
import org.jplate.tabular.TableIfc;

import org.jplate.tabular.impl.defaults.DefaultTableFactory;

import org.jplate.tabular.cdv.parser.CdvTableBuilderIfc;

import org.jplate.tabular.csv.parser.CsvTableBuilderIfc;

import org.jplate.tabular.tdv.parser.TdvTableBuilderIfc;


/**
 
    Default implementation of a tabular builder.  Please note this class implements
    all of the builder interfaces defined in the Tabular project.  This is actually
    reasonable due to all builders being of type
    {@link org.jplate.tabular.parser.TabularBuilderIfc}.  Therefore, as a simple
    solution, the aforementioned interfaces are implemented here.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/parser/impl/defaults/DefaultTableBuilder.java $
    </pre>

*/
public class DefaultTableBuilder
    implements CdvTableBuilderIfc, CsvTableBuilderIfc, TdvTableBuilderIfc
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
        LogFactory.getLog ( DefaultTableBuilder.class );


    /**
     *
     * Factory to create tables.
     *
     */
    private final TableFactoryIfc _tableFactory;


    /**
     *
     * Holds the build result.
     *
     */
    private TableIfc _tableResult;


    /**
     *
     * Holds the current record.
     *
     */
    private RecordIfc _currentRecord;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the table factory used when creating results.
     *
     * @param tableFactory The factory who can create tables.
     *
     */
    public DefaultTableBuilder ( final TableFactoryIfc tableFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultTableBuilder created - tableFactory = [" +
                tableFactory + "]"
            );
        }

        _tableFactory = tableFactory;
    }


    /**
     *
     * Default constructor.
     *
     */
    public DefaultTableBuilder ()
    {
        this ( new DefaultTableFactory () );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Return the current record.
     *
     * @return the current record.
     *
     */
    protected RecordIfc getCurrentRecord ()
    {
        return _currentRecord;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public TableIfc getResult ()
    {
        return _tableResult;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void reset ()
    {
        _tableResult = _tableFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New table result created [" + _tableResult + "]" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildStart () throws JPlateBuildingException
    {
        _tableResult = _tableFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Starting build _tableResult = [" + _tableResult + "]" );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildEnd ( int line, int column ) throws JPlateBuildingException
    {
        try
        {
            if ( _currentRecord != null )
            {
                _tableResult.addRecord ( _currentRecord );
            }

            if ( _log.isDebugEnabled () )
            {
                _log.debug
                (
                    "End building reached [" + line + ", " + column + "]"
                );
            }
        }

        catch ( final AddException addException )
        {
            final JPlateBuildingException jplateBuildingException =
                new JPlateBuildingException ( addException );

            _log.error ( jplateBuildingException );

            throw jplateBuildingException;
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildRecord ( final int line ) throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New record reached [" + line + "]  _currentRecord = [" +
                _currentRecord + "]"
            );
        }

        try
        {
            if ( _currentRecord != null )
            {
                _tableResult.addRecord ( _currentRecord );
            }

            _currentRecord = _tableResult.createRecord (); 
        }

        catch ( final AddException addException )
        {
            final JPlateBuildingException jplateBuildingException =
                new JPlateBuildingException ( addException );

            _log.error ( jplateBuildingException );

            throw jplateBuildingException;
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildField ( final String field, final int line, final int column )
        throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New field reached [" + line + ", " + column + "]   field = [" +
                field + "]"
            );
        }

        try
        {
            final FieldIfc currentField = _currentRecord.createField ();

            _currentRecord.addField ( currentField );
        }

        catch ( final AddException addException )
        {
            final JPlateBuildingException jplateBuildingException =
                new JPlateBuildingException ( addException );

            _log.error ( jplateBuildingException );

            throw jplateBuildingException;
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildOmittedField ( final int line, final int column )
        throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New omitted field reached [" + line + ", " + column + "]" 
            );
        }

        try
        {
            final FieldIfc currentField = _currentRecord.createField ();

            _currentRecord.addField ( currentField );
        }

        catch ( final AddException addException )
        {
            final JPlateBuildingException jplateBuildingException =
                new JPlateBuildingException ( addException );

            _log.error ( jplateBuildingException );

            throw jplateBuildingException;
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildQuotedField
        ( final String field, final int line, final int column )
            throws JPlateBuildingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New quoted field reached [" + line + ", " + column + "]   " +
                "field = [" + field + "]"
            );
        }

        buildField ( field, line, column );
    }
}
