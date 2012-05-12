package org.jplate.tmplate.directive;

import org.jplate.tmplate.TemplateException;

/**
 *
 * This exception is raised when an unknown directive has been expressed...
 *
 */
public class UnknownNamedDirectiveException extends TemplateException
{
    /**
     *
     * Default constructor.
     *
     */
    public UnknownNamedDirectiveException ()
    {
    }

    /**
     *
     * This constructor sets the position of where the exception occurred.
     *
     * @param beginLine represents the starting line number.
     *
     * @param beginColumn represents the starting column number.
     *
     * @param endLine represents the ending line number.
     *
     * @param endColumn represents the ending column number.
     *
     * @param length represents the length of the error.
     *
     */
    public UnknownNamedDirectiveException
        ( final int beginLine, final int beginColumn, final int endLine,
          final int endColumn )
    {
        super ( beginLine, beginColumn, endLine, endColumn );
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public UnknownNamedDirectiveException ( final String msg )
    {
        super ( msg );
    }

    /**
     *
     * This constructor sets the message and position of where the exception
     * occurred.
     *
     * @param msg represents a message about why self was raised.
     *
     * @param beginLine represents the starting line number.
     *
     * @param beginColumn represents the starting column number.
     *
     * @param endLine represents the ending line number.
     *
     * @param endColumn represents the ending column number.
     *
     * @param length represents the length of the error.
     *
     */
    public UnknownNamedDirectiveException
        ( final String msg, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
    {
        super ( msg, beginLine, beginColumn, endLine, endColumn );
    }

    /**
     *
     * This constructor sets the root cause.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     */
    public UnknownNamedDirectiveException ( final Throwable rootCause )
    {
        super ( rootCause );
    }

    /**
     *
     * This constructor sets the root cause and position where the exception
     * occurred.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     * @param beginLine represents the starting line number.
     *
     * @param beginColumn represents the starting column number.
     *
     * @param endLine represents the ending line number.
     *
     * @param endColumn represents the ending column number.
     *
     * @param length represents the length of the error.
     *
     */
    public UnknownNamedDirectiveException
        ( final Throwable rootCause, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
    {
        super ( rootCause, beginLine, beginColumn, endLine, endColumn );
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
    public UnknownNamedDirectiveException
        ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }

    /**
     *
     * This constructor sets the message, root cause and position where the
     * exception occurred.
     *
     * @param msg represents a message about why self was raised.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     * @param beginLine represents the starting line number.
     *
     * @param beginColumn represents the starting column number.
     *
     * @param endLine represents the ending line number.
     *
     * @param endColumn represents the ending column number.
     *
     * @param length represents the length of the error.
     *
     */
    public UnknownNamedDirectiveException
        ( final String msg, final Throwable rootCause, final int beginLine,
          final int beginColumn, final int endLine, final int endColumn )
    {
        super ( msg, rootCause, beginLine, beginColumn, endLine, endColumn );
    }
}
