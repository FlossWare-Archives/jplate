package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.Translator;

/**
 *
 * This directive will return the translation of the presented directive
 * container temporarily using the grandparent container as the "parent"
 * container.  This directive is useful when doing things like importing a
 * directive and using that imported directive to contain the contents of the
 * importer directive.
 *
 * <p>
 * Assume self is named <code>GetContent</code> and one is also using the
 * <code>org.jplate.tmplate.directive.named.ImportDirective</code>, named <code>
 * Import</code>:
 *
 * <p>
 * Also assume the following is the importer directive:
 *
 * <pre>
 * ${Import name="Foo" jplate="com.foo.Foo"/}
 *
 * ${Foo}
 *    This is all that is defined
 * ${Foo}
 * </pre>
 *
 * Assume the following defines <code>com.foo.Foo</code>:
 *
 * <pre>
 * This is the Foo directive and contains ${GetContent}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * This is the Foo directive and contains
 *    This is all that is defined
 * </pre>
 *
 * @see org.jplate.tmplate.directive.named.ImportDirective
 *
 */
public final class GetContentDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public GetContentDirective ()
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
        final DirectiveContainerIfc
            grandParent = container.getParent().getParent ();

        return
            Translator.getSingleton ().translateChildren
            (
                grandParent, container
            );
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
        return new GetContentDirective ();
    }
}
