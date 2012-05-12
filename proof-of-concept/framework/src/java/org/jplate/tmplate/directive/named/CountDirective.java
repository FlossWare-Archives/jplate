package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This directive simply keeps a count of how many time its been requested to
 * parse.  The count is returned for translation.
 *
 * <p>
 * Assume self is named <code>Count</code> and has been called five times:
 *
 * <pre>
 * ${Count/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * 5
 * </pre>
 *
 */
public final class CountDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the count.
     *
     */
    private int _count;

    /**
     *
     * This is the default constructor.
     *
     */
    public CountDirective ()
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
        return Integer.toString ( ++_count );
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
        return new CountDirective ();
    }
}
