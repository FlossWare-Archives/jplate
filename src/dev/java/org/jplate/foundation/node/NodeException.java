package org.jplate.foundation.node;

import org.jplate.foundation.FoundationException;


/**

    This is the base class of all node exceptions.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/NodeException.java $
    </pre>

*/
public class NodeException extends FoundationException
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
     * The node that caused self to be raised.
     *
     */
    private final NodeIfc _node;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException If this constructor is called.
     *
     */
    protected NodeException ()
    {
        throw new UnsupportedOperationException ();
    }


    /**
     *
     * This constructor sets the node that caused self to be raised.
     *
     * @param node The node that caused self to be raised.
     *
     */
    public NodeException ( final NodeIfc node )
    {
        _node = node;
    }


    /**
     *
     * This constructor sets the message and the node that caused self to be
     * raised.
     *
     * @param msg  A message about why self was raised.
     *
     * @param node The node that caused self to be raised.
     *
     */
    public NodeException ( final String msg, final NodeIfc node )
    {
        super ( msg );

        _node = node;
    }


    /**
     *
     * This constructor sets the root cause and the node that caused self to be
     * raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param node      The node that caused self to be raised.
     *
     */
    public NodeException
        ( final Throwable rootCause, final NodeIfc node )
    {
        super ( rootCause );

        _node = node;
    }


    /**
     *
     * This constructor sets the message and root cause.
     *
     * @param msg       A message about why self was raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     * @param node      The node that caused self to be raised.
     *
     */
    public NodeException
        ( final String msg, final Throwable rootCause,
          final NodeIfc node )
    {
        super ( msg, rootCause );

        _node = node;
    }


    /**
     *
     * This method will return the node that caused self to be raised.
     *
     * @return The node that caused self to be raised.
     *
     */
    public NodeIfc getNode ()
    {
        return _node;
    }
}
