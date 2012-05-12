package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive sets a property whose name is defined by the required
 * parameter <code>name</code> and whose value is defined by the required
 * parameter <code>value</code>.  Please note upon translation a <code>System
 * <code>property will be set, but the empty string will be returned.
 *
 * <p>
 * Assume self is name <code>SetProperty</code>:
 *
 * <pre>
 * ${SetProperty name="foo" value="bar"/}
 * </pre>
 *
 * Will set a <code>System</code> proprty whose name is <code>foo</code> and
 * whose value is <code>bar</code>.
 *
 * @see #PROPERTY_PARAM
 * @see #VALUE_PARAM
 *
 */
public final class SetPropertyDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is required parameter represents System property name.
     *
     */
    public static final String PROPERTY_PARAM = "name";

    /**
     *
     * This required parameter represents the value for the System property.
     *
     */
    public static final String VALUE_PARAM = "value";

    /**
     *
     * This is the default constructor.
     *
     */
    public SetPropertyDirective ()
    {
    }

    /**
     *
     * This method requests that the data container in container be translated.
     *
     * @param container represents the directive container where translation
     *        will be done.
     *
     * @return the contents of container translated.
     *
     * @throws JPlateException if any problems arise performing translation for
     *         container.
     *
     */
    public String translate ( final DirectiveContainerIfc container )
        throws JPlateException
    {
        final EnvironmentIfc env = container.getEnvironment ();

        final String propertyValue = env.getRequiredValue ( PROPERTY_PARAM );
        final String value         = env.getRequiredValue ( VALUE_PARAM    );

        System.getProperties ().setProperty ( propertyValue, value );

        return "";
    }

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public NamedDirectiveIfc createCopy ()
    {
        return new SetPropertyDirective ();
    }
}
