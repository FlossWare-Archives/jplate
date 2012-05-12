package org.jplate.foundation.node;



/**

    A factory for creating leaf and branch nodes.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/NodeFactoryIfc.java $
    </pre>

    @param <BC> Data contained at the branch level.

    @param <LC> Data contained at the leaf level.
 
*/
public interface NodeFactoryIfc <BC, LC>
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
     * This will create a branch node whose parent is <code>parent</code>.
     *
     * @param parent is the parent node.
     *
     * @return a new branch node.
     *
     */
    public BranchNodeIfc <BC, LC>
        createBranchNode ( BranchNodeIfc <BC, LC> parent );


    /**
     *
     * This will create a branch node who has no parent.
     *
     * @return a new branch node.
     *
     */
    public BranchNodeIfc <BC, LC> createBranchNode ();


    /**
     *
     * This will create a leaf node whose parent is <code>parent</code>.
     *
     * @param parent is the parent node.
     *
     * @return a new leaf node.
     *
     */
    public LeafNodeIfc <BC, LC>
        createLeafNode ( BranchNodeIfc <BC, LC> parent );
}
