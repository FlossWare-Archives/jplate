package org.jplate.foundation.node.tag.impl.defaults;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.node.attribute.AttributeIfc;

import org.jplate.foundation.node.tag.TagContextIfc;

import org.jplate.foundation.source.SourceIfc;

import org.jplate.foundation.util.ListFactoryIfc;
import org.jplate.foundation.util.Assert;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;


/**
 
    Default implementation of <code>TagContextIfc</code>.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/tag/impl/defaults/DefaultTagContext.java $
    </pre>


    @param <T>  The tag type.

    @param <A>  Attributes associated with this tag.

*/
public final class DefaultTagContext <T, A extends AttributeIfc <?, ?>>
    implements TagContextIfc <T, A>
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
     * Denotes that a list factory is null.
     *
     */
    private static final String LIST_FACTORY_IS_NULL_MSG = "listFactory == null";


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
        LogFactory.getLog ( DefaultTagContext.class );


    /**
     *
     * Holds our attributes.
     *
     */
    private List <A> _attributeList;


    /**
     *
     * The tag.
     *
     */
    private T _tag;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor uses <code>listFactory</code> to create a collection to hold
     * {@link AttributeIfc}'s.
     *
     * @param listFactory Factory to create a collection to hold
     *        {@link AttributeIfc}'s.
     *
     * @throws IllegalArgumentException If listFactory is null.
     *
     */
    public DefaultTagContext ( final ListFactoryIfc <A> listFactory )
    {
        Assert.isReferenced ( LIST_FACTORY_IS_NULL_MSG, listFactory );

        _attributeList = listFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New tag context created using list factory [" + listFactory + "]"
            );
        }
    }


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private DefaultTagContext ()
    {
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
    public T getTag ()
    {
        return _tag;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void setTag ( final T tag )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New tag [" + tag + "]" );
        }

        _tag = tag;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public List <A> getAttributes ()
    {
        return _attributeList;
    }
}
