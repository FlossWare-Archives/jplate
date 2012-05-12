package org.jplate.foundation.node;


import java.io.Serializable;

import org.jplate.foundation.FormattableIfc;

import org.jplate.foundation.gof.visitor.VisitableIfc;
import org.jplate.foundation.gof.visitor.VisitorIfc;
import org.jplate.foundation.gof.visitor.VisitException;

import org.jplate.foundation.source.SourceIfc;


/**
 
    Defines a node and represents the base interface for all nodes.  All nodes
    have a parent (represented by a {@link BranchNodeIfc}) and can be visited by a
    {@link NodeVisitorIfc}.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/NodeIfc.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.

    @see BranchNodeIfc

    @see NodeVisitorIfc

*/
public interface NodeIfc <BC, LC>
    extends Serializable, FormattableIfc, VisitableIfc <NodeVisitorIfc <BC, LC>>
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
     * Returns the parent node.
     *
     * @return The parent node.
     *
     */
    public BranchNodeIfc <BC, LC> getParent ();


    /**
     *
     * Returns the source from which self was defined.
     *
     * @return the source from which self was defined.
     *
     */
    public SourceIfc <?> getSource ();


    /**
     *
     * Sets the source from which this node was defined.
     *
     * @param source The source from which self was defined.
     *
     */
    public void setSource ( SourceIfc <?> source );
}
