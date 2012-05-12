package org.jplate.foundation.node;

import org.jplate.foundation.gof.visitor.VisitException;
import org.jplate.foundation.gof.visitor.VisitorIfc;

/**
 
    Defines the API for visiting nodes.  Implementations can be written to define 
    new operations against {@link NodeIfc}'s without affecting change to existing
    implementations.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/NodeVisitorIfc.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.

    @see org.jplate.foundation.gof.visitor.VisitableIfc
     
*/
public interface NodeVisitorIfc <BC, LC> extends VisitorIfc
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
     * Visit a leaf node.
     *
     * @param leaf The leaf node to visit.
     *
     */
    public void visitLeaf ( LeafNodeIfc <BC, LC> leaf ) throws VisitException;


    /**
     *
     * Visit a branch branch.
     *
     * @param branch The branch node to visit.
     *
     */
    public void visitBranch ( BranchNodeIfc <BC, LC> branch ) throws VisitException;
}
