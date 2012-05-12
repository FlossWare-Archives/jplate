package org.jplate.foundation.gof.visitor;


/**

    Marker interface for all visitors.  By defining a visitor we can <i>"represent
    an operation to be performed on the elements of an object structure.  Visitor
    lets you define a new operation without changing the classes of the elements on
    which it operates,"</i> p331 Design Patterns - Elements of Reusable
    Object-Oriented Software.
    
    Implementations can provide operations
    against a {@link VisitableIfc} without affecting change to the
    {@link VisitorIfc}.

    For an example implementation, please refer to the examples defined in the
    {@link VisitableIfc}

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/visitor/VisitorIfc.java $
    </pre>

    @see VisitableIfc
 
*/
public interface VisitorIfc
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
}
