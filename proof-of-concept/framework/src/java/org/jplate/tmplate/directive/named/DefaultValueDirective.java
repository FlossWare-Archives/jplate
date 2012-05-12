package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will set the default value of names defined as parameters.
 * Please note: if the name is presently set, no action will occur.  Also note
 * that when translating, the empty string, <code>""</code>, is returned.
 *
 * <p>
 * Assume self is named <code>DefaultValue</code>:
 *
 * <pre>
 * ${DefaultValue foo="Fooo" bar="Barrrr"/}
 * </pre>
 *
 * Will set the value of <code>foo</code> to <code>Fooo</code> if not already
 * set and <code>bar</code> to <code>Barrrr</code> if <code>bar</code> is not
 * set.
 *
 */
public final class DefaultValueDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public DefaultValueDirective ()
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
        final EnvironmentIfc        env       = container.getEnvironment ();
        final String                names[]   = env.getNames ();
        final DirectiveContainerIfc parent    = container.getParent ();
        final EnvironmentIfc        parentEnv = parent.getEnvironment ();

        final int size = names.length;

        for ( int loop = 0; loop < size; loop++ )
        {
            final String name  = names [ loop ];
            final String value = env.getRequiredValue ( name );

            final String parentValue = parentEnv.getValue ( name );

            if ( parentValue == null )
            {
                parentEnv.setValue ( name, value );
            }
        }

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
        return new DefaultValueDirective ();
    }
}
