package org.jplate.tmplate.directive.named;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will request all child directives to translate, but if any
 * exception is raised will simply use the stack trace as the translation.
 *
 * <p>
 * If an exception is raised, the stack trace is included in the translation,
 * separated by a delimiter above and below.  The default delimiter is a new
 * line.  However, to change the delimeter, define the parameter <code>delimiter
 * </code>.
 *
 * @see #DELIMITER_PARAM
 * @see #DEFAULT_DELIMITER
 *
 */
public final class CatchExceptionDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the optional parameter, delimeter.
     *
     */
    public static final String DELIMITER_PARAM = "delimiter";

    /**
     *
     * This is the default delimiter.
     *
     */
    public static final String DEFAULT_DELIMITER = "\n";

    /**
     *
     * This is the default constructor.
     *
     */
    public CatchExceptionDirective ()
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

        final String delimiter =
            env.getValue ( DELIMITER_PARAM, DEFAULT_DELIMITER );
        
        final StringBuffer sb = new StringBuffer ();

        final DirectiveContainerIfc children[] = container.getChildren ();

        final int total = children.length;

        for ( int loop = 0; loop < total; loop++ )
        {
            try
            {
                sb.append ( children [ loop ].translate () );
            }

            catch ( final Exception exception )
            {
                final StringWriter sw = new StringWriter ();
                final PrintWriter  pw = new PrintWriter  ( sw );

                exception.printStackTrace ( pw );

                sb.append ( delimiter );
                sb.append ( sw        );
                sb.append ( delimiter );
            }
        }

        return sb.toString ();
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
        return new CatchExceptionDirective ();
    }
}
