package org.jplate.foundation.io;


import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectInput;


/**
 
    This interface defines a strategy to serialize/deserialize an object.  This
    interface is useful in scenarios where one may not want to subclass to ensure
    a class is serializable (that isn't already serializable) or the class to
    serialize cannot be subclassed (either abstract or final).

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    a an <code>ExternablizableStrategyIfc</code> that can externalize the person.
    <b><i>Note:</i></b>  The person is declared final.
    
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


public final PersonExternalizableStrategy
    implements ExternablizableStrategyIfc &lt;Person&gt;
{
    public void writeExternal
        ( final Person person, final  ObjectOutput objectOutput )
            throws IOException
    {
        objectOutput.writeObject ( person.getName () );
        objectOutput.writInt     ( person.getAge  () );
    }

    public void readExternal
        ( final Person person, final ObjectInput objectInput )
            throws IOException, ClassNotFoundException
    {
        person.setName ( ( String ) objectInput.readObject () );
        person.setAge  (            objectInput.readInt    () );
    }
}


public final class PeopleCollection implements Externalizable
{
    private final List <Person> _personList; = new LinkedList <Person> ();

    private final ExternalizableStrategyIfc <Person> _strategy;

    public PeopleCollection ( final ExternalizableStrategyIfc <Person> strategy )
    {
        _strategy = strategy;
    }

    public PeopleCollection ()
    {
        this ( new PersonExternalizableStrategy () );
    }

    public void writeExternal ( final ObjectOutput out ) throws IOException
    {
        out.write
        for ( final Person person : _personList )
        {
            _strategy.writeExternal ( person, out );
        }
    }

    public void readExternal ( final ObjectInput in )
        throws IOException, ClassNotFoundException
    {

    }
}
    </pre>


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/io/ExternalizableStrategyIfc.java $
    </pre>

    @param <T> The type to be externalized.

*/
public interface ExternalizableStrategyIfc <T>
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
     * Serialize <code>externalizable</code> to <code>objectOutput</code>.
     *
     * @param externalizable The object to serialize to objectOutput.
     *
     * @param objectOutput   The stream to write <code>externalizable</code> to.
     *
     * @throws IOException If any I/O exceptions arise.
     *
     */
    public void writeExternal ( T externalizable, ObjectOutput objectOutput )
       throws IOException;


    /**
     *
     * Deserialize <code>externalizable</code> from <code>objectInput</code>.
     *
     * @param externalizable The object to deserialize from objectInput.
     *
     * @param objectInput    The stream to read <code>externalizable</code> from.
     *
     * @throws IOException If any I/O exceptions arise.
     *
     */
    public void readExternal ( T externalizable, ObjectInput objectInput )
        throws IOException, ClassNotFoundException;

}
