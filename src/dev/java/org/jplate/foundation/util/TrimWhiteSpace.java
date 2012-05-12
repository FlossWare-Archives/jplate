package org.jplate.foundation.util;

/**

    This class can trim white space from an entire string.  By default, white space
    is defined as newline, tab, carriage return and space.  You may also supply user
    definable white space for trimming.

    <p/><a  name = "Examples"/>
    Consider the following examples:<br/>

    <ul>
        <li>
            Default white space trim<br/>

            Calling <code>trimWhiteSpace ( "Hello, my name is\n\tScot" )</code>
            will yeild <code>Hello,mynameisScot</code>
        </li>

        <br/>

        <li>
            User defined trim <br/>

            Calling <code>trimWhiteSpace ( "Hello, my name is\tScot", "mn" )</code>
            will yeild <code>Hello, y ae is  Scot</code>
        </li>
    </ul>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/TrimWhiteSpace.java $
    </pre>

*/
public final class TrimWhiteSpace
{
    // ----------------------------------------------------------------------
    //
    // Static class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This is the default white space to trim.
     *
     */
    public static final String DEFAULT_WHITE_SPACE = "[\n\t\r ]";


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Removes the characters contained in <code>whiteSpace</code> from
     * <code>str</code>.
     *
     * @param str        The string from which the characters contained in
     *                   <code>whiteSpace</code> are removed.
     *
     * @param whiteSpace The string containing whitespace characters that should be
     *                   removed from <code>str</code>.
     *
     * @return The result of removing characters contained in
     *         <code>whiteSpace</code> from <code>str</code>.
     *
     */
    private static String trimActualWhiteSpace
        ( final String str, final String whiteSpace )
    {
        return str.replaceAll ( whiteSpace, "" );
    }


    /**
     *
     * Removes the characters contained in <code>whiteSpace</code> from
     * <code>str</code>.  If <code>whiteSpace</code> is null or the empty string,
     * {@link #DEFAULT_WHITE_SPACE} will be used.
     * 
     * @param str        The string from which the characters contained in
     *                   <code>whiteSpace</code> are removed.
     *
     * @param whiteSpace The string containing whitespace characters
     *                   that should be removed from <code>str</code>.
     *
     * @return The result of removing characters contained in
     *         <code>whiteSpace</code> from <code>str</code>.
     *
     * @see #DEFAULT_WHITE_SPACE
     *
     */
    public static String trimWhiteSpace
        ( final String str, final String whiteSpace )
    {
        String actualWhiteSpace;

        if ( ! "".equals ( whiteSpace ) && whiteSpace != null )
        {
            final StringBuilder sb =
                new StringBuilder ( 2 + whiteSpace.length () );

            sb.append ( '[' ).append ( whiteSpace ).append ( ']' );

            actualWhiteSpace = sb.toString ();
        }
        else
        {
            actualWhiteSpace = DEFAULT_WHITE_SPACE;
        }

        return trimActualWhiteSpace ( str, actualWhiteSpace );
    }


    /**
     *
     * Removes the characters contained in {@link #DEFAULT_WHITE_SPACE} from
     * <code>str</code>.
     * 
     * @param str The string from which the characters contained in
     *            {@link #DEFAULT_WHITE_SPACE} are removed.
     *
     * @return The result of removing characters contained in
     *         {@link #DEFAULT_WHITE_SPACE} from <code>str</code>.
     *
     * @see #DEFAULT_WHITE_SPACE
     *
     */
    public static String trimWhiteSpace ( final String str )
    {
        return trimActualWhiteSpace ( str, DEFAULT_WHITE_SPACE );
    }


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private TrimWhiteSpace ()
    {
        throw new UnsupportedOperationException ();
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
