package org.jplate.foundation.node.tag.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.foundation.node.attribute.AttributeIfc;

import org.jplate.foundation.node.tag.TagContextFactoryIfc;
import org.jplate.foundation.node.tag.TagContextIfc;


/**
 
    Factory to create <code>DefaultTagContext</code>'s.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/tag/impl/defaults/DefaultTagContextFactory.java $
    </pre>


    @param <T>  The tag type.

    @param <A>  Attributes associated with this tag.

*/
public final class DefaultTagContextFactory <T, A extends AttributeIfc <?, ?>>
    extends    AbstractFactory      <DefaultTagContext <T, A>>
    implements TagContextFactoryIfc <DefaultTagContext <T, A>>
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
    private static final long serialVersionUID = -6294413376890954744L;


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
        LogFactory.getLog ( DefaultTagContextFactory.class );


    /**
     *
     * The factory that can create implementations of <code>java.util.List</code>.
     *
     */
    private final ListFactoryIfc <A> _listFactory;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Constructor sets up the {@link ListFactoryIfc} that is used by
     * {@link DefaultTagContext} attributes.
     *
     * @param listFactory The factory that can create implementations of
     *        {@link java.util.List} to hold attributes.
     *
     * @see org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory
     *
     */
    public DefaultTagContextFactory
        ( final ListFactoryIfc <A> listFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Using listFactory [" + listFactory + "]" );
        }

        _listFactory = listFactory;
    }


    /**
     *
     * Default constructor.  Sets up an {@link UnsynchronizedLinkedListFactory}
     * as the list factory (used by <code>DefaultTagContext</code> to hold 
     * attributes).
     *
     * @see org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory
     *
     */
    public DefaultTagContextFactory ()
    {
        this ( new UnsynchronizedLinkedListFactory <A> () );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Creates a <code>DefaultTagContext</code>.
     *
     * @return a new <code>DefaultTagContext</code>.
     *
     */
    public DefaultTagContext <T, A> create ()
    {
        final DefaultTagContext <T, A> retVal =
            new DefaultTagContext <T, A> ( _listFactory );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created new tag context:  [" + retVal + "]" );
        }

        return retVal;
    }
}
