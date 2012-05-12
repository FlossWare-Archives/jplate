package org.jplate.tmplate.directive.util;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

/**
 *
 * This interface defines the API to translate items in a directive container.
 *
 */
public interface TranslatorIfc
{
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
        ( DirectiveContainerIfc directiveContainer,
          DirectiveContainerIfc exceptDirectiveContainer )
            throws JPlateException;
    

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
    public String translateChildren ( DirectiveContainerIfc directiveContainer )
        throws JPlateException;

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
        ( DirectiveContainerIfc directiveContainer,
          NamedDirectiveIfc exceptNamedDirective )
            throws JPlateException;

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
        ( DirectiveContainerIfc directiveContainer, String whiteSpace )
            throws JPlateException;

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
    public String trimWhiteSpace ( DirectiveContainerIfc directiveContainer )
        throws JPlateException;

    /**
     *
     * This method will trim white space from the parsed character data
     * contained in the directive container.
     *
     * @param directiveContainer represents the directive container who houses
     *        the parsed character data.
     *
     * @param whiteSpace represents a string containing the characters to be
     *        considered whitespace.
     *
     * @throws JPlateException if any problems arise trimming the white space.
     *
     */
    public void trimPCDataWhiteSpace
        ( DirectiveContainerIfc directiveContainer, String whiteSpace )
            throws JPlateException;

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
        ( DirectiveContainerIfc directiveContainer )
            throws JPlateException;
}
