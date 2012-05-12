package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive defines a template and cannot be used stand-alone - meaning
 * it must be constructed with directive container.  This a handy directive
 * that can house a directive container and use this container when asked by
 * a container to translate - so it acts as a template - the template is
 * contained in the contained directive container.
 *
 */
public final class TemplateDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is our directive container.
     *
     */
    private final DirectiveContainerIfc _directiveContainer;

    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private TemplateDirective ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor sets our directive container.
     *
     * @param directiveContainer represents the directive container to copy.
     *
     */
    public TemplateDirective ( final DirectiveContainerIfc directiveContainer )
    {
        _directiveContainer = directiveContainer;
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
        return _directiveContainer.translate ( container );
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
        return new TemplateDirective ( _directiveContainer.createCopy () );
    }

    /**
     *
     * This method will return our directive container.
     *
     * @return our directive container.
     *
     */
    public DirectiveContainerIfc getDirectiveContainerIfc ()
    {
        return _directiveContainer;
    }
}
