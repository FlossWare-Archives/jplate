package org.jplate.foundation.gof.factory;


import java.io.Serializable;


/**
 
    A factory that defines creating objects based upon a context (a parameter that
    the resulting object needs in order to be created).
    
    This is a version of the "Gang of Four" Factory pattern:  <i>"Define an
    interface for creating an object, but let subclasses decide which class to
    instantiate.  Factory Method lets a class defer instantiation to subclasses,"
    </i> p107 Design Patterns - Elements of Reusable Object-Oriented Software.
    This interface introduces a parameter that is used when creating the object
    entitled <code>Context</code>.  Also, as a  context factory can create objects,
    it must too be able to clean up those objects (via the <code>destroy()</code>
    method).

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    a context factory for creating the person:
    
    <pre>
public final class Person
{
    private String _name;
    private int    _age;

    public Person ( final String name )
    {
        name = _name;
    }

    private Person ()
    {
    }

    public String getName () { return _name; }

    public int getAge () { return _age; }

    public void setAge ( final String age ) { _age = age; }
}

public final class PersonFactory implements ContextFactoryIfc &lt;Person, String&gt;
{
    public Person create ( String name )
    {
        return new Person ( name );
    }

    public void destroy ( Person object )
    {
    }
}
    </pre>

    Essentially, to implement a context factory, do the following:

    <ul>
        <li>
            Define the class who will be created (for instance <code>Person</code>
            above).
        </li>

        <li>
            Create a factory class implementing <code>ContextFactoryIfc</code> and
            provde the generic types (the created type and data to use in creation)
            for <code>ContextFactoryIfc</code> (for instance
            <code>implements ContextFactoryIfc &lt;Person, String&gt;</code> above).
        </li>
    </ul>
    
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/factory/ContextFactoryIfc.java $
    </pre>

    @param <V> The type of object to be created.

    @param <C> The context in which <code>V</code> will be created.  Consider this
               akin to a param or data needed in order to successfully create an
               object.

*/
public interface ContextFactoryIfc <V, C> extends Serializable
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
     * @param context The data needed to create the return value.
     *
     * @return A newly created object.
     *
     */
    public V create ( C context );


    /**
     *
     * Destroys (or cleans up) <code>object</code> created by self.
     *
     * @param object The object to destroy/clean-up.
     *
     */
    public void destroy ( V object );
}
