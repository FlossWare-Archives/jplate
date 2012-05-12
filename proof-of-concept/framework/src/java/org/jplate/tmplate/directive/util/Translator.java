package org.jplate.tmplate.directive.util;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;
import org.jplate.tmplate.directive.PCDataDirectiveIfc;

/**
 *
 * This class satisfies the TranslatorIfc interface and adheres to the
 * Singleton pattern.  This class will translate items in a directive
 * container.
 *
 */
public final class Translator implements TranslatorIfc
{
    /**
     *
     * This is the default white space to trim.
     *
     */
    public static final String DEFAULT_WHITE_SPACE = "[\n\t\r ]";

    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class TranslatorSingleton
    {
        static final TranslatorIfc _singleton = new Translator ();
    }

    /**
     *
     * Default constructor.
     *
     */
    private Translator ()
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singelton.
     *
     */
    public static TranslatorIfc getSingleton ()
    {
        return TranslatorSingleton._singleton;
    }

    /**
     *
     * This method will take all the children of directiveContainer and request
     * each to translate, returning the concatenation of all.  Please note that
     * exceptDirectiveContainer will be excluded from translation.
     *
     * @param directiveContainer represents the directive container for whom we
     *        want to translate.
     *
     * @param exceptDirectiveContainer represents the child directive container
     *        that will not be included as part of the translation.
     *
     * @return the translation.
     *
     * @throws JPlateException if any problems arise while translating the
     *         children.
     *
     */
    public String translateChildren
        ( final DirectiveContainerIfc directiveContainer,
          final DirectiveContainerIfc exceptDirectiveContainer )
            throws JPlateException
    {
        final DirectiveContainerIfc children[] =
            directiveContainer.getChildren ();

        final int size = children.length;

        String retVal;

        if ( size > 0 )
        {
            final StringBuffer sb = new StringBuffer ();

            for ( int loop = 0; loop < size; loop++ )
            {
                final DirectiveContainerIfc child = children [ loop ];

                if ( child != exceptDirectiveContainer )
                {
                    sb.append ( child.translate () );
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

    /**
     *
     * This method will take all the children of directiveContainer and request
     * each to translate, returning the concatenation of all.
     *
     * @param directiveContainer represents the directive container for whom we
     *        want to translate.
     *
     * @return the translation.
     *
     * @throws JPlateException if any problems arise while translating the
     *         children.
     *
     */
    public String translateChildren
        ( final DirectiveContainerIfc directiveContainer )
            throws JPlateException
    {
        return
            translateChildren
            (
                directiveContainer, ( DirectiveContainerIfc ) null
            );
    }

    /**
     *
     * This method will take all the children of directiveContainer and request
     * each to translate, returning the concatenation of all.  Please note that
     * exceptNamedDirective will be excluded from translation - meaning that if
     * a child directive container has, as its directive exceptNamedDirective,
     * it will be excluded.
     *
     * @param directiveContainer represents the directive container for whom we
     *        want to translate.
     *
     * @param exceptNamedDirective represents the child directive that will not
     *        be included as part of the translation.
     *
     * @return the translation.
     *
     * @throws JPlateException if any problems arise while translating the
     *         children.
     *
     */
    public String translateChildren
        ( final DirectiveContainerIfc directiveContainer,
          final NamedDirectiveIfc exceptNamedDirective )
            throws JPlateException
    {
        final DirectiveContainerIfc children[] =
            directiveContainer.getChildren ();

        final int size = children.length;

        String retVal;

        if ( size > 0 )
        {
            final StringBuffer sb = new StringBuffer ();

            for ( int loop = 0; loop < size; loop++ )
            {
                final DirectiveContainerIfc child = children [ loop ];

                if ( child.getDirective () != exceptNamedDirective )
                {
                    sb.append ( child.translate () );
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

    /**
     *
     * This method will actually trim the white space from the directive
     * container.
     *
     * @param directiveContainer represents the directive container whose white
     *        space will be removed.
     *
     * @param whiteSpace represents a string containing characters to be
     *        considered whitespace.
     *
     * @return the directive container's white space removed.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    private String trimActualWhiteSpace
        ( final DirectiveContainerIfc directiveContainer, 
          final String whiteSpace )
            throws JPlateException
    {
        return directiveContainer.translate ().replaceAll ( whiteSpace, "" );
    }

    /**
     *
     * This method will trim white space from the directive container.
     *
     * @param directiveContainer represents the directive container whose white
     *        space will be removed.
     *
     * @param whiteSpace represents a string containing characters to be
     *        considered whitespace.
     *
     * @return the directive container's white space removed.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    public String trimWhiteSpace
        ( final DirectiveContainerIfc directiveContainer, 
          final String whiteSpace )
            throws JPlateException
    {
        String actualWhiteSpace;

        if ( "".equals ( whiteSpace ) )
        {
            actualWhiteSpace = DEFAULT_WHITE_SPACE;
        }
        else
        {
            final StringBuffer sb =
                new StringBuffer ( 2 + whiteSpace.length () );

            sb.append ( '[' ).append ( whiteSpace ).append ( ']' );

            actualWhiteSpace = sb.toString ();
        }

        return trimActualWhiteSpace ( directiveContainer, actualWhiteSpace );
    }

    /**
     *
     * This method will trim white space from the directive container using
     * default white space characters.
     *
     * @param directiveContainer represents the directive container whose white
     *        space will be removed.
     *
     * @return the directive container's white space removed.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    public String trimWhiteSpace
        ( final DirectiveContainerIfc directiveContainer )
            throws JPlateException
    {
        return trimActualWhiteSpace ( directiveContainer, DEFAULT_WHITE_SPACE );
    }

    /**
     *
     * This method will actually trim the white space from the parsed character
     * data contained in the directive container.
     *
     * @param directiveContainer represents the directive container who houses
     *        the parsed character data.
     *
     * @param whiteSpace represents a string containing characters to be
     *        considered whitespace.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    private void trimActualPCDataWhiteSpace
        ( final DirectiveContainerIfc directiveContainer,
          final String whiteSpace )
            throws JPlateException
    {
        final DirectiveContainerIfc children[] =
            directiveContainer.getChildren ();

        final int totalChildren = children.length;

        for ( int loop = 0; loop < totalChildren; loop++ )
        {
            final DirectiveIfc directive = children [ loop ].getDirective ();

            if ( directive instanceof PCDataDirectiveIfc )
            {
                final PCDataDirectiveIfc pcDataDirective =
                    ( PCDataDirectiveIfc ) directive;

                pcDataDirective.setPCData
                (
                    pcDataDirective.getPCData ().replaceAll ( whiteSpace, "" )
                );
            }
        }
    }

    /**
     *
     * This method will trim white space from the parsed character data
     * contained in the directive container.
     *
     * @param directiveContainer represents the directive container who houses
     *        the parsed character data.
     *
     * @param whiteSpace represents a string containing characters to be
     *        considered whitespace.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    public void trimPCDataWhiteSpace
        ( final DirectiveContainerIfc directiveContainer,
          final String whiteSpace )
            throws JPlateException
    {
        String actualWhiteSpace;

        if ( "".equals ( whiteSpace ) )
        {
            actualWhiteSpace = DEFAULT_WHITE_SPACE;
        }
        else
        {
            final StringBuffer sb =
                new StringBuffer ( 2 + whiteSpace.length () );

            sb.append ( '[' ).append ( whiteSpace ).append ( ']' );

            actualWhiteSpace = sb.toString ();
        }

        trimActualPCDataWhiteSpace ( directiveContainer, actualWhiteSpace );
    }

    /**
     *
     * This method will trim white space from the parsed character data
     * contained in the directive container using default white space
     * characters.
     *
     * @param directiveContainer represents the directive container who houses
     *        the parsed character data.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    public void trimPCDataWhiteSpace
        ( final DirectiveContainerIfc directiveContainer )
            throws JPlateException
    {
        trimActualPCDataWhiteSpace ( directiveContainer, DEFAULT_WHITE_SPACE );
    }
}
