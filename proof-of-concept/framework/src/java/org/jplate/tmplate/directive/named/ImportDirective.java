package org.jplate.tmplate.directive.named;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.JPlateNotFoundException;

import org.jplate.tmplate.directive.cache.InvalidNamedDirectiveException;

import org.jplate.tmplate.directive.util.DirectiveContainerFacadeIfc;
import org.jplate.tmplate.directive.util.DirectiveContainerFacade;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * <p>
 * This directive will import a jplate file and parse it - making it available
 * to the environment.  Please use dots to deliniate directory names - just like
 * one would do with a fully qualified class name - and no extension!!!
 *
 * <p>
 * The extension for the jplate file is "<code>.jp</code>"
 *
 * Also, make sure the jplate file can be found via the classpath...
 *
 * <p>
 * The name of the imported directive is specified via the required parameter
 * name.  The jplate file is defined via the required parameter <code>jplate
 * </code>.
 *
 * <p>
 * Please note:  finding the jplate contents uses
 * <code>getClass ().getResourceAsStrean ()</code>
 *
 * <p>
 * Assume self is named Import:
 *
 * <pre>
 * ${Import name="Foo" jplate="com.foo.Foo"/}
 * </pre>
 *
 * This will create a named directive, <code>Foo</code>, whose value is
 * whatever is defined in the resource <code>com/foo/Foo.jp</code>.
 *
 * @see #NAME_PARAM
 * @see #JPLATE_NAME_PARAM
 * @see java.lang.Class#getResourceAsStream
 *
 */
public final class ImportDirective implements NamedDirectiveIfc
{
    /**
     *
     * This required parameter denotes the name of the newly imported directive.
     *
     */
    public static final String NAME_PARAM = "name";
    
    /**
     *
     * This required parameter denotes the jplate name - specifically the
     * resource containing the jplate data.
     *
     */
    public static final String JPLATE_NAME_PARAM = "jplate";

    /**
     *
     * This is the extension for all jplate file names...
     *
     */
    public static final String FILE_EXTENSION = ".jp";

    /**
     *
     * This is the default constructor.
     *
     */
    public ImportDirective ()
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

        final String value       = env.getRequiredValue ( NAME_PARAM        );
        final String jplateValue = env.getRequiredValue ( JPLATE_NAME_PARAM );

        final String jplateFileName = jplateValue.replace ( '.', '/' );

        final StringBuffer sb = new StringBuffer ();
        sb.append ( '/' );
        sb.append ( jplateFileName );
        sb.append ( ".jp" );

        final InputStream is =
            getClass ().getResourceAsStream ( sb.toString () );

        if ( is == null )
        {
            throw new JPlateNotFoundException ( jplateValue );
        }

        BufferedReader    br  = null;
        InputStreamReader isr = null;
        
        try
        {
            isr = new InputStreamReader ( is  );
            br  = new BufferedReader    ( isr );

            final DirectiveContainerFacadeIfc facade =
                DirectiveContainerFacade.getSingleton ();

            final DirectiveCacheIfc cache = container.getDirectiveCache (); 

            final DirectiveContainerIfc newContainer =
                facade.convertFromReader ( br, cache );

            cache.defineNamedDirective
            (
                value, new TemplateDirective ( newContainer.createCopy () )
            );
        }

        catch ( final JPlateException jplateException )
        {
            throw jplateException;
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
        return new ImportDirective ();
    }
}
