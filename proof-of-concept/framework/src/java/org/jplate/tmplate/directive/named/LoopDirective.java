package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.TranslatorIfc;
import org.jplate.tmplate.directive.util.Translator;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This directive will perform a loop <code>N</code> times requesting all
 * children to translate and concatenating the results during the loop.  The
 * number of iterations is contained in the required parameter count.  If you
 * wish the iteration count to be stored, define the optional parameter loop.
 *
 * <p>
 * Assume that self is named <code>Loop</code>:
 *
 * <pre>
 * ${Loop count="3"}
 *    Hello World
 * ${/Loop}
 * </pre>
 *
 * Will yield:
 *
 * <pre>
 *    Hello World
 *    Hello World
 *    Hello World
 * </pre>
 *
 * @see #LOOP_PARAM
 * @see #COUNT_PARAM
 *
 */
public final class LoopDirective implements NamedDirectiveIfc
{
    /**
     *
     * This parameter defines variable who will contain the loop count.  This is
     * an optional parameter.
     *
     */
    public static final String LOOP_PARAM = "loop";

    /**
     *
     * This parameter contains the number pertaining to loop iteration - 
     * specifically it is the total number of loops that should be performed.
     * This is a required parameter.
     *
     */
    public static final String COUNT_PARAM = "count";

    /**
     *
     * This is the default constructor.
     *
     */
    public LoopDirective ()
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

        final String countValue = env.getRequiredValue ( COUNT_PARAM );
        final String loopValue  = env.getValue         ( LOOP_PARAM  );

        int jplateLoopMax = 0;

        try
        {
            jplateLoopMax = Integer.parseInt ( countValue );
        }

        catch ( final Exception exception )
        {
            throw new JPlateException ( exception );
        }

        final StringBuffer sb = new StringBuffer ();

        final TranslatorIfc translator = Translator.getSingleton ();

        for ( int jplateLoop = 0; jplateLoop < jplateLoopMax; jplateLoop++ )
        {
            if ( loopValue != null )
            {
                env.setValue ( loopValue, Integer.toString ( jplateLoop ) );
            }

            sb.append ( translator.translateChildren ( container ) );
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
        return new LoopDirective ();
    }
}
