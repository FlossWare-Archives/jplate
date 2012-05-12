package org.jplate.foundation.node.tag;


import org.jplate.foundation.gof.factory.FactoryIfc;

import org.jplate.foundation.node.attribute.AttributeIfc;


/**
 
    Factory for creating implementations of <code>TagContextIfc</code>.


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/tag/TagContextFactoryIfc.java $
    </pre>


    @param <TC> Tag context.

*/
public interface TagContextFactoryIfc <TC extends TagContextIfc <?, ?>>
    extends FactoryIfc <TC>
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
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
