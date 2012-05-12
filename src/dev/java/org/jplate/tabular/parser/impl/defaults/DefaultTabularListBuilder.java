package org.jplate.tabular.parser.impl.defaults;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;

import org.jplate.foundation.parser.JPlateBuilderIfc;
import org.jplate.foundation.parser.JPlateBuildingException;

import org.jplate.foundation.parser.impl.AbstractJPlateListBuilder;

import org.jplate.tabular.parser.TabularBuilderIfc;

import org.jplate.tabular.cdv.parser.CdvListBuilderIfc;
import org.jplate.tabular.csv.parser.CsvListBuilderIfc;
import org.jplate.tabular.tdv.parser.TdvListBuilderIfc;


/**
 
    Implementation of a {@link TabularBuilderIfc} that uses {@link List} to hold
    rows and fields.    Please note this class implements all of the builder
    interfaces defined in the Tabular project.  This is actually reasonable due to
    all builders being of type {@link TabularBuilderIfc}.  Therefore, as a simple
    solution, the aforementioned interfaces are implemented here.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/parser/impl/defaults/DefaultTabularListBuilder.java $
    </pre>

*/
public class DefaultTabularListBuilder
    extends    AbstractJPlateListBuilder <List <String>>
    implements CdvListBuilderIfc, CsvListBuilderIfc, TdvListBuilderIfc
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
     * Denotes an omitted field.
     *
     */
    public static final String OMITTED_FIELD = "";


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
        LogFactory.getLog ( DefaultTabularListBuilder.class );


    /**
     *
     * Factory to create.
     *
     */
    private final ListFactoryIfc <String> _listRecordFactory;


    /**
     *
     * Holds the current record.
     *
     */
    private List <String> _currentRecord;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the list factory used when creating results.
     *
     * @param listResultFactory The factory who creates lists to hold records.
     *
     * @param listRecordFactory The factory who creates lists for fields.
     *
     */
    public DefaultTabularListBuilder
        ( final ListFactoryIfc <List <String>> listResultFactory,
          final ListFactoryIfc <String> listRecordFactory )
    {
        super ( listResultFactory );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultTabularListBuilder created - listResultFactory = [" +
                listResultFactory + "]  listRecordFactory = [" +
                listRecordFactory + "]"
            );
        }

        _listRecordFactory = listRecordFactory;
    }


    /**
     *
     * Default constructor.  Uses {@link UnsynchronizedLinkedListFactory} to create
     * the list of records and fields.
     *
     */
    public DefaultTabularListBuilder ()
    {
        this
        (
            new UnsynchronizedLinkedListFactory <List <String>> (),
            new UnsynchronizedLinkedListFactory <String> ()
        );
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
    protected List <String> getCurrentRecord ()
    {
        return _currentRecord;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void buildEnd ( int line, int column ) throws JPlateBuildingException
    {
        if ( _currentRecord != null )
        {
            getActualResultList ().add ( _currentRecord );
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "End building reached [" + line + ", " + column + "]" );
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

        if ( _currentRecord != null )
        {
            getActualResultList ().add ( _currentRecord );
        }

        _currentRecord = _listRecordFactory.create (); 
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

        _currentRecord.add ( field );
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

        _currentRecord.add ( OMITTED_FIELD );
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
