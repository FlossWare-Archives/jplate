package org.jplate.foundation.util;

/**

    Provides validatation functionality through the concept of assertions:
    object not null, references not equal, non-empty string, etc.

    <p/><a  name = "Examples"/>
    The following are examples to perform assertions:

    <ul>
        <li>
            Ensuring an object is not null <br/>

            <pre>
Assert.notNull ( "foo == null", foo );
            </pre>

            If <code>foo</code> is null, a {@link java.lang.NullPointerException}
            is raised and the message will be "<code>foo == null</code>."
            </pre>
        </li>

        <br/>

        <li>
            Ensuring two references are not equal <br/>

            <pre>
Assert.referenceNotEqual ( "foo == bar", foo, bar );
            </pre>

            If <code>foo</code> and <code>bar</code> refer to the same object, an
            {@link java.lang.IllegalArgumentException} is
            and the message will be "<code>foo == bar</code>."
        </li>

        <br/>

        <li>
            Ensuring a String is not empty <br/>

            <pre>
Assert.notEmptyString ( "fooStr is empty", fooStr );
            </pre>

            If <code>fooStr</code> is either null or the empty string (""), an
            {@link java.lang.IllegalArgumentException} is and the message will be
            "<code>fooStr is empty</code>."
        </li>
    </ul>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/Assert.java $
    </pre>

 */
public final class Assert
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
     * Ensures that <code>toCheck</code> is not null.  If it is, a
     * {@link java.lang.NullPointerException} is raised whose message is
     * <code>msg</code>.
     *
     * @param msg     The message to use in {@link java.lang.NullPointerException}
     *                if <code>toCheck</code> is null.
     *
     * @param toCheck The object to check for null.
     *
     * @throws NullPointerException If <code>toCheck</code> is null.
     *
     */
    public static void notNull
        ( final String msg, final Object toCheck )
            throws NullPointerException
    {
        if ( toCheck == null )
        {
            throw new NullPointerException ( msg );
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is not null.  If it is, a
     * {@link java.lang.NullPointerException} is raised.
     *
     * @param toCheck The object to check for null.
     *
     * @throws NullPointerException If <code>toCheck</code> is null.
     *
     */
    public static void notNull ( final Object toCheck )
        throws NullPointerException
    {
        if ( toCheck == null )
        {
            throw new NullPointerException ();
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is referencing something other than null.
     * If it is, a {@link java.lang.IllegalArgumentException} is raised.
     *
     * @param msg     The message to use in
     *                {@link java.lang.IllegalArgumentException} if
     *                <code>toCheck</code> is null.
     *
     * @param toCheck The object to check for being a reference and not null.
     *
     * @throws IllegalArgumentException If <code>toCheck</code> is null.
     *
     */
    public static void isReferenced ( final String msg, final Object toCheck )
        throws IllegalArgumentException
    {
        if ( toCheck == null )
        {
            throw new IllegalArgumentException ( msg );
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is referencing something other than null.
     * If it is, a {@link java.lang.IllegalArgumentException} is raised.
     *
     * @param toCheck The object to check for being a reference and not null.
     *
     * @throws IllegalArgumentException If <code>toCheck</code> is null.
     *
     */
    public static void isReferenced ( final Object toCheck )
        throws IllegalArgumentException
    {
        if ( toCheck == null )
        {
            throw new IllegalArgumentException ();
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is of class type <code>klass</code>.  If
     * not, an {@link java.lang.IllegalArgumentException} is raised.
     *
     * @param msg     The message to use in
     *                {@link java.lang.IllegalArgumentException} if
     *                <code>toCheck</code> is not of class <code>klass</code>.
     *
     * @param toCheck The object to check for being of class type
     *                <code>klass</code>.
     *
     * @param klass   The class that <code>toCheck</code> should be.
     *
     * @throws IllegalArgumentException If <code>toCheck</code>'s class is not
     *                                  <code>klass</code>.
     *
     */
    public static void isOfClass
        ( final String msg, final Object toCheck, final Class klass )
            throws IllegalArgumentException
    {
        if ( toCheck == null || toCheck.getClass () != klass )
        {
            throw new IllegalArgumentException ( msg );
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is of class type <code>klass</code>.  If
     * not, an {@link java.lang.IllegalArgumentException} is raised.
     *
     * @param toCheck The object to check for being of class type
     *                <code>klass</code>.
     *
     * @param klass   The class that <code>toCheck</code> should be.
     *
     * @throws IllegalArgumentException If <code>toCheck</code>'s class is not
     *                                  <code>klass</code>.
     *
     */
    public static void isOfClass ( final Object toCheck, final Class klass )
        throws IllegalArgumentException
    {
        if ( toCheck == null || toCheck.getClass () != klass )
        {
            throw new IllegalArgumentException ();
        }
    }


    /**
     *
     * Ensures that <code>value1</code> and <code>value2</code> are not equal.  If
     * so, an {@link java.lang.IllegalArgumentException} is raised whose message is
     * <code>msg</code>.
     *
     * @param msg The message to use in {@link java.lang.IllegalArgumentException} 
     *            if <code>toCheck</code> is null.
     *
     * @param value1 The object to examine to ensure not equal to
     *               <code>value2</code>.
     *
     * @throws IllegalArgumentException if <code>toCheck</code> is null.
     *
     */
    public static void referenceNotEqual
        ( final String msg, final Object value1, final Object value2 )
            throws IllegalArgumentException
    {
        if ( value1 != null && value2 != null && value1 == value2 )
        {
            throw new IllegalArgumentException ( msg );
        }
    }


    /**
     *
     * Ensures that <code>value1</code> and <code>value2</code> are not equal.  If
     * so, an {@link java.lang.IllegalArgumentException}.
     *
     * @param value1 The object to examine to ensure not equal to
     *               <code>value2</code>.
     *
     * @throws IllegalArgumentException if <code>toCheck</code> is null.
     *
     */
    public static void referenceNotEqual
        ( final Object value1, final Object value2 )
            throws IllegalArgumentException
    {
        if ( value1 != null && value2 != null && value1 == value2 )
        {
            throw new IllegalArgumentException ();
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is not empty or null.  If it is, an
     * {@link java.lang.IllegalArgumentException} is raised whose message is
     * <code>msg</code>.
     *
     * @param msg     The message to use in
     *                {@link java.lang.IllegalArgumentException} if
     *                <code>toCheck</code> is null or empty.
     *
     * @param toCheck The string check for null or empty.
     *
     * @throws IllegalArgumentException if toCheck is null or empty.
     *
     */
    public static void notEmptyString
        ( final String msg, final String toCheck )
            throws IllegalArgumentException
    {
        if ( "".equals ( toCheck ) || toCheck == null )
        {
            throw new IllegalArgumentException ( msg );
        }
    }


    /**
     *
     * Ensures that <code>toCheck</code> is not empty or null.  If it is, an
     * {@link java.lang.IllegalArgumentException} is raised.
     *
     * @param toCheck The string check for null or empty.
     *
     * @throws IllegalArgumentException if toCheck is null or empty.
     *
     */
    public static void notEmptyString ( final String toCheck )
        throws IllegalArgumentException
    {
        if ( "".equals ( toCheck ) || toCheck == null )
        {
            throw new IllegalArgumentException ();
        }
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
    private Assert ()
    {
        throw new UnsupportedOperationException ();
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
