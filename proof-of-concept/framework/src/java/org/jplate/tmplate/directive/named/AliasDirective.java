package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.cache.InvalidNamedDirectiveException;

import org.jplate.tmplate.directive.util.Translator;

import org.jplate.util.environment.EnvironmentIfc;


/**
 *
 * This directive will alias a collection of directives and collectively refer 
 * them by the value specified for the parameter <code>name</code>.  This is
 * akin to inlining...
 *
 * <p>
 * The named attribute required is <code>name</code> which from the end of the
 * alias directive on can be refered to as a directive with a name of the value
 * of <code>name</code>.
 *
 * <p>
 * For instance, if you were to define an alias as such (assuming this class'
 * directive name is <code>Alias</code>):
 *
 * <pre>
 * ${Alias name="Foo"}
 *     BlahBlah
 * ${/Alias}
 * </pre>
 *
 * You can now use <code>Foo</code> as a fully functioning named directive:
 *
 * <pre>
 * My new reference is ${Foo/}
 * </pre>
 *
 * Please note that <code>Foo</code> is really parsed character data containing
 * 4 spaces plus the characters <code>BlahBlah</code> and above would translate
 * to:
 *
 * <pre>
 * My new reference is
 *     BlahBlah
 * </pre>
 *
 * To remove white space, use the name <code>trimPCDataWhiteSpace</code> before/
 * after the <code>name</code> attribute as such (please note simply defining
 * <code>trimPCDataWhiteSpace</code> signifies whitespace trimming should occur
 * and trims the "normal" whitespace characters - if you wish to trim specific
 * characters, the value of <code>trimPCDataWhiteSpace</code> should contain the
 * characters to trim:
 *
 * <pre>
 * ${Alias name="Foo" trimPCDataWhiteSpace}
 *     BlahBlah
 * ${/Alias}
 * </pre>
 *
 * Based upon the above example, the newly translated text will be:
 *
 * <pre>
 * My new referece is BlahBlah
 * </pre>
 *
 * Please note:  if you want to use characters other than default white space
 * characters, supply a value to <code>trimPCDataWhiteSpace</code>.  The
 * characters contained in the value will be assumed to be white space
 * characters.  If you need to use things like newlines, tabs, etc, you will
 * need to use \\ instead of \.  For instance to simply consider newline as
 * the only white space character, you would do the following:
 *
 * <pre>
 * ${Alias name="Foo" trimPCDataWhiteSpace="\\n"}
 *     BlahBlah
 * ${/Alias}
 * </pre>
 *
 * <b>
 * TO DO:  consider what to do if an alias has already been defined with the
 * same name.
 * </b>
 *
 * @see #NAME_PARAM
 * @see #TRIM_PCDATA_WHITE_SPACE_PARAM
 *
 */
public final class AliasDirective implements NamedDirectiveIfc
{
    /**
     *
     * This denotes the name param of an alias whose value can later be used
     * as a named directive.  This is a required parameter.
     *
     */
    public static final String NAME_PARAM = "name";

    /**
     *
     * This denotes the name of the trimPCDataWhiteSpace param.  If defined,
     * will trim all white space for parsed character data.  Please note if
     * you do not define a value (or define the value as ""), the default
     * white space characters are assumed.  If you supply a value, then the
     * characters contained in the value are considered white space.  If you
     * wish to define white space like new line or tab, you will need to use
     * \\ instead of slash - for instance \\n
     *
     */
    public static final String TRIM_PCDATA_WHITE_SPACE_PARAM =
        "trimPCDataWhiteSpace";

    /**
     *
     * This is the default constructor.
     *
     */
    public AliasDirective ()
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

        final String value = env.getRequiredValue ( NAME_PARAM );

        final DirectiveCacheIfc cache =
            container.getParent ().getDirectiveCache ();

        if ( ! cache.isValidDirectiveName ( value ) )
        {
            final DirectiveContainerIfc copyContainer = container.createCopy ();

            copyContainer.setDirective ( null );

            final String trimPCDDataWhiteSpaceValue = 
                env.getValue ( TRIM_PCDATA_WHITE_SPACE_PARAM );

            if ( trimPCDDataWhiteSpaceValue != null )
            {
                Translator.getSingleton ().trimPCDataWhiteSpace (copyContainer);
            }

            cache.defineNamedDirective
            (
                value, new TemplateDirective ( copyContainer )
            );
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
        return new AliasDirective ();
    }
}
