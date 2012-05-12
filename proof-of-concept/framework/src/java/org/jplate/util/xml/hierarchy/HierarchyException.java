package org.jplate.util.xml.hierarchy;

import org.jplate.util.xml.XMLException;

/**
 *
 * Exception raised when hierarchy problems arise.
 *
 */
public class HierarchyException extends XMLException
{
    /**
     *
     * Default constructor.
     *
     */
    public HierarchyException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public HierarchyException ( final String msg )
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
    public HierarchyException ( final Throwable rootCause )
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
    public HierarchyException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
