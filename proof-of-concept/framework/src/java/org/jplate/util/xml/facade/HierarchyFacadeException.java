package org.jplate.util.xml.facade;

import org.jplate.util.xml.XMLException;

/**
 *
 * Exception raised when hierarchy facade problems arise.
 *
 */
public class HierarchyFacadeException extends XMLException
{
    /**
     *
     * Default constructor.
     *
     */
    public HierarchyFacadeException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public HierarchyFacadeException ( final String msg )
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
    public HierarchyFacadeException ( final Throwable rootCause )
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
    public HierarchyFacadeException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
