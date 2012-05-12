package org.jplate.foundation.node;


import java.io.Serializable;


/**
 
    Defines the API for a leaf node.  Leaf nodes have no children but do support a
    context (data specific to leaves).  For instance, consider XML where an element
    is parsed character data - this is the context.

    <p/>
    Providing the branch and leaf context types defines the data that will be found
    in parents and siblings.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/LeafNodeIfc.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.

*/
public interface LeafNodeIfc <BC, LC> extends Serializable, NodeIfc <BC, LC>
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
     * Sets the context of self.
     *
     * @param context The new context.
     *
     */
    public void setContext ( LC context );


    /**
     *
     * Returns self's context.
     *
     * @return Self's context.
     *
     */
   public LC getContext ();
}
