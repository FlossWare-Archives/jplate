package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will copy a directive named via the <code>oldName</code>
 * parameter to the <code>newName</code> parameter.  Please note no translation
 * occurs and will return the emptry string, <code>""</code>.
 *
 * <p>
 * Assume self is named <code>Copy</code> and a directive exists by the name
 * <code>Foo</code>:
 *
 * <pre>
 * ${Copy oldName="Foo" newName="Bar"/}
 * </pre>
 *
 * Will now have a directive named <code>Bar</code> who is the same directive as
 * that defined by <code>Foo</code>.
 *
 * @see #OLD_NAME_PARAM
 * @see #NEW_NAME_PARAM
 *
 */
public final class CopyDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the parameter used to represent the old directive name.  This is
     * a required parameter.
     *
     */
    public static final String OLD_NAME_PARAM = "oldName";

    /**
     *
     * This is the parameter used to represent the new directive name.  This is
     * a required parameter.
     *
     */
    public static final String NEW_NAME_PARAM = "newName";

    /**
     *
     * This is the default constructor.
     *
     */
    public CopyDirective ()
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

        final String oldValue = env.getRequiredValue ( OLD_NAME_PARAM );
        final String newValue = env.getRequiredValue ( NEW_NAME_PARAM );

        final DirectiveCacheIfc cache = container.getDirectiveCache ();

        cache.copyNamedDirective ( oldValue, newValue );

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
        return new CopyDirective ();
    }
}
