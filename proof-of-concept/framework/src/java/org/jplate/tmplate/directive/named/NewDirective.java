package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.cache.InvalidDirectiveCacheException;
import org.jplate.tmplate.directive.cache.InvalidNamedDirectiveException;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will define a directive in the parent's directive factory.
 * The directive is named via the required parameter name.  Its class is defined
 * via the required parameter class.
 *
 * <p>
 * Assume self is named <code>Named</code>:
 *
 * <pre>
 * ${Named name="Foo" class="com.example.foo.FooDirective"/}
 * </pre>
 *
 * The aforementioned will create named directive, <ode>Foo</code>, whose class
 * is <code>com.example.foo.FooDirective</code>.
 *
 * <p>
 * Please note, no textual translation occurs.  The translation is the empty
 * string, <code>""</code>.
 *
 * @see #NAME_PARAM
 * @see #CLASS_PARAM
 *
 */
public final class NewDirective implements NamedDirectiveIfc
{
    /**
     *
     * This required parameter defines the name of the newly instantiated
     * directive.
     *
     */
    public static final String NAME_PARAM= "name";

    /**
     *
     * This required parameter defines the fully qualified class name of a class
     * that impements NamedDirectiveIfc.
     *
     */
    public static final String CLASS_PARAM = "class";

    /**
     *
     * This is the default constructor.
     *
     */
    public NewDirective ()
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

        final String nameValue  = env.getRequiredValue ( NAME_PARAM  );
        final String classValue = env.getRequiredValue ( CLASS_PARAM );

        final DirectiveContainerIfc parent = container.getParent ();

        final DirectiveCacheIfc directiveCache = parent.getDirectiveCache ();

        if ( directiveCache == null )
        {
            throw new InvalidDirectiveCacheException ();
        }

        try
        {
            final Class namedDirectiveClass = Class.forName ( classValue );

            final NamedDirectiveIfc namedDirective =
                ( NamedDirectiveIfc ) namedDirectiveClass.newInstance ();

            directiveCache.defineNamedDirective ( nameValue, namedDirective );
        }

        catch ( final Exception exception )
        {
            throw new InvalidNamedDirectiveException
            (
                nameValue + " - " + classValue, exception
            );
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
        return new NewDirective ();
    }
}
