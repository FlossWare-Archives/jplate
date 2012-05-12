package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.FindValueIfc;
import org.jplate.tmplate.directive.util.FindValue;

import org.jplate.util.environment.EnvironmentIfc;
import org.jplate.util.environment.ValueNotFoundException;

/**
 *
 * This directive will make sure a value has been set in the parent directive
 * container via the parameters specified.  Please note if any values are
 * specified for the parameters, they will be ignored.  Also note, no
 * translation occurs - i.e. upon translation the emptry string, <code>""
 * </code>, is returned.
 *
 * <p>
 * Assume self is named <code>RequiredName</code>:
 *
 * <pre>
 * ${RequiredValue foo bar/}
 * </pre>
 *
 * If <code>foo</code> and <code>bar</code> have not been defined a
 * <code>ValueNotFoundException</code> is raised on translation.  If both
 * <code>foo</code> and <code>bar</code> are defined, no exception is raised.
 *
 * @see org.jplate.util.environment.ValueNotFoundException
 *
 */
public final class RequiredValueDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public RequiredValueDirective ()
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
        final EnvironmentIfc env     = container.getEnvironment ();
        final String         names[] = env.getNames ();

        final int size = names.length;

        final DirectiveContainerIfc parent = container.getParent ();
        
        final FindValueIfc findValue = FindValue.getSingleton ();

        for ( int loop = 0; loop < size; loop++ )
        {
            final String name = names [ loop ];

            if ( findValue.findValue ( parent, name ) == null )
            {
                throw new ValueNotFoundException ( name );
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
        return new RequiredValueDirective ();
    }
}
