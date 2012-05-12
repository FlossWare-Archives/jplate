package org.jplate.foundation.gof.command;


/**
 
    Defines the "Gang of Four" Command pattern:  <i>"Encapsulate a request as an
    object, thereby letting you parameterize clients with different requests, queue 
    or log requests, and support undoable operations,"</i> p107 Design
    Patterns - Elements of Reusable Object-Oriented Software.

    All state is encapsulated in implementations.

    <p/><a  name = "Examples"/>
    The following example illustrates a trivial implementation of a person and
    a command for creating the person:
    
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

public final class CreatePersonCommand implements CommandIfc
{
    private final Person _person;

    public CreatePersonCommand ( final Person person )
    {
        _person = person;
    }

    private CreatePersonCommand ()
    {
    }

    public void execute ()
    {
        //
        // Persistance work here to take
        // _person and create that person...
        //
    }
}

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/command/CommandIfc.java $
    </pre>

*/
public interface CommandIfc
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
     * Executes the command.
     *
     * @throws ExcecuteException If any problems arise executing the command.
     *
     */
    public void execute () throws ExecuteException;
}
