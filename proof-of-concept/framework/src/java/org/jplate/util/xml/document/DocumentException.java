package org.jplate.util.xml.document;

import org.jplate.util.xml.XMLException;

/**
 *
 * Exception raised when document problems arise.
 *
 */
public class DocumentException extends XMLException
{
    /**
     *
     * Default constructor.
     *
     */
    public DocumentException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public DocumentException ( final String msg )
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
    public DocumentException ( final Throwable rootCause )
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
    public DocumentException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
