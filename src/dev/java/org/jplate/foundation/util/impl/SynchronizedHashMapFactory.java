package org.jplate.foundation.util.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.util.MapFactoryIfc;


/**

    Factory that creates synchronized {@link java.util.Map}'s backed by
    {@link java.util.HashMap}'s.

    <p/><a  name = "Examples"/>
    To create a synchronized HashMap containing keys <code>Foo</code> and value
    <code>Bar</code>, perform the following:

    <pre>
final SynchronizedHashMapFactory &lt;Foo, Bar&gt; factory =
    new SynchronizedHashMapFactory &lt;Foo, Bar&gt; ();

final Map sMap &lt;Foo, Bar&gt; = factory.create ();
    </pre>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/impl/SynchronizedHashMapFactory.java $
    </pre>

    @param <K> The key type stored in {@link java.util.HashMap}.

    @param <V> The value type stored in {@link java.util.HashMap}.

    @see java.util.HashMap

    @see java.util.Map
 
*/
public final class SynchronizedHashMapFactory <K, V> implements MapFactoryIfc <K, V>
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
    private static final long serialVersionUID = 8707437958124563036L;


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


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( SynchronizedHashMapFactory.class );


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor.
     *
     **/
    public SynchronizedHashMapFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New synchronized hash map factory created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Creates and returns a synchronized {@link java.util.Map} backed by a
     * {@link java.util.HashMap}.
     *
     * @return A synchronized {@link java.util.Map} backed by a
     * {@link java.util.HashMap}
     *
     * @see java.util.Collections#synchronizedMap
     *
     * @see java.util.HashMap
     *
     * @see java.util.Map
     *
     */
    public Map <K,V> create ()
    {
        final Map <K, V> retVal =
            Collections.synchronizedMap ( new HashMap <K, V> () );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created [" + retVal + "]" );
        }

        return retVal;
    }


    /**
     *
     * Cleanup a previsously instantiated <code>Map</code>.  Assuming
     * <code>map</code> is not <code>null</code>, the <code>clear</code> method
     * will be called.
     *
     * @param map The object to clean up.
     *
     */
    public void destroy ( final Map <K,V> map )
    {
        if ( map != null )
        {
            map.clear ();
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Cleared [" + map + "]" );
        }
    }
}
