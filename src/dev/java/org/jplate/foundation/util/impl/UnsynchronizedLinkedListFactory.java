package org.jplate.foundation.util.impl;

import java.util.List;
import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.ListFactoryIfc;


/**

    Factory that creates of unsynchronized {@link java.util.LinkedList}'s.

    <p/><a  name = "Examples"/>
    To create an unsynchronized List containing <code>Foo</code>'s, perform the
    following:

    <pre>
final UnsynchronizedLinkedListFactory &lt;Foo&gt; factory =
    new UnsynchronizedLinkedListFactory &lt;Foo&gt; ();

final List list &lt;Foo&gt; = factory.create ();
    </pre>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/impl/UnsynchronizedLinkedListFactory.java $
    </pre>

    @param <V> The value that will be stored in {@link java.util.List}'s.

    @see java.util.LinkedList
    @see java.util.List
 
*/
public final class UnsynchronizedLinkedListFactory <V> implements ListFactoryIfc <V>
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

    /**
     *
     * For serialization purposes.
     *
     */
    private static final long serialVersionUID = 5380109993326579319L;


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
        LogFactory.getLog ( UnsynchronizedLinkedListFactory.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor only allowed to self and class.
     *
     */
    public UnsynchronizedLinkedListFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New unsynchdonized linked list factory created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Creates and returns a {@link java.util.LinkedList}.
     *
     * @return A {@link java.util.LinkedList}.
     *
     */
    public List <V> create ()
    {
        final List <V> retVal = new LinkedList <V> ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created new linked list [" + retVal + "]" );
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
