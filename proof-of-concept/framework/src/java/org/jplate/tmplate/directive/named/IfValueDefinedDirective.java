package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.FindValue;
import org.jplate.tmplate.directive.util.Translator;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will translate child directives if a value is defined for the
 * required parameter name.
 *
 * <p>
 * Assume self is named <code>IfValue</code> and <code>foo</code> is defined as
 * <code>Foo</code>:
 *
 * <pre>
 * ${IfValue name="foo"}
 *    Its Defined!!!
 * ${/IfValue}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 *    Its Defined!!!
 * </pre>
 *
 * Assuming <code>foo</code> is not defined will yield the empty string, <code>
 * ""</code>, upon translation.
 *
 * @see #NAME_PARAM
 *
 */
public final class IfValueDefinedDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the name to look for if defined.
     *
     */
    public static final String NAME_PARAM = "name";

    /**
     *
     * This is the default constructor.
     *
     */
    public IfValueDefinedDirective ()
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
        final String value =
            container.getEnvironment ().getRequiredValue ( NAME_PARAM );

        final String actualValue =
            FindValue.getSingleton ().findValue (container.getParent (), value);

        String retVal;

        if ( actualValue != null )
        {
            retVal = Translator.getSingleton ().translateChildren ( container );
        }
        else
        {
            retVal ="";
        }

        return retVal;
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
        return new IfValueDefinedDirective ();
    }
}
