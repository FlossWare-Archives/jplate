package org.jplate.foundation.node;


import java.io.Serializable;

import java.util.Collection;


/**

    Defines the API for a branch node.  Branch nodes have optional child nodes
    (LeafNodeIfc or BranchNodeIfc) and a context (an arbitrary object that belongs
    at the branch level).  Implementations must manage the child nodes and act as a 
    factory when adding child nodes.  Refer to the various append, prepend, and
    insert methods:  children are not created and then added to the branch
    externally, the branch performs the correct insertion creating the child node
    and returning it.

    <p/>
    Providing the branch and leaf contexts define the data stored in parents,
    siblings and children.

    <p/>
    Mentioned above is the notion of a context.  A context is nothing more than an
    object that makes sense for a branch and is specific for a branch.  Consider XML,
    the tag and its attributes are comparable for context.  Assuming this, the
    context may be defined as such: <br/>

    <pre>
public final class XmlTag
{
    public String _tagName;
    public final Map &lt;String, String&gt; attributes =
        new HashMap &lt;String, String&gt; ();
}

final BranchIfc branch &lt;XmlTag, String&gt; = ...
    </pre>

    <p/><a  name = "Examples"/>
    Consider the following examples:

    <pre>
final BranchIfc &lt;Bar, Foo&gt; branch = ...; // Assume instantiated correcly.
    </pre>

    <p/>
    <ul>
        <li>
            Set the Branch's context

            <pre>
branch.setContext ( new Bar () );
            </pre>
        </li>

        <li>
            Get the Branch's context

            <pre>
final Bar context = branch.getContext ();
            </pre>
        </li>

        <li>
            Appending children

            <pre>
final LeafNodeIfc &lt;Foo&gt; leaf = branch.appendNewLeaf ( new Foo () );
final BranchNodeIfc &lt;Foo&gt; branch = branch.appendNewBranch ( new Bar () );
            </pre>
        </li>

        <li>
            Prepending children

            <pre>
final LeafNodeIfc &lt;Foo&gt; leaf = branch.prependNewLeaf ( new Foo () );
final BranchNodeIfc &lt;Foo&gt; branch = branch.prependNewBranch ( new Bar () );
            </pre>
        </li>

        <li>
            Inserting children at an index

            <pre>
final LeafNodeIfc &lt;Foo&gt; leaf = branch.insertNewLeaf ( new Foo (), 10 );
final BranchNodeIfc &lt;Foo&gt; branch = branch.insertNewBranch ( new Bar (), 20 );
            </pre>
        </li>

        <li>
            Removing a child at an index

            <pre>
final NodeIfc &lt;Foo&gt; leaf = branch.removeNode ( 10 );
            </pre>
        </li>

        <li>
            Removing a child

            <pre>
final NodeIfc &lt;Foo&gt; leaf = branch.removeNode ( node );
            </pre>
        </li>

        <li>
            Retrieving the children (for instance for iteration)

            <pre>
final Collection &lt;NodeIfc &lt;Foo, Bar&gt;&gt; collection = branch.getChildren ();
            </pre>
        </li>
    </ul>

    <b><i>Please note:</i></b>  For appends, inserts and prepends the implementation
    of BranchIfc is responsible for creating the node (either an implemntation of
    LeafIfc or BranchIfc).  This restriction is by design:  doing so forces the new
    child to have <b>exactly</b> one parent - as well as ensuring the parent can
    not be changed thus allowing a child to have two parents instead of one.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/BranchNodeIfc.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.
 
*/
public interface BranchNodeIfc <BC, LC> extends Serializable, NodeIfc <BC, LC>
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
     * Sets the context.
     *
     * @param context The new context.
     *
     */
    public void setContext ( BC context );


    /**
     *
     * Returns the context.
     *
     * @return The context.
     *
     */
    public BC getContext ();


    /**
     *
     * Append a new child leaf node.
     *
     * @param leafContext The data stored in the return value.
     *
     * @return The newly appended child leaf node.
     *
     */
    public LeafNodeIfc <BC, LC> appendNewLeaf ( LC leafContext );


    /**
     *
     * Append a new child branch node.
     *
     * @param branchContext The data stored in the return value.
     *
     * @return The newly appended branch node.
     *
     */
    public BranchNodeIfc <BC, LC> appendNewBranch ( BC branchContext );


    /**
     *
     * Prepend a new child leaf node.
     *
     * @param leafContext The data stored in the return value.
     *
     * @return The newly prepended child leaf node.
     *
     */
    public LeafNodeIfc <BC, LC> prependNewLeaf ( LC leafContext );


    /**
     *
     * Prepend a new child branch node.
     *
     * @param branchContext The data stored in the return value.
     *
     * @return the newly prepended child branch node.
     *
     */
    public BranchNodeIfc <BC, LC> prependNewBranch ( BC branchContext );


    /**
     *
     * Insert a new child leaf node at <code>index</code>.
     *
     * @param leafContext The data stored in the return value.
     *
     * @param index       The index for which the return value will be inserted.
     *
     * @return the newly inserted child leaf node.
     *
     */
    public LeafNodeIfc <BC, LC> insertNewLeaf ( LC leafContext, int index );


    /**
     *
     * Insert a new child branch node at <code>index</code>.
     *
     * @param branchContext The data stored in the return value.
     *
     * @param index         The index for which the return value will be inserted.
     *
     * @return the newly prepended child branch node.
     *
     */
    public BranchNodeIfc <BC, LC> insertNewBranch ( BC branchContext, int index );


    /**
     *
     * Remove the child node at <code>index</code>.
     *
     * @param index The index of the child node to remove.
     *
     * @return The removed node.
     *
     */
    public NodeIfc <BC, LC> removeNode ( int index );


    /**
     *
     * Remove a child node.
     *
     * @param node The child node to remove.
     *
     * @return true if <code>node</code> was found and removed false if not.
     *
     */
    public boolean removeNode ( NodeIfc <BC, LC> node );


    /**
     *
     * Return the children of self.  Implementations are encouraged to return an
     * {@link java.util.Collections#unmodifiableCollection}.
     *
     * @return The children nodes as a Collection.
     *
     */
    public Collection <NodeIfc <BC, LC>> getChildren ();
}
