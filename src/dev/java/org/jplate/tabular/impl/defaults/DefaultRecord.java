package org.jplate.tabular.impl.defaults;


import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.exception.AddException;
import org.jplate.foundation.exception.RemoveException;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;

import org.jplate.tabular.FieldFactoryIfc;
import org.jplate.tabular.FieldIfc;
import org.jplate.tabular.RecordIfc;


/**
 
    Default implementation of {@link org.jplate.tabular.RecordIfc}.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/impl/defaults/DefaultRecord.java $
    </pre>

*/
public class DefaultRecord implements RecordIfc
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
        LogFactory.getLog ( DefaultRecord.class );


    /**
     *
     * Used to create fields.
     *
     */
    private final FieldFactoryIfc _fieldFactory;

    /**
     *
     * Holds all fields that belong to a record.
     *
     */
    private final List <FieldIfc> _fieldList;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the <code>listFactory</code> to create a
     * {@link java.util.List} to hold fields that are logically part of
     * a record.
     *
     * @param listFactory Used to create a list to hold associated fields.
     *
     */
    public DefaultRecord
        ( final FieldFactoryIfc fieldFactory,
          final ListFactoryIfc <FieldIfc> listFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New DefaultRecord created - fieldFactory = [" + fieldFactory +
                "]  listFactory = [" + listFactory + "]"
            );
        }

        _fieldFactory = fieldFactory;
        _fieldList    = listFactory.create ();
    }


    /**
     *
     * This constructor sets the <code>listFactory</code> to create a
     * {@link java.util.List} to hold fields that are logically part of
     * a record.
     *
     * @param fieldFactory Used to create fields.
     *
     */
    public DefaultRecord ( final FieldFactoryIfc fieldFactory )
    {
        this ( fieldFactory, new UnsynchronizedLinkedListFactory <FieldIfc> () );
    }


    /**
     *
     * This constructor sets the <code>listFactory</code> to create a
     * {@link java.util.List} to hold fields that are logically part of
     * a record.
     *
     * @param listFactory Used to create a list to hold associated fields.
     *
     */
    public DefaultRecord ( final ListFactoryIfc <FieldIfc> listFactory )
    {
        this ( new DefaultFieldFactory (), listFactory );
    }


    /**
     *
     * Default constructor that uses a
     * {@link org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory} as
     * the list factory.
     *
     */
    public DefaultRecord ()
    {
        this
        (
            new DefaultFieldFactory (), 
            new UnsynchronizedLinkedListFactory <FieldIfc> ()
        );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------    


    public FieldIfc createField ()
    {
        final FieldIfc retVal = _fieldFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created field [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void removeFields () throws RemoveException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Removing all fields" );
        }

        _fieldList.clear ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public boolean removeField ( final FieldIfc field ) throws RemoveException
    {
        final boolean retVal = _fieldList.remove ( field );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Removing field [" + field + "] = [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void addField ( final FieldIfc field ) throws AddException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Adding field [" + field + "]" );
        }

        _fieldList.add ( field );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public List <FieldIfc> getFields ()
    {
        final List <FieldIfc> retVal = Collections.unmodifiableList ( _fieldList );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning all fields [" + retVal + "]" );
        }

        return retVal;
    }
}
