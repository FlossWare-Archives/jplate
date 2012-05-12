package org.jplate.foundation.node.attribute;


import org.jplate.foundation.gof.factory.ContextFactoryIfc;


/**
 
    Context factory that creates implementations of AttributeIfc.  The context
    here is represented by the attribute's name.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/attribute/AttributeFactoryIfc.java $
    </pre>


    @param <A> An implementation of AttributeIfc.

    @param <N> The name type of the attribute.

*/
public interface AttributeFactoryIfc <A extends AttributeIfc <N, ?>, N>
    extends ContextFactoryIfc <A, N>
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
