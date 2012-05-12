package org.jplate.foundation.util;


import java.util.Map;

import org.jplate.foundation.gof.factory.FactoryIfc;


/**

    Defines the API to create implementations of {@link java.util.Map}.  This
    interface is useful in scenarios where a class needs to be able to create
    implementations of Map, but desires to create those implementations independant
    of another class performing the instantiation.  Additionally, the JDK does not
    provide Map factories as defined here.

    For example implementations, please refer to
    <ul>
        <li>
            {@link org.jplate.foundation.util.impl.SynchronizedHashMapFactory}
        </li>

        <li>
            {@link org.jplate.foundation.util.impl.UnsynchronizedHashMapFactory}
        </li>
    </ul>

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/MapFactoryIfc.java $
    </pre>

    @param <K> The key type stored in {@link java.util.Map}'s.

    @param <V> The value type stored in @{link java.util.Map}'s.

    @see java.util.Map

    @see org.jplate.foundation.gof.factory.FactoryIfc

    @see org.jplate.foundation.util.impl.SynchronizedHashMapFactory

    @see org.jplate.foundation.util.impl.UnsynchronizedHashMapFactory

*/
public interface MapFactoryIfc <K, V> extends FactoryIfc <Map <K, V>>
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


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
