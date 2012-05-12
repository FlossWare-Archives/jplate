package org.jplate.util;

import org.jplate.JPlateException;

/**
 *
 * Base exception for all util errors...
 *
 */
public class UtilException extends JPlateException
{
    /**
     *
     * Default constructor.
     *
     */
    public UtilException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public UtilException ( final String msg )
    {
        super ( msg );
    }

    /**
     *
     * This constructor sets the root cause.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     */
    public UtilException ( final Throwable rootCause )
    {
        super ( rootCause );
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
    public UtilException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
