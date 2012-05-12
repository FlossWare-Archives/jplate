package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.FindValueIfc;
import org.jplate.tmplate.directive.util.FindValue;
import org.jplate.tmplate.directive.util.Translator;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive uses all the parameters to see if there values are equal to
 * the values specified.  For example, assume self is defined via the name
 * <code>IfValueEqual</code>:
 *
 * <pre>
 * ${IfValueEqual foo="Foo Value" bar="Bar Value"}
 *     The values are equal
 * ${/IfValueEqual}
 * </pre>
 *
 * If both <code>foo</code> and <code>bar</code> have, as their values, the
 * aforementioned, the translation will be
 *
 * <pre>
 *    The values are equal
 * </pre>
 *
 * Otherwise, the empty string, <code>""</code>, will be the translation value.
 *
 */
public final class IfValueEqualDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public IfValueEqualDirective ()
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
        final DirectiveContainerIfc parent = container.getParent ();

        final EnvironmentIfc env = container.getEnvironment ();

        final String names[] = env.getNames ();

        final int total = names.length;

        final FindValueIfc fv = FindValue.getSingleton ();

        boolean isToTranslate = ( total > 0 );

        for ( int loop = 0; loop < total && isToTranslate; loop++ )
        {
            final String name = names [ loop ];

            final String value = env.getValue ( name ); 

            final String compareValue = fv.findValue ( parent, name );

            isToTranslate = value.equals ( compareValue );
        }
        
        return
            ! isToTranslate ? "" :
            Translator.getSingleton ().translateChildren ( container );
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
        return new IfValueEqualDirective ();
    }
}
