package org.jplate.foundation.node.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.node.BranchNodeIfc;
import org.jplate.foundation.node.NodeIfc;

import org.jplate.foundation.source.SourceIfc;


/**
 
    Defines an abstract 

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/impl/AbstractNode.java $
    </pre>

    @param <BC> The data stored in a branch.

    @param <LC> The data stored in a leaf.

*/
public abstract class AbstractNode <BC, LC> implements NodeIfc <BC, LC>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
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
        LogFactory.getLog ( AbstractNode.class );


    /**
     *
     * Holds the parent.
     *
     */
    private BranchNodeIfc <BC, LC> _parent;


    /**
     *
     * Holds the source from which self was generated.
     *
     */
    private SourceIfc <?> _source;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets the parent and data (context).
     *
     * @param parent The parent branch.
     *
     */
    protected AbstractNode ( final BranchNodeIfc <BC, LC> parent )
    {
        _parent  = parent;
    }


    /**
     *
     * Default constructor.
     *
     */
    protected AbstractNode ()
    {
        _parent = null;
    }


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
    public BranchNodeIfc <BC, LC> getParent ()
    {
        return _parent;
    }


    /**
     *
     * Returns the source from which self was defined.
     *
     * @return the source from which self was defined.
     *
     */
    public SourceIfc <?> getSource ()
    {
        return _source;
    }


    /**
     *
     * Sets the source from which this node was defined.
     *
     * @param source The source from which self was defined.
     *
     */
    public void setSource ( final SourceIfc <?> source )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New source set to:  [" + source + "]" );
        }

        _source = source;
    }
}

