package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.FindValueIfc;
import org.jplate.tmplate.directive.util.FindValue;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will return the values of names.  If more than one name is
 * expressed it will be concatenated together.  Please note, if a value cannot
 * be found in the parent, it will be sought after higher up (i.e., the
 * grandparent).  If no value is found, the nothing is added as part of the
 * translation.
 *
 * <p>
 * Assume self is named <code>GetValue</code>, <code>foo</code> has <code>Foo
 * </code> as a value, <code>bar</code> has <code>Bar</code> as a value and
 * <code>z</code> has <code>Zeta</code> as a value:
 *
 * <pre>
 * The values are:  ${GetValue foo bar z/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * The values are:  FooBarZeta
 * </pre>
 *
 */
public final class GetValueDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public GetValueDirective ()
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
        final EnvironmentIfc env       = container.getEnvironment ();
        final String         names[]   = env.getNames ();
        final FindValueIfc   findValue = FindValue.getSingleton ();

        final int size = names.length;

        String retVal;

        if ( size > 0 )
        {
            final StringBuffer sb = new StringBuffer ();

            for ( int loop = 0; loop < size; loop++ )
            {
                final String value =
                    findValue.findValue
                    (
                        container.getParent (), names [ loop ]
                    );

                if ( value != null )
                {
                    sb.append ( value );
                }
            }

            retVal = sb.toString ();
 
        }
        else
        {
            retVal = "";
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
        return new GetValueDirective ();
    }
}
