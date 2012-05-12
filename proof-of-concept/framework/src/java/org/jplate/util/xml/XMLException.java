package org.jplate.util.xml;

import org.jplate.util.UtilException;

/**
 *
 * Exception raised when XML problems arise.
 *
 */
public class XMLException extends UtilException
{
    /**
     *
     * Default constructor.
     *
     */
    public XMLException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public XMLException ( final String msg )
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
    public XMLException ( final Throwable rootCause )
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
    public XMLException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
