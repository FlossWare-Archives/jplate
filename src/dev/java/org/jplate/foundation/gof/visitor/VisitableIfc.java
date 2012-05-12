package org.jplate.foundation.gof.visitor;


/**

    This interface defines the API for a visitable object (namely those who can be
    operated upon by a <code>VisitorIfc</code>).  Please refer to the definition of
    Visitor:  <i>"Represent an operation to be performed on the elements of an
    object structure.  Visitor lets you define a new operation without changing the
    classes of the elements on which it operates,"</i> p331 Design Patterns -
    Elements of Reusable Object-Oriented Software.

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    related functionality:
    <ul>
        <li>
            A visitor who defines opperations on a person:
            <ul>
                <li>
                    <code>PersonVisitorIfc</code>:  defines contract for visiting a
                                                    person
                </li>

                <li>
                    <code>ComputeTotalAge</code>:  can be used to keep a running
                                                   total of ages of people.
                </li>

                <li>
                    <code>ComputeTotalHeight</code>:  can be used to keep a running
                                                      total of height of people.
                </li>
            </ul>
        </li>

        <br/>

        <li>
            <code>PersonCollection</code> that supports iteration over a collection
                  of <code>PeopleIfc</code>'s applying a VisitorIfc to each one.
        </li>
    </ul>

    <p/>
    Code from the above description follows below:

    <pre>
public interface PersonVisitorIfc extends VisitorIfc
{
    public void visit ( Person person ) throws VisitException;
}

public class Person implements VisitableIfc &lt;PersonVisitorIfc&gt;
{
    int _age;
    int _height;

    public void accept ( PersonVisitorIfc pv ) throws VisitException
    {
        pv.visit ( this );
    }
}

public class ComputeTotalAge implements PersonVisitorIfc
{
    int _totalAge;

    public void visit ( Person person )
    {
        _totalAge += person._age;
    }
}

public class ComputeTotalHeight implements PersonVisitorIfc
{
    int _totalHeight;

    public void visit ( Person person )
    {
        _totalHeight += person._height;
    }
}

public class PersonCollection
{
    public static void processPeople
        ( Collection &lt;Person&gt; list, PersonVisitorIfc visitor )
            throws VisitException
    {
        for ( Person person : list )
        {
            person.accept ( visitor );
        }
    }
}
    </pre>

    As can be seen, two operations are defined to operate upon a person - one that
    computes total height and another computing total age.  Both operations are
    defined without affecting the concept of a person.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/visitor/VisitableIfc.java $
    </pre>

    @param <V> An implementation of Visitor who can perform operations on
               implementations of self.

*/
public interface VisitableIfc <V extends VisitorIfc>
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
     * Allows <code>visitor</code> to perform operations on self.
     *
     * @param visitor The object who will perform an operation on self.
     *
     * @throws VisitException If any problems arise performing an operation on self.
     *
     */
    public void accept ( V visitor ) throws VisitException;
}

