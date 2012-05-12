package org.jplate.foundation.gof.command;


/**
 
    A command that executes against a context (for instance the context may contain
    the state for execution).  

    This is a version of the "Gang of Four" Command pattern:  <i>"Encapsulate a
    request as an object, thereby letting you parameterize clients with different
    requests, queue or log requests, and support undoable operations,"</i> p107
    Design Patterns - Elements of Reusable Object-Oriented Software.
    This interface introduces a parameter that is used when executing the command
    entitled <code>Context</code>.

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    a context command for creating the person:
    
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

public final class CreatePersonContextCommand
    implements ContextCommandIfc &lt;Person&gt;
{
    public CreatePersonContextCommand ()
    {
    }

    public void execute ( final Person person )
    {
        //
        // Persistance work here to take
        // person and create that person...
        //
    }
}
    </pre>

    As can be seen, using <code>ContextCommandIfc</code> allows a single command
    to be instantiated for execution on N contexts.  For instance, above if all
    persistance work (like creating a database connection) is encapsulated in the
    execute method one command object is needed as state is maintained in
    <code>Person</code>.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/command/ContextCommandIfc.java $
    </pre>

    @param <C> The object that the command shall execute against. 

*/
public interface ContextCommandIfc <C>
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
     * Executes the command against <code>context</code>.
     *
     * @param context The object against which self executes.
     *
     * @throws ExcecuteException If any problems arise executing the command.
     *
     */
    public void execute ( C context ) throws ExecuteException;
}
