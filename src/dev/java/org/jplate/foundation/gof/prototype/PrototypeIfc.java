package org.jplate.foundation.gof.prototype;


/**
 

    Defines the "Gang of Four" Prototype pattern:  <i>Specify the kinds of objects
    to create using a prototypical instance, and create new objects by copying this
    prototype,"</i> p117 Design Patterns - Elements of Reusable Object-Oriented
    Software.

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person that can
    be a prototypical instance:
    
    <pre>
public interface PersonIfc extends PrototypeIfc &lt;PersonIfc&gt;
{
    public String getName ();

    public void setName ( String name );

    public int getAge ();

    public void setAge ( String age );
}

public final class Person implements PersonIfc
{
    private String _name;
    private int    _age;

    public Person ( final PersonIfc person )
    {
        _name = person.getName ();
        _age  = person.getAge  ();
    }

    public Person ( final Person person )
    {
        _name = person.name;
        _age  = person.age;
    }

    public Person ()
    {
    }

    public PersonIfc createCopy ()
    {
        return new Person ( this );
    }

    public PersonIfc createInstance ()
    {
        return new Person ();
    }

    public String getName () { return _name; }

    public void setName ( final String name ) { _name = name; }

    public int getAge () { return _age; }

    public void setAge ( final String age ) { _age = age; }
}
    </pre>
    
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/prototype/PrototypeIfc.java $
    </pre>

    @param <V> The type of object to be copied.

*/
public interface PrototypeIfc <V extends PrototypeIfc>
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
     * Creates a copy of self.
     *
     * @return A new copy of self.
     *
     */
    public V createCopy ();


    /**
     *
     * Creates a new instance of self (non populated).
     *
     * @return A new instance of self.
     *
     */
    public V createInstance ();
}
