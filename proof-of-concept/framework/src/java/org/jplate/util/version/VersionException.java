package org.jplate.util.version;

import org.jplate.JPlateException;

/**
 *
 * This exception is raised if there are any problems creating an implementation
 * of VersionIfc.
 *
 */
public class VersionException extends JPlateException
{
    /**
     *
     * Default constructor.
     *
     */
    public VersionException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public VersionException ( final String msg )
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
    public VersionException ( final Throwable rootCause )
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
    public VersionException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }
}
