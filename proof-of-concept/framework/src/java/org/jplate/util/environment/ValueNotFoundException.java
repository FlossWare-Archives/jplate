package org.jplate.util.environment;

import org.jplate.JPlateException;

/**
 *
 * This exception is raised when a value cannot be found in an environment...
 *
 */
public class ValueNotFoundException extends JPlateException
{
    /**
     *
     * Default constructor.
     *
     */
    public ValueNotFoundException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public ValueNotFoundException ( final String msg )
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
    public ValueNotFoundException ( final Throwable rootCause )
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
    public ValueNotFoundException
        ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
