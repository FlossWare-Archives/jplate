package org.jplate.foundation.node.tag;


import java.util.List;

import org.jplate.foundation.node.attribute.AttributeIfc;


/**
 
    Tag context provides a tag (as denoted by the <code>T</code> param and
    attributes (name/value pairs as denoted by tge <code>A</code> param).


    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/tag/TagContextIfc.java $
    </pre>


    @param <T>  The tag type.

    @param <A>  Attributes associated with this tag.

*/
public interface TagContextIfc <T, A extends AttributeIfc <?, ?>>
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


    /**
     *
     * Returns the tag of the context.
     *
     * @return The tag of the context..
     *
     */
    public T getTag ();


    /**
     *
     * Sets the tag of the context.
     *
     * @param tag The new tag of the context.
     *
     */
    public void setTag ( T tag );


    /**
     *
     * Returns the attributes allowing them to be modified externally (for instance
     * adding or modifying).
     *
     * @return The attributes.
     *
     */
    public List <A> getAttributes ();
}
