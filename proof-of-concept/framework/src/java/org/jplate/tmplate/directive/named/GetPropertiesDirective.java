package org.jplate.tmplate.directive.named;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This directive retrieves all properties using the names/values upon
 * translation.
 *
 * <p>
 * Assume self is named GetProperties and there are two system properties that
 * are <code>ant.home=/home/tools/ant/Latest</code> and <code>os.name=Linux
 * </code>:
 *
 * <pre>
 * ${GetProperties/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * System properties:
 * -- listing properties --
 * os.name=Linux
 * ant.home=/home/tools/ant/LATEST
 * </pre>
 *
 * @see java.lang.System#getProperties
 *
 */
public final class GetPropertiesDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the default constructor.
     *
     */
    public GetPropertiesDirective ()
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
        final StringWriter sw = new StringWriter ();
        final PrintWriter  pw = new PrintWriter  ( sw );

        System.getProperties ().list ( pw );

        return sw.getBuffer ().toString ();
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
        return new GetPropertiesDirective ();
    }
}
