package org.jplate.foundation;


/**

    Classes should implement this interface to gain "prettier"
    <code>toString()</code> functionality by way of allowing arbitrary prependable
    text.  For instance this can be used to stagger (indent) data members.

    <p/>

    Consider the following classes:
    <p/>
    <pre>
public class Bar implements FormattableIfc
{
    public int _value1;
    public int _value2;

    public String toString ()
    {
        return toString ( "" );
    }

    public String toString ( final String prepend )
    {
        return
            prepend + "_value1 = [" + _value1 + "]\n" +
            prepend + "_value2 = [" + _value2 + "]\n";
    }
}

public class Foo implements FormattableIfc
{
    public final Bar _bar1 = new Bar ();
    public final Bar _bar2 = new Bar ();

    public int _age;

    public String toString ()
    {
        return toString ( "" );
    }

    public String toString ( final String prepend )
    {
        return
            prepend + "_bar1 =\n" + _bar1.toString ( prepend + "    " ) +
            prepend + "_bar2 =\n" + _bar2.toString ( prepend + "    " ) +
            prepend + "_age  = [" + _age + "]";
    }
}
    </pre>

    If one executes the above code using the following:<br/>

    <pre>
final Foo foo = new Foo ();

foo._bar1._value1 = 1;
foo._bar1._value2 = 2;

foo._bar2._value1 = 3;
foo._bar2._value2 = 4;

foo._age = 37;

System.out.println ( "foo =\n" + foo.toString ( "----" ) );
    </pre>

    Will yield:<br/>

    <pre>
foo =
----_bar1 =
----    _value1 = [1]
----    _value2 = [2]
----_bar2 =
----    _value1 = [3]
----    _value2 = [4]
----_age  = [37]
    </pre>

    <p/>
    <pre>
Modifications:
    $Author: sfloess $
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/FormattableIfc.java $
    </pre>

*/
public interface FormattableIfc
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
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns a string representation of self prepending <code>prepend</code> to
     * each line.
     *
     * @param prepend The text to prepend to each line as defined in the return
     *        value.
     *
     * @return A string representation of self who has <code>prepend</code>
     *         prepended to each line.
     *
     */
    public String toString ( String prepend );
}
