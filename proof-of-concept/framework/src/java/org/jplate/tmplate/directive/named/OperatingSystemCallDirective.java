package org.jplate.tmplate.directive.named;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive calls out to the operating system and returns the results.
 * The command to be execute by the OS is defined via the required parameter
 * <code>command</code>.  If the result of the OS call is to be included in
 * translation, please define the option parameter <code>wait</code>.  Please
 * note, <code>wait</code> does not need to contain any value...simply define.
 * Any value defined for <code>wait</code> is simply ignored.
 *
 * <p>
 * Assume self is named <code>OperatingSystem</code> and is run on Unix (or a
 * variant).  Also assume that a directory contains two files, <code>foo.txt
 * </code> and <code>bar.txt</code>:
 *
 * <pre>
 * ${OperatingSystem command="ls" wait/}
 * </pre>
 *
 * Will yield:
 *
 * <pre>
 * foo.txt bar.txt
 * </pre>
 *
 * @see #COMMAND_PARAM
 * @see #WAIT_PARAM
 *
 */
public final class OperatingSystemCallDirective implements NamedDirectiveIfc
{
    /**
     *
     * This required parameter defined the OS commant to execute.
     *
     */
    public static final String COMMAND_PARAM = "command";

    /**
     *
     * This optional parameter denotes that the results of the OS call should
     * wait for completing of the command.
     *
     */
    public static final String WAIT_PARAM = "wait";

    /**
     *
     * This is the default constructor.
     *
     */
    public OperatingSystemCallDirective ()
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
        final String         cmdValue  = env.getRequiredValue ( COMMAND_PARAM );
        final String         waitValue = env.getValue         ( WAIT_PARAM    );

        InputStreamReader isr = null;
        BufferedReader    br  = null;

        try
        {
            final Process process = Runtime.getRuntime ().exec ( cmdValue );

            String retVal;

            if ( waitValue != null )
            {
                isr = new InputStreamReader ( process.getInputStream () );
                br  = new BufferedReader ( isr );

                process.waitFor ();

                final StringBuffer sb = new StringBuffer ();

                String line = "";

                while ( line != null )
                {
                    line = br.readLine ();

                    if ( line != null )
                    {
                        sb.append ( line ).append ( '\n' );
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

        catch ( final Exception exception )
        {
            throw new JPlateException ( exception );
        }

        finally
        {
            if ( br != null )
            {
                try
                {
                    br.close ();
                }

                catch ( final Exception exception )
                {
                    exception.printStackTrace ();
                }
            }

            if ( isr != null )
            {
                try
                {
                    isr.close ();
                }

                catch ( final Exception exception )
                {
                    exception.printStackTrace ();
                }
            }
        }
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
        return new OperatingSystemCallDirective ();
    }
}
