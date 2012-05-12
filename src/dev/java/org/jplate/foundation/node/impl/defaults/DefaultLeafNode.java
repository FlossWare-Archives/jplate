package org.jplate.foundation.node.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.visitor.VisitException;

import org.jplate.foundation.node.BranchNodeIfc;
import org.jplate.foundation.node.LeafNodeIfc;
import org.jplate.foundation.node.NodeVisitorIfc;

import org.jplate.foundation.node.impl.AbstractNode;

import org.jplate.foundation.util.Assert;
import org.jplate.foundation.util.SystemProperties;


/**
 
    Default implementation of LeafNodeIfc.  Is not thread-safe with regards to
    setting and retrieving the context.

    <p/>

    Specifying the branch and leaf context defines what object types can be expected
    for all branches and leaves for self, siblings, parents, etc.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/impl/defaults/DefaultLeafNode.java $
    </pre>

    @param <BC> The branch context representing data type stored in branches.

    @param <LC> The leaf context representing data type stored in leaves.
 
*/
public class DefaultLeafNode <BC, LC> extends AbstractNode <BC, LC>
    implements LeafNodeIfc <BC, LC>
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
    private static final long serialVersionUID = 7696890221214774563L;


    /**
     *
     * Denotes the parent presented on construction is null.
     *
     */
    private static final String PARENT_IS_NULL_MSG = "parent == null";


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
    private final transient Log _log = LogFactory.getLog ( DefaultLeafNode.class );


    /**
     *
     * Self's context.
     *
     */
    private LC _context;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Constructor to set the parent and context.
     *
     * @param parent  The parent of self.
     *
     * @param context The data associated with self.
     *
     * @throws IllegalArgumentException if parent is null.
     *
     */
    public DefaultLeafNode ( final BranchNodeIfc <BC, LC> parent, final LC context )
    {
        super ( parent );

        Assert.isReferenced ( PARENT_IS_NULL_MSG, parent );

        _context = context;

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New leaf node created:\n"        +
                "    parent  [" + parent  + "]\n" +
                "    context [" + context + "]"
            );
        }
    }


    /**
     *
     * Constructor to set the parent.
     *
     * @param parent The parent of self.
     *
     * @throws IllegalArgumentException if parent is null.
     *
     */
    public DefaultLeafNode ( final BranchNodeIfc <BC, LC> parent )
    {
        this ( parent, null );
    }


    /**
     *
     * Default constructor not allowed.
     *
     */
    private DefaultLeafNode ()
    {
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns a stringified version of self.
     *
     * @return The String representation of self.
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
        
        final StringBuilder sb = new StringBuilder ();

        sb.append ( prepend ).append ( "DefaultLeafNode" );
        sb.append ( ']' ).append ( SystemProperties.LINE_SEPARATOR );
        sb.append ( localPrepend ).append ( "_context [" ).append ( _context );
        sb.append ( ']' );

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void accept ( final NodeVisitorIfc <BC, LC> nodeVisitor )
        throws VisitException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Accepting node visitor [" + nodeVisitor + "]" );
        }

        nodeVisitor.visitLeaf ( this );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setContext ( final LC context )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New context [" + context + "]" );
        }

        _context = context;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public LC getContext ()
    {
        return _context;
    }
}
