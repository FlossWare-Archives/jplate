package org.jplate.tmplate.directive.util;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveDefIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.parserstrategy.DirectiveParserStrategyIfc;

import org.jplate.tmplate.parser.JPlateParser;

/**
 *
 * This interface defines the facade for creating directive containers.
 *
 */
public interface DirectiveContainerFacadeIfc
{
    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromReader
        ( Reader toConvert, DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the Cache containing named directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromReader
        ( Reader toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromReader
        ( Reader toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromReader ( Reader toConvert )
        throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromInputStream
        ( InputStream toConvert, 
          DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the Cache containing named directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromInputStream
        ( InputStream toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromInputStream
        ( InputStream toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromInputStream
        ( InputStream toConvert )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFile
        ( File toConvert, DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the Cache containing named directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFile
        ( File toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFile
        ( File toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFile ( File toConvert )
        throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFileName
        ( String toConvert, DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the Cache containing named directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFileName
        ( String toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFileName
        ( String toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromFileName ( String toConvert )
        throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromResource
        ( String toConvert, DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the cache containing directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromResource
        ( String toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromResource
        ( String toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromResource ( String toConvert )
        throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container
     * using directiveParserStrategy as the strategy for parsing.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveParserStrategy represents the strategy to use when
     *        parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromString
        ( String toConvert, DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveFactory.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directiveCache represents the cache containing directives
     *        when parsing.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromString
        ( String toConvert, DirectiveCacheIfc directiveCache )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromString
        ( String toConvert, NamedDirectiveDefIfc directives[] )
            throws JPlateException;

    /**
     *
     * This method will take toConvert and convert to a directive container.
     *
     * @param toConvert contains the data to convert to a directive container.
     *
     * @param directives represent an array of named directives that will be
     *        used when creating the return value.
     *
     * @return the directive container represented in toConvert.
     *
     * @throws JPlateException if any problems arise during conversion.
     *
     */
    public DirectiveContainerIfc convertFromString ( String toConvert )
        throws JPlateException;
}
