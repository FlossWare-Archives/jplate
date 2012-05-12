package org.jplate.tmplate.directive.named;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This directive will return the date and/or time upon translation.  The date/
 * time is computed via the required parameter, format.  The value of format
 * should be similarly structured to formats defined via
 * <code>java.text.SimpleDateFormat</code> as that is the class used.
 *
 * <p>
 * Assume self is named <code>Date</code>, the time is 11:25:04 pm:
 *
 * <pre>
 * Current time:  ${Date format="KK:mm:ss a"/}
 * </pre>
 *
 * Will translate to:
 *
 * <pre>
 * Current time:  11:25:04 PM
 * </pre>
 *
 * @see #FORMAT_PARAM
 * @see java.text.SimpleDateFormat
 *
 */
public final class DateDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the parameter containing the format of the date/time.  This is a
     * required parameter.
     *
     */
    public static final String FORMAT_PARAM = "format";

    /**
     *
     * This is the default constructor.
     *
     */
    public DateDirective ()
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
        final String formatValue = 
            container.getEnvironment ().getRequiredValue ( FORMAT_PARAM );

        final Date             now = new Date ();
        final SimpleDateFormat sdf = new SimpleDateFormat ( formatValue );
        
        return sdf.format ( now ).toString ();
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
        return new DateDirective ();
    }
}
