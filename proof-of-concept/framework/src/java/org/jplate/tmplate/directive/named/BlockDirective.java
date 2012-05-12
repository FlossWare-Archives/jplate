package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.util.environment.EnvironmentIfc;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.util.TranslatorIfc;
import org.jplate.tmplate.directive.util.Translator;

/**
 *
 * This directive allows one to block off a section of directives.  It is just
 * a convenience directive.  One can use the block directive to trim all
 * the white space from the parsed character data.
 *
 * <p>
 * To trim the white space from the parsed character data, define the parameter
 * <code>trimPCDataWhiteSpace</code>.
 *
 * <p>
 * Please note:  if you want to use characters other than default white space
 * characters, supply a value to <code>trimPCDataWhiteSpace</code>.  The
 * characters contained in the value will be assumed to be white space
 * characters.  If you need to use things like newlines, tabs, etc, you will
 * need to use \\ instead of \.  For instance to simply consider newline as the
 * only white space character, you would do the following (assume self is named
 * <code>Block</code>:
 *
 * <pre>
 * ${Block trimPCDataWhiteSpace="\\n"}
 *     BlahBlah
 * ${/Block}
 * </pre>
 *
 * @see #TRIM_PCDATA_WHITE_SPACE_PARAM
 *
 */
public final class BlockDirective implements NamedDirectiveIfc
{
    /**
     *
     * This denotes the parameter of the trimPCDataWhiteSpace name.  If defined,
     * will trim all white space for parsed character data.  Please note the
     * value of this parameter is not used - simply defining this parameter
     * is a sufficient hint.
     *
     */
    public static final String TRIM_PCDATA_WHITE_SPACE_PARAM =
        "trimPCDataWhiteSpace";

    /**
     *
     * This is the default constructor.
     *
     */
    public BlockDirective ()
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
        
        final TranslatorIfc translator = Translator.getSingleton ();

        if ( env.getValue ( TRIM_PCDATA_WHITE_SPACE_PARAM ) != null )
        {
            translator.trimPCDataWhiteSpace ( container );
        }

        return translator.translateChildren ( container );
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
        return new BlockDirective ();
    }
}
