package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will set the values in the parent directive container.  The
 * values set are defined via the name/value parameters.  Please note that no
 * translation occurs and the empty string, <code>""</code>, will be returned.
 *
 * <p>
 * Assume self is named <code>SetValue</code>:
 *
 * <pre>
 * ${SetValue foo="MyFoo" bar="This is bar"/}
 * </pre>
 *
 * Will set <code>foo</code> to be <code>MyFoo</code> and <code>bar</code> will
 * be <code>This is bar</code>.
 *
 */
public final class SetValueDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public SetValueDirective ()
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
            final String value = env.getValue ( name );

            if ( value != null )
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
        return new SetValueDirective ();
    }
}
