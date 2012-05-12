package org.jplate.tmplate;

import org.jplate.JPlateException;

/**
 *
 * This exception is the base class of all template exceptions.
 *
 */
public class TemplateException extends JPlateException
{
    /**
     *
     * This is the beginning line number where the exception occurred.
     *
     */
    private final int _beginLine;

    /**
     *
     * This is the beginning column number where the exception occurred.
     *
     */
    private final int _beginColumn;

    /**
     *
     * This is the ending line number where the exception occurred.
     *
     */
    private final int _endLine;

    /**
     *
     * This is the ending column number where the exception occurred.
     *
     */
    private final int _endColumn;

    /**
     *
     * Default constructor.
     *
     */
    public TemplateException ()
    {
        _beginLine   = 0;
        _beginColumn = 0;
        _endLine     = 0;
        _endColumn   = 0;
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
    public TemplateException
        ( final int beginLine, final int beginColumn, final int endLine,
          final int endColumn )
    {
        super
        (
            "(" + beginLine + ", " + beginColumn + ") - (" + endLine + ", " +
            endColumn + ")"
        );

        _beginLine   = beginLine;
        _beginColumn = beginColumn;
        _endLine     = endLine;
        _endColumn   = endColumn;
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg represents a message about why self was raised.
     *
     */
    public TemplateException ( final String msg )
    {
        super ( msg );

        _beginLine   = 0;
        _beginColumn = 0;
        _endLine     = 0;
        _endColumn   = 0;
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
    public TemplateException
        ( final String msg, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
    {
        super
        (
            msg + "  (" + beginLine + ", " + beginColumn + ") - (" + endLine +
            ", " + endColumn + ")"
        );

        _beginLine   = beginLine;
        _beginColumn = beginColumn;
        _endLine     = endLine;
        _endColumn   = endColumn;
    }

    /**
     *
     * This constructor sets the root cause.
     *
     * @param rootCause represents the exception that caused self to be raised.
     *
     */
    public TemplateException ( final Throwable rootCause )
    {
        super ( rootCause );

        _beginLine   = 0;
        _beginColumn = 0;
        _endLine     = 0;
        _endColumn   = 0;
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
    public TemplateException
        ( final Throwable rootCause, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
    {
        super
        (
            "  (" + beginLine + ", " + beginColumn + ") - (" + endLine +
            ", " + endColumn + ")", rootCause
        );

        _beginLine   = beginLine;
        _beginColumn = beginColumn;
        _endLine     = endLine;
        _endColumn   = endColumn;
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
    public TemplateException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );

        _beginLine   = 0;
        _beginColumn = 0;
        _endLine     = 0;
        _endColumn   = 0;
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
    public TemplateException
        ( final String msg, final Throwable rootCause, final int beginLine,
          final int beginColumn, final int endLine, final int endColumn )
    {
        super
        (
            msg + "  (" + beginLine + ", " + beginColumn + ") - (" + endLine +
            ", " + endColumn + ")", rootCause
        );

        _beginLine   = beginLine;
        _beginColumn = beginColumn;
        _endLine     = endLine;
        _endColumn   = endColumn;
    }

    /**
     *
     * This method will return the beginning line number where the exception
     * occurred.
     *
     * @return the beginning line number where the exception occurred.
     *
     */
    public int getBeginLine ()
    {
        return _beginLine;
    }

    /**
     *
     * This method will return the beginning column number where the exception
     * occurred.
     *
     * @return the beginning column number where the exception occurred.
     *
     */
    public int getBeginColumn ()
    {
        return _beginColumn;
    }

    /**
     *
     * This method will return the ending line number where the exception
     * occurred.
     *
     * @return the ending line number where the exception occurred.
     *
     */
    public int getEndLine ()
    {
        return _endLine;
    }

    /**
     *
     * This method will return the ending column number where the exception
     * occurred.
     *
     * @return the ending column number where the exception occurred.
     *
     */
    public int getEndColumn ()
    {
        return _endColumn;
    }
}
