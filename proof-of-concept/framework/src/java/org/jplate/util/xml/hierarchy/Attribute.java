package org.jplate.util.xml.hierarchy;

/**
 *
 * This class satisfies the AttributeIfc interface.  It simply holds the name
 * and value.
 *
 */
final class Attribute implements AttributeIfc
{
    /**
     *
     * This is the name of the attribute.
     *
     */
    private final String _name;

    /**
     *
     * This is the value of the attribute.
     *
     */
    private final String _value;

    /**
     *
     * Default constructor is not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private Attribute ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor sets the name and value.
     *
     * @param name represents the name.
     *
     * @param value represents the value.
     *
     */
    Attribute ( final String name, final String value )
    {
        _name  = name;
        _value = value;
    }

    /**
     *
     * This method will return the name.
     *
     * @return the name.
     *
     */
    public String getName ()
    {
        return _name;
    }

    /**
     *
     * This method will return the value.
     *
     * @return the value.
     *
     */
    public String getValue ()
    {
        return _value;
    }
}
