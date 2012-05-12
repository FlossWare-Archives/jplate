package org.jplate.foundation.parser;

import org.jplate.JPlateException;

import org.jplate.foundation.source.SourceIfc;

/**

    Thrown when there are problems parsing.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/JPlateParsingException.java $
    </pre>
 
*/
public class JPlateParsingException extends JPlateException
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
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------

    
    /**
     *
     * The source from which parsing is being performed.
     *
     */
    private final SourceIfc _source;


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
    public JPlateParsingException ()
    {
        _source = null;
    }


    /**
     *
     * This constructor sets the source where parsing failed.
     *
     * @param source ~he source from whence parsing is being performed.
     *
     */
    public JPlateParsingException ( final SourceIfc source )
    {
        _source = source;
    }


    /**
     *
     * This constructor sets the message.
     *
     * @param msg A message about why self was raised.
     *
     */
    public JPlateParsingException ( final String msg )
    {
        super ( msg );

        _source = null;
    }


    /**
     *
     * This constructor sets the message.
     *
     * @param msg A message about why self was raised.
     *
     * @param source The source from whence parsing is being performed.
     *
     */
    public JPlateParsingException ( final String msg, final SourceIfc source )
    {
        super ( msg );

        _source = source;
    }


    /**
     *
     * This constructor sets the root cause and the node that caused self to be
     * raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     */
    public JPlateParsingException ( final Throwable rootCause )
    {
        super ( rootCause );

        _source = null;
    }


    /**
     *
     * This constructor sets the root cause and the node that caused self to be
     * raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param source The source from whence parsing is being performed.
     *
     */
    public JPlateParsingException
        ( final Throwable rootCause, final SourceIfc source )
    {
        super ( rootCause );

        _source = source;
    }


    /**
     *
     * This constructor sets the message and root cause.
     *
     * @param msg A message about why self was raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     */
    public JPlateParsingException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );

        _source = null;
    }


    /**
     *
     * This constructor sets the message and root cause.
     *
     * @param msg A message about why self was raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param source The source from whence parsing is being performed.
     *
     */
    public JPlateParsingException
        ( final String msg, final Throwable rootCause, final SourceIfc source  )
    {
        super ( msg, rootCause );

        _source = source;
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Return the source from whence parsing was performed and failed.
     *
     * @return The source from whence parsnig was performed and failed, or null
     *         if not set upon construction.
     *
     */
    public SourceIfc getSource ()
    {
        return _source;
    }
}
