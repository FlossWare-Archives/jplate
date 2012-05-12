package org.jplate.util.xml.hierarchy;

/**
 *
 * This interface defines a hierarchy.  A hierarchy has a name, attributes,
 * children and one parent.  If the parent is null, this is the root.
 *
 */
public interface HierarchyIfc
{
    /**
     *
     * This method will return the name of the hierarchy.
     *
     * @return the name of the hierarchy.
     *
     */
    public String getName ();

    /**
     *
     * This method will return the value of the hierarchy.
     *
     * @return the value.
     *
     */
    public String getValue ();

    /**
     *
     * This method will return the attributes.
     *
     * @return the attributes.
     *
     */
    public AttributeIfc[] getAttributes();

    /**
     *
     * This method will return the parent.
     *
     * @return the parent or null if no parent exists.
     *
     */
    public HierarchyIfc getParent ();

    /**
     *
     * This method will return the children or an array of length 0 if no
     * children exist.
     *
     * @return an array of children or a zero length array if no children
     *         exist.
     *
     */
    public HierarchyIfc[] getChildren ();
}
