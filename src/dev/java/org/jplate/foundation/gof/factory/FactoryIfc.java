package org.jplate.foundation.gof.factory;


import java.io.Serializable;


/**
 
    Defines the "Gang of Four" Factory pattern:  <i>"Define an interface for
    creating an object, but let subclasses decide which class to instantiate.
    Factory Method lets a class defer instantiation to subclasses,"</i> p107 Design
    Patterns - Elements of Reusable Object-Oriented Software.  Also, as a  factory
    can create objects, it must too be able to clean up those objects (via the
    <code>destroy()</code> method).

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    a factory for creating the person:
    
    <pre>
public final class Person
{
    private String _name;
    private int    _age;

    public Person ()
    {
    }

    public String getName () { return _name; }

    public void setName ( final String name ) { _name = name; }

    public int getAge () { return _age; }

    public void setAge ( final String age ) { _age = age; }
}

public final class PersonFactory implements FactoryIfc &lt;Person&gt;
{
    public Person create ()
    {
        return new Person ();
    }

    public void destroy ()
    {
    }
}
    </pre>

    Essentially, to implement a factory, do the following:

    <ul>
        <li>
            Define the class who will be created (for instance <code>Person</code>
            above).
        </li>

        <li>
            Create a factory class implementing <code>FactoryIfc</code> and provde
            the generic type for <code>FactoryIfc</code> (for instance
            <code>implements FactoryIfc &lt;Person&gt;</code> above).
        </li>
    </ul>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/factory/FactoryIfc.java $
    </pre>

    @param <V> The type of object to be created or destroyed.

*/
public interface FactoryIfc <V> extends Serializable
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
     * Creates a new object.
     *
     * @return A newly created object.
     *
     */
    public V create ();


    /**
     *
     * Destroys (or cleans up) <code>object</code> created by self.
     *
     * @param object The object to destroy/clean-up.
     *
     */
    public void destroy ( V object );
}
