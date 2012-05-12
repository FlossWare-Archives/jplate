package org.jplate.foundation.node.impl.defaults;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.factory.ContextFactoryIfc;
import org.jplate.foundation.gof.factory.FactoryIfc;

import org.jplate.foundation.gof.visitor.VisitException;

import org.jplate.foundation.node.BranchNodeIfc;
import org.jplate.foundation.node.LeafNodeIfc;
import org.jplate.foundation.node.NodeFactoryIfc;
import org.jplate.foundation.node.NodeIfc;
import org.jplate.foundation.node.NodeVisitorIfc;

import org.jplate.foundation.node.impl.AbstractNode;

import org.jplate.foundation.source.SourceIfc;

import org.jplate.foundation.util.Assert;
import org.jplate.foundation.util.ListFactoryIfc;
import org.jplate.foundation.util.SystemProperties;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;


/**
 
    Default implementation of BranchNodeIfc.  Child node manipulation can be
    threadsafe by using an implementation of
    {@link org.jplate.foundation.util.ListFactoryIfc} that returns synchronized
    {@link java.util.List}'s.  However, mutating the context is not thread safe.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/impl/defaults/DefaultBranchNode.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.
 
    @see org.jplate.foundation.util.ListFactoryIfc

*/
public final class DefaultBranchNode <BC, LC> extends AbstractNode <BC, LC>
    implements BranchNodeIfc <BC, LC>
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


    /**
     *
     * For serialization purposes.
     *
     */
    private static final long serialVersionUID = 6258565893060223855L;


    /**
     *
     * Denotes the node factory is null.
     *
     */
    public static final String NODE_FACTORY_IS_NULL_MSG = "nodeFactory == null";


    /**
     *
     * Denotes the list factory is null.
     *
     */
    public static final String LIST_FACTORY_IS_NULL_MSG = "listFactory == null";


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( DefaultBranchNode.class );


    /**
     *
     * Child nodes.
     *
     */
    private final List <NodeIfc <BC, LC>> _childList;


    /**
     *
     * Used to create child branch nodes.
     *
     */
    private final transient NodeFactoryIfc <BC, LC> _nodeFactory;


    /**
     *
     * Self's context.
     *
     */
    private BC _context;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the parent, context and factories for self.
     *
     * @param parent       The parent of self.  It can be null (meaning no
     *                     parent).
     *
     * @param listFactory  The factory that can create a List for use to hold
     *                     child nodes.
     *
     * @param nodeFactory  The factory that can create child leaf nodes.
     *
     * @throws IllegalArgumentException If <code>listFactory</code>, or
     *                                  <code>nodeFactory</code>, are null.
     *
     * @see java.util.List
     *
     * @see org.jplate.foundation.gof.factory.ContextFactoryIfc
     * @see org.jplate.foundation.gof.factory.FactoryIfc
     *
     */
    public DefaultBranchNode
        ( final BranchNodeIfc <BC, LC> parent,
          final ListFactoryIfc <NodeIfc <BC, LC>> listFactory,
          final NodeFactoryIfc <BC, LC> nodeFactory )
    {
        super ( parent );

        Assert.isReferenced ( LIST_FACTORY_IS_NULL_MSG, listFactory );

        Assert.isReferenced ( NODE_FACTORY_IS_NULL_MSG, nodeFactory );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New branch node create:\n" +
                "    nodeFactory [" + nodeFactory + "]"
            );
        }

        _nodeFactory = nodeFactory;
        _childList   = listFactory.create ();
    }


    /**
     *
     * This constructor sets the factories for self.
     *
     * @param listFactory  The factory that can create a List for use to hold
     *                     child nodes.
     *
     * @param nodeFactory  The factory that can create child leaf nodes.
     *
     * @throws IllegalArgumentException If <code>listFactory</code>, or
     *                                  <code>nodeFactory</code>, are null.
     *
     * @see java.util.List
     *
     */
    public DefaultBranchNode
        ( final ListFactoryIfc <NodeIfc <BC, LC>> listFactory,
          final NodeFactoryIfc <BC, LC> nodeFactory )
    {
        this ( null, listFactory, nodeFactory );
    }


    /**
     *
     * This constructor sets the factories for self.
     *
     * @param listFactory  The factory that can create a List for use to hold
     *                     child nodes.
     *
     * @throws IllegalArgumentException If <code>listFactory</code>, is null.
     *
     */
    public DefaultBranchNode ( final ListFactoryIfc <NodeIfc <BC, LC>> listFactory )
    {
        this ( null, listFactory, new DefaultNodeFactory <BC, LC> () );
    }


    /**
     *
     * This constructor sets the factories for self.
     *
     * @param nodeFactory  The factory that can create child leaf nodes.
     *
     * @throws IllegalArgumentException If <code>nodeFactory</code>, is null.
     *
     */
    public DefaultBranchNode ( final NodeFactoryIfc <BC, LC> nodeFactory )
    {
        this
        (
            new UnsynchronizedLinkedListFactory <NodeIfc <BC, LC>> (), nodeFactory
        );
    }


    /**
     *
     * This constructor sets the parent.
     *
     * @param parent is the parent branch node of self.
     *
     */
    public DefaultBranchNode ( final BranchNodeIfc <BC, LC> parent )
    {
        this
        (
            parent, new UnsynchronizedLinkedListFactory <NodeIfc <BC, LC>> (),
            new DefaultNodeFactory <BC, LC> ()
        );
    }


    /**
     *
     * Default constructor.
     *
     */
    public DefaultBranchNode ()
    {
        this
        (
            new UnsynchronizedLinkedListFactory <NodeIfc <BC, LC>> (),
            new DefaultNodeFactory <BC, LC> ()
        );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns the string representation of self.
     *
     * @return The string representation of self.
     *
     */
    public String toString ()
    {
        return toString ( "" );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public String toString ( final String prepend )       
    {
        final String localPrepend = "    " + prepend;
        final String childPrepend = "    " + localPrepend;

        final StringBuilder sb = new StringBuilder ();

        sb.append ( prepend ).append ( "DefaultBranchNode" );
        sb.append ( SystemProperties.LINE_SEPARATOR );
        sb.append ( localPrepend ).append ( "_context [" ).append ( _context );
        sb.append ( ']' ).append ( SystemProperties.LINE_SEPARATOR );
        sb.append ( localPrepend ).append ( "Total Children:  [" );
        sb.append ( _childList.size () ).append ( ']' );
        sb.append ( localPrepend ).append ( "Total Children:  [" );
        sb.append ( SystemProperties.LINE_SEPARATOR );

        for ( final NodeIfc <BC, LC> node : getChildren () )
        {
            sb.append ( node.toString ( childPrepend ) );

            if ( node instanceof LeafNodeIfc )
            {
                sb.append ( SystemProperties.LINE_SEPARATOR );
            }
        }

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void accept ( NodeVisitorIfc <BC, LC> nodeVisitor ) throws VisitException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Accepting [" + nodeVisitor + "]" );
        }

        nodeVisitor.visitBranch ( this );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setContext ( BC context )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Setting context [" + context + "]" );
        }

        _context = context;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public BC getContext ()
    {
        return _context;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public LeafNodeIfc <BC, LC> appendNewLeaf ( final LC leafContext )
    {
        final LeafNodeIfc <BC, LC> retVal = _nodeFactory.createLeafNode ( this );

        retVal.setContext ( leafContext );

        _childList.add ( retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Appended new leaf [" + retVal + "] using context [" + leafContext +
                "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public BranchNodeIfc <BC, LC> appendNewBranch ( final BC branchContext )
    {
        final BranchNodeIfc <BC, LC> retVal =
            _nodeFactory.createBranchNode ( this );

        retVal.setContext ( branchContext );

        _childList.add ( retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Appended new branch [" + retVal + "] using context [" +
                branchContext + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public LeafNodeIfc <BC, LC> prependNewLeaf ( final LC leafContext )
    {
        final LeafNodeIfc <BC, LC> retVal = _nodeFactory.createLeafNode ( this );

        retVal.setContext ( leafContext );

        _childList.add ( 0, retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Prepending new leaf [" + retVal + "] using context [" +
                leafContext + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public BranchNodeIfc <BC, LC> prependNewBranch ( final BC branchContext )
    {
        final BranchNodeIfc <BC, LC> retVal =
            _nodeFactory.createBranchNode ( this );

        retVal.setContext ( branchContext );

        _childList.add ( 0, retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Prepending new branch [" + retVal + "] using context [" +
                branchContext + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public LeafNodeIfc <BC, LC> insertNewLeaf
        ( final LC leafContext, final int index )
    {
        final LeafNodeIfc <BC, LC> retVal = _nodeFactory.createLeafNode ( this );

        retVal.setContext ( leafContext );

        _childList.add ( index, retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Inserting new leaf [" + retVal + "] index [" + index + "] using " +
                "context [" + leafContext + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public BranchNodeIfc <BC, LC> insertNewBranch
        ( final BC branchContext, final int index )
    {
        final BranchNodeIfc <BC, LC> retVal =
            _nodeFactory.createBranchNode ( this );

        retVal.setContext ( branchContext );

        _childList.add ( index, retVal );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Inserting new branch [" + retVal + "] index [" + index + "] " +
                "using context [" + branchContext + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public NodeIfc <BC, LC> removeNode ( int index )
    {
        final NodeIfc <BC, LC> retVal = _childList.remove ( index );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Removed node a index [" + index + "] = [" + retVal + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public boolean removeNode ( final NodeIfc <BC, LC> node )
    {
        final boolean retVal = _childList.remove ( node );

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Removed node [" + node + "] = [" + retVal + "]"
            );
        }

        return retVal;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public Collection <NodeIfc <BC, LC>> getChildren ()
    {
        final Collection <NodeIfc <BC, LC>> retVal =
            Collections.unmodifiableList ( _childList );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created collection [" + retVal + "]" );
        }

        return retVal;
    }
}
