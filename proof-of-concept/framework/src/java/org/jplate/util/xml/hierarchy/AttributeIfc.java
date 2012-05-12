package org.jplate.util.xml.hierarchy;

/**
 *
 * This interface defines an attribute.  An attribute is a name and value.
 *
 */
public interface AttributeIfc
{
    /**
     *
     * This method will return the name.
     *
     * @return the name.
     *
     */
    public String getName ();

    /**
     *
     * This method will return the value.
     *
     * @return the value.
     *
     */
    public String getValue ();
}
