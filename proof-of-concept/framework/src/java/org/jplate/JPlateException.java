package org.jplate;

/**
 *
 * Base exception for all JPlate errors...
 *
 */
public class JPlateException extends Exception
{
    /**
     *
     * Default constructor.
     *
     */
    public JPlateException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public JPlateException ( final String msg )
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
    public JPlateException ( final Throwable rootCause )
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
    public JPlateException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
