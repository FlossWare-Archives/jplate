package org.jplate.foundation.node.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.node.BranchNodeIfc;
import org.jplate.foundation.node.LeafNodeIfc;
import org.jplate.foundation.node.NodeFactoryIfc;
import org.jplate.foundation.node.NodeIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;



/**

    Default implementation to create branch and leaf nodes.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/impl/defaults/DefaultNodeFactory.java $
    </pre>

    @param <BC> Data contained at the branch level.

    @param <LC> Data contained at the leaf level.
 
*/
public class DefaultNodeFactory <BC, LC> implements NodeFactoryIfc <BC, LC>
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
        LogFactory.getLog ( DefaultNodeFactory.class );


    /**
     *
     * The factory that can create implementations of List to hold NodeIfc's.  Used
     * by <code>DefaultBranchNode</code>'s.
     *
     */
    private final ListFactoryIfc <NodeIfc <BC, LC>> _listFactory;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Sets the list factory for creating child NodeIfc lists and the leaf node
     * factory.
     *
     * @param listFactory     Creates List's to hold child NodeIfc's.
     *
     */
    public DefaultNodeFactory
        ( final ListFactoryIfc <NodeIfc <BC, LC>> listFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New branch node factory created:\n" +
                "    listFactory      [" + listFactory     + "]\n"
            );
        }

        _listFactory = listFactory;
    }


    /**
     *
     * Default constructor.  The list factory used is
     * {@link org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory}     *
     */
    public DefaultNodeFactory ()
    {
        this ( new UnsynchronizedLinkedListFactory <NodeIfc <BC, LC>> () );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * {@inheritDoc}
     *
     */
    public BranchNodeIfc <BC, LC>
        createBranchNode ( final BranchNodeIfc <BC, LC> parent )
    {
        return new DefaultBranchNode <BC, LC> ( parent, _listFactory, this );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public BranchNodeIfc <BC, LC> createBranchNode ()
    {
        return new DefaultBranchNode <BC, LC> ( _listFactory, this );
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public LeafNodeIfc <BC, LC>
        createLeafNode ( final BranchNodeIfc <BC, LC> parent )
    {
        return new DefaultLeafNode <BC, LC> ( parent );
    }
}
