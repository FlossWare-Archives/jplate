package org.jplate.tmplate.directive.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.NamedDirectiveDefIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;

import org.jplate.tmplate.directive.cache.DirectiveCacheFactoryIfc;
import org.jplate.tmplate.directive.cache.DirectiveCacheFactoryMgr;

import org.jplate.tmplate.directive.parserstrategy.DirectiveParserStrategyIfc;
import org.jplate.tmplate.directive.parserstrategy.DirectiveParserStrategyFactoryIfc;
import org.jplate.tmplate.directive.parserstrategy.DirectiveParserStrategyFactoryMgr;

import org.jplate.tmplate.parser.JPlateParser;

import org.jplate.util.resourcemgr.ResourceMgr;

/**
 *
 * This class acts as a facade for creating directive containers.
 *
 */
public final class DirectiveContainerFacade implements DirectiveContainerFacadeIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DirectiveContainerFacadeSingleton
    {
        static final DirectiveContainerFacadeIfc _singleton =
            new DirectiveContainerFacade ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DirectiveContainerFacade ()
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singelton.
     *
     */
    public static DirectiveContainerFacadeIfc getSingleton ()
    {
        return DirectiveContainerFacadeSingleton._singleton;
    }

    /**
     *
     * This method will close an input stream.
     *
     * @param inputStream represents the input stream to close.
     *
     */
    private void closeInputStream ( final InputStream inputStream )
    {
        if ( inputStream != null )
        {
            try
            {
                inputStream.close ();
            }

            catch ( final IOException ioException )
            {
                ioException.printStackTrace ();
            }
        }
    }

    /**
     *
     * This method will close a reader.
     *
     * @param reader represents the reader to close.
     *
     */
    private void closeReader ( final Reader reader )
    {
        if ( reader != null )
        {
            try
            {
                reader.close ();
            }

            catch ( final IOException ioException )
            {
                ioException.printStackTrace ();
            }
        }
    }

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
        ( final Reader toConvert,
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        JPlateParser.parseJPlate ( toConvert, directiveParserStrategy );

        return directiveParserStrategy.getDirectiveContainer ();
    }

    /**
     *
     * This method will take toConvert and convert to a directive container by
     * constructing a directive parser strategy using directiveCache.
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
    public DirectiveContainerIfc convertFromReader
        ( final Reader toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromReader
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final Reader toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromReader
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
    public DirectiveContainerIfc convertFromReader ( final Reader toConvert )
        throws JPlateException
    {
        return
            convertFromReader
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }

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
        ( final InputStream toConvert, 
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        JPlateParser.parseJPlate ( toConvert, directiveParserStrategy );

        return directiveParserStrategy.getDirectiveContainer ();
    }

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
        ( final InputStream toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromInputStream
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final InputStream toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromInputStream
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
        ( final InputStream toConvert )
            throws JPlateException
    {
        return
            convertFromInputStream
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }

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
        ( final File toConvert,
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        FileReader     fileReader     = null;
        BufferedReader bufferedReader = null;

        try
        {
            fileReader     = new FileReader     ( toConvert  );
            bufferedReader = new BufferedReader ( fileReader );
        
            return
                convertFromReader ( bufferedReader, directiveParserStrategy );
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
            closeReader ( bufferedReader );
            closeReader ( fileReader     );
        }
    }

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
        ( final File toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromFile
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final File toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromFile
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
    public DirectiveContainerIfc convertFromFile ( final File toConvert )
        throws JPlateException
    {
        return
            convertFromFile
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }

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
        ( final String toConvert,
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        return
            convertFromFile ( new File ( toConvert ), directiveParserStrategy );
    }

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
        ( final String toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromFileName
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final String toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromFileName
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
    public DirectiveContainerIfc convertFromFileName ( final String toConvert )
        throws JPlateException
    {
        return
            convertFromFileName
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }

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
        ( final String toConvert,
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        final InputStream inputStream =
            ResourceMgr.getSingleton ().getResource ( toConvert );

        if ( inputStream == null )
        {
            throw new JPlateException ( new NullPointerException () );
        }

        InputStreamReader inputStreamReader = null;
        BufferedReader    bufferedReader    = null;

        try
        {
            inputStreamReader = new InputStreamReader ( inputStream       );
            bufferedReader    = new BufferedReader    ( inputStreamReader );

            return
                convertFromReader ( bufferedReader, directiveParserStrategy );
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
            closeReader      ( inputStreamReader );
            closeReader      ( bufferedReader    );
            closeInputStream ( inputStream       );
        }
    }

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
        ( final String toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromResource
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final String toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromResource
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
    public DirectiveContainerIfc convertFromResource ( final String toConvert )
            throws JPlateException
    {
        return
            convertFromResource
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }

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
        ( final String toConvert,
          final DirectiveParserStrategyIfc directiveParserStrategy )
            throws JPlateException
    {
        StringReader stringReader = null;

        try
        {
            stringReader = new StringReader ( toConvert );

            return
                convertFromReader ( stringReader, directiveParserStrategy );
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
            closeReader ( stringReader );
        }
    }

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
        ( final String toConvert, final DirectiveCacheIfc directiveCache )
            throws JPlateException
    {
        final DirectiveParserStrategyFactoryIfc parserStrategyFactory =
            DirectiveParserStrategyFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        return convertFromString
        (
            toConvert,
            parserStrategyFactory.createDirectiveParserStrategy
            (
                directiveCache
            )
        );
    }

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
        ( final String toConvert, final NamedDirectiveDefIfc directives[] )
            throws JPlateException
    {
        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory ( getClass () );

        return
            convertFromString
            (
                toConvert, cacheFactory.createDirectiveCache ( directives )
            );
    }

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
    public DirectiveContainerIfc convertFromString ( final String toConvert )
        throws JPlateException
    {
        return
            convertFromString
            (
                toConvert,
                NamedDirectiveDefFacade.getSingleton ().getNamedDirectives ()
            );
    }
}
