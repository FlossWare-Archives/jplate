package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive retrieves a property using the required parameter <code>name
 * </code>.  The value found is returned upon translation.  If the property is
 * not defined the default value <code>""</code> is returned.  To use a
 * different default value, define the parameter <code>default</code>.
 *
 * <p>
 * Assume self is defined as <code>GetProperty</code> and the property named
 * <code>ant.home </code> is <code>/home/tools/ant/LATEST</code>:
 *
 * <pre>
 * Ant is located at:  ${GetProperty name="ant.home"/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * Ant is located at:  /home/tools/ant/LATEST
 * </pre>
 *
 * Assume the aforementioned but no value exists for the property <code>ant.home
 * </code> and a default value of <code>***DOES NOT EXIST**</code> is specified:
 *
 * <pre>
 * Ant home is:  ${GetProperty name="ant.home" default="***DOES NOT EXIST***"/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * Ant home is:  ***DOES NOT EXIST***
 * </pre>
 *
 * @see #PROPERTY_PARAM
 * @see #DEFAULT_PARAM
 *
 */
public final class GetPropertyDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the property name.
     *
     */
    public static final String PROPERTY_PARAM = "name";

    /**
     *
     * This is the default name.
     *
     */
    public static final String DEFAULT_PARAM = "default";

    /**
     *
     * This is the default constructor.
     *
     */
    public GetPropertyDirective ()
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

        final String propertyValue = env.getRequiredValue ( PROPERTY_PARAM    );
        final String defaultValue  = env.getValue         ( DEFAULT_PARAM, "" );

        return System.getProperties().getProperty (propertyValue, defaultValue);
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
        return new GetPropertyDirective ();
    }
}
