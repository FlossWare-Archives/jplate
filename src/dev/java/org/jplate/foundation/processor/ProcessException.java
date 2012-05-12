package org.jplate.foundation.processor;

import org.jplate.foundation.FoundationException;


/**

    This is the base class of all processor exceptions.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/processor/ProcessException.java $
    </pre>

*/
public class ProcessException extends FoundationException
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
     * The object processed that caused self to be raised.
     *
     */
    private final Object _processed;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException If this constructor is called.
     *
     */
    protected ProcessException ()
    {
        throw new UnsupportedOperationException ();
    }


    /**
     *
     * This constructor sets the processed that caused self to be raised.
     *
     * @param processed The processed object that caused self to be raised.
     *
     */
    public ProcessException ( final Object processed )
    {
        _processed = processed;
    }


    /**
     *
     * This constructor sets the message and the object processed that caused self
     * to be raised.
     *
     * @param msg  A message about why self was raised.
     *
     * @param processed The object processed that caused self to be raised.
     *
     */
    public ProcessException ( final String msg, final Object processed )
    {
        super ( msg );

        _processed = processed;
    }


    /**
     *
     * This constructor sets the root cause and the object processed that caused
     * self to be raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param processed The object processed that caused self to be raised.
     *
     */
    public ProcessException
        ( final Throwable rootCause, final Object processed )
    {
        super ( rootCause );

        _processed = processed;
    }


    /**
     *
     * This constructor sets the message, root cause and object processed that
     * caused self to be raised.
     *
     * @param msg       A message about why self was raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param processed The object processed that caused self to be raised.
     *
     */
    public ProcessException
        ( final String msg, final Throwable rootCause,
          final Object processed )
    {
        super ( msg, rootCause );

        _processed = processed;
    }


    /**
     *
     * This method will return the object processed that caused self to be raised.
     *
     * @return The object processed that caused self to be raised.
     *
     */
    public Object getProcessed ()
    {
        return _processed;
    }
}
