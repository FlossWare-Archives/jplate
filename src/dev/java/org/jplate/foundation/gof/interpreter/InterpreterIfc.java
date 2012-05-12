package org.jplate.foundation.gof.interpreter;

/** 

    Defines an Interpreter.  <i>Given a language, define a representation for its
    grammar along with an interpreter that uses the representation to interpret
    sentences in the language,"</i> p243 Design Patterns - Elements of Reusable
    Object-Oriented Software.  
    <p/>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/interpreter/InterpreterIfc.java $
    </pre>

*/
public interface InterpreterIfc
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
     * Requests interpretation.
     *
     * @throws InterpreterException If any problems arise interpreting.
     *
     */
    public void interpret () throws InterpreterException; 
}
