package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will pause for <code>N</code> milliseconds.  The pause time is
 * defined via the required parameter <code>time</code>.  When requested to
 * translate the empty string, <code>""</code> will be returned after <code>N
 * </code> milliseconds.
 *
 * <p>
 * Assume self is named <code>Pause</code>:
 *
 * <pre>
 * ${Pause time="3000"/}
 * </pre>
 *
 * Will pause three seconds and return the empty string.
 *
 * @see #TIME_PARAM
 *
 */
public final class PauseDirective implements NamedDirectiveIfc
{
    /**
     *
     * This required parameter denotes the number of milliseconds to pause.
     *
     */
    public static final String TIME_PARAM = "time";

    /**
     *
     * This is the default constructor.
     *
     */
    public PauseDirective ()
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
        
        final String timeValue = env.getRequiredValue ( TIME_PARAM );
        
        try
        {
            final long pauseTime = Long.parseLong ( timeValue );

            final byte waiter[] = new byte [ 0 ];

            synchronized ( waiter )
            {
                waiter.wait ( pauseTime );
            }
        }

        catch ( final Exception exception )
        {
            throw new JPlateException ( exception );
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
        return new PauseDirective ();
    }
}
