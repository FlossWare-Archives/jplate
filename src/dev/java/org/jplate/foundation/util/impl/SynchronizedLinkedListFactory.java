package org.jplate.foundation.util.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.ListFactoryIfc;


/**

    Factory that creates synchronized {@link java.util.List}'s backed by
    {@link java.util.LinkedList}'s.

    <p/><a  name = "Examples"/>
    To create a synchronized List containing <code>Foo's</code>, perform the
    following:

    <pre>
final SynchronizedLinkedListFactory &lt;Foo&gt; factory =
    new SynchronizedLinkedListFactory &lt;Foo&gt; ();

final List sList &lt;Foo&gt; = factory.create ();
    </pre>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/impl/SynchronizedLinkedListFactory.java $
    </pre>

    @param <V> The value type that will be stored in {@link java.util.List}'s.

    @see java.util.LinkedList

    @see java.util.List
 
*/
public final class SynchronizedLinkedListFactory <V> implements ListFactoryIfc <V>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
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
    private static final long serialVersionUID = -7285369692062119081L;


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
        LogFactory.getLog ( SynchronizedLinkedListFactory.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor.
     *
     */
    public SynchronizedLinkedListFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New synchronized linked list factory created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Creates and returns a synchronized {@link java.util.List} backed by a
     * {@link java.util.LinkedList}.
     *
     * @return A synchronized {@link java.util.List} backed by a
     * {@link java.util.LinkedList}.
     *
     * @see java.util.Collections#synchronizedList
     *
     * @see java.util.LinkedList
     *
     * @see java.util.List
     *
     */
    public List <V> create ()
    {
        final List <V> retVal =
            Collections.synchronizedList ( new LinkedList <V> () );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created new synchronized list [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * Clean a previsously instantiated <code>List</code>.  Assuming
     * <code>list</code> is not <code>null</code>, the <code>clear</code> method
     * will be called.
     *
     * @param list The object to clean up.
     *
     */
    public void destroy ( List <V> list )
    {
        if ( list != null )
        {
            list.clear ();
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Cleared list [" + list + "]" );
        }
    }
}
