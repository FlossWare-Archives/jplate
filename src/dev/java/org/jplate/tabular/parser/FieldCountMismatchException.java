package org.jplate.tabular.parser;

import org.jplate.foundation.parser.JPlateBuildingException;


/**

  Thrown when the field count is greater than the maximum number of fields.

  <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/tabular/parser/FieldCountMismatchException.java $
    </pre>

 */
public class FieldCountMismatchException extends JPlateBuildingException
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

    private static String computeMsg ( final int maxFields, final int fieldNumber )
    {
        return "maxFields [" + maxFields + "] != fieldNumber [" + fieldNumber + "]";
    }


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

    private int _maxFields;

    private int _fieldNumber;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor.
     *
     */
    public FieldCountMismatchException ()
    {
    }

    public FieldCountMismatchException
        ( final int maxFields, final int fieldNumber )
    {
        super ( computeMsg ( maxFields, fieldNumber ) );

        _maxFields   = maxFields;
        _fieldNumber = fieldNumber;
    }

    public FieldCountMismatchException
        ( final String msg, final int maxFields, final int fieldNumber )
    {
        super ( msg );

        _maxFields   = maxFields;
        _fieldNumber = fieldNumber;
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public FieldCountMismatchException ( final String msg )
    {
        super ( msg );
    }

    public FieldCountMismatchException
        ( final Throwable rootCause, final int maxFields, final int fieldNumber )
    {
        super ( computeMsg ( maxFields, fieldNumber ) );

        _maxFields   = maxFields;
        _fieldNumber = fieldNumber;
    }

    /**
     *
     * This constructor sets the root cause and the node that caused self to be
     * raised.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     */
    public FieldCountMismatchException ( final Throwable rootCause )
    {
        super ( rootCause );
    }

    public FieldCountMismatchException
        ( final String msg, final Throwable rootCause, final int maxFields,
          final int fieldNumber )
    {
        super ( msg, rootCause );

        _maxFields   = maxFields;
        _fieldNumber = fieldNumber;
    }

    /**
     *
     * This constructor sets the message and root cause.
     *
     * @param msg represents a message about why self was raised.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     */
    public FieldCountMismatchException
        ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns the maximum number of fields when self was raised.
     *
     * @return the maximum number of fields.
     *
     */
    public int getMaxFields ()
    {
        return _maxFields;
    }


    /**
     *
     * Returns the current field number when self was raised.
     *
     * @return the urrent field number.
     *
     */
    public int getFieldNumber ()
    {
        return _fieldNumber;
    }
}

