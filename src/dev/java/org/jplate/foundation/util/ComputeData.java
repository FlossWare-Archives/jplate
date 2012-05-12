package org.jplate.foundation.util;

/**

    Computes values based on an initial values and a default values:  if the initial
    value is null, the default value is returned.

    <p/><a  name = "Examples"/>
    Consider the following examples:<br/>

    <p/>
    <ul>
        <li>
            Compute an arbitrary value using a Foo (assume <code>someFoo</code> is
            defined and <code>DEFAULT_FOO</code> represents a "default" instance):

            <pre>
final Foo myFoo = ComputeDataValue ( someFoo, DEFAULT_FOO );
            </pre>

            Above, if <code>someFoo == null</code>, <code>myFoo</code> will now
            equal <code>DEFAULT_FOO</code>.  Otherwise, <code>myFoo</code> will
            equal <code>someFoo</code>.
        </li>

        <br/>

        <li>
            Compute a String value (assume <code>someString</code> is defined):

            <pre>
final static String DEFAULT_STR = "Alpha";
...
final String myString = ComputeString ( someString, DEFAULT_STR );
            </pre>

            Above, if <code>someString == null</code>, <code>myString</code> will
            equal <code>DEFAULT_STR</code>.  Otherwise, <code>myString</code> will
            equal <code>someString</code>.
        </li>
    </ul>

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/ComputeData.java $
    </pre>

*/
public final class ComputeData
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
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


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------

    /**
     *
     * Returns <code>value</code> if <code>value</code> is not null or
     * <code>defaultValue</code> if it is.
     *
     * @param value        The object to examine for null.
     *
     * @param defaultValue The return value if <code>value</code> is null.
     *
     * @return <code>value</code> if <code>value</code> is not null or
     *         <code>defaultValue</code> if it is.
     *
     */
    public static <V> V computeValue ( V value, V defaultValue )
    {
        return value != null ? value : defaultValue;
    }


    /**
     *
     * Computes a string value.  If <code>str</code> is null or blank, it will
     * return <code>defaultStr</code> otherwise it returns <code>str</code>.
     *
     * @param str        The string to examine for null/blank.
     *
     * @param defaultStr The default string to return if <code>str</code> is null
     *                   or blank.
     *
     * @return <code>defaultStr</code> if <code>str</code> is null/empty otherwise
     *         <code>str</code>.
     *
     */
    public static String computeString
        ( final String str, final String defaultStr )
    {
        return ( ( str == null || "".equals ( str ) ) ? defaultStr : str );
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
    // Instance methods follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private ComputeData ()
    {
        throw new UnsupportedOperationException ();
    }
}
