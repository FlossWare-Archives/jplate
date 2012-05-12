package org.jplate.foundation.node.impl.defaults;

import org.jplate.foundation.gof.visitor.VisitException;

import org.jplate.foundation.node.BranchNodeIfc;
import org.jplate.foundation.node.LeafNodeIfc;
import org.jplate.foundation.node.NodeFactoryIfc;
import org.jplate.foundation.node.NodeIfc;
import org.jplate.foundation.node.NodeVisitorIfc;

public final class TestDefaultBranchNode
{
    private static final class NodeVisitor
        implements NodeVisitorIfc <String, String>
    {
        public void visitLeaf ( final LeafNodeIfc <String, String> leaf )
        {
            System.out.println ( "Leaf:    [" + leaf.getContext () + "]" );
        }

        public void visitBranch ( final BranchNodeIfc <String, String> branch )
            throws VisitException
        {
            System.out.println ( "\nBranch:  [" + branch.getContext () + "]" );

            for ( final NodeIfc <String, String> child : branch.getChildren () )
            {
                child.accept ( this );
            }
        }
    }

    private static void populateBranch
        ( final BranchNodeIfc <String, String> branchNode, final int depth )
            throws Exception
    {
        for ( int loop = 0; loop < 5; loop++ )
        {
            final BranchNodeIfc <String, String> childNode =
                branchNode.appendNewBranch ( "Branch Child [" + depth + "]" );

            if ( depth < 4 )
            {
                populateBranch ( childNode, depth + 1 );
            }

            branchNode.appendNewLeaf
            (
                "Leaf Child [" + depth + " : " + loop + "]"
            );
        }
    }

    public static void main ( final String[] args )
    {
        try
        {
            final NodeFactoryIfc <String, String> nodeFactory =
                new DefaultNodeFactory <String, String> ();

            final BranchNodeIfc <String, String> rootBranchNode =
                nodeFactory.createBranchNode ();

            rootBranchNode.setContext ( "Root" );

            populateBranch ( rootBranchNode, 0 );

            System.out.println ( "Results =\n" + rootBranchNode );
        }

        catch ( final Throwable throwable )
        {
            throwable.printStackTrace ();
        }
    }
}
