package org.jplate.foundation.parser.javacc.impl;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.JPlateException;

import org.jplate.foundation.util.Assert;
import org.jplate.foundation.util.Cleanup;

import org.jplate.foundation.parser.JPlateBuilderIfc;
import org.jplate.foundation.parser.JPlateParserIfc;
import org.jplate.foundation.parser.JPlateParsingException;

import org.jplate.foundation.parser.javacc.JavaccParserIfc;


/**
 
    Abstract base class of JavaCC derived parsers.  Subclasses <b><i>should not
    be created using the JavaCC static flag.</i></b>  Essentially this base class
    provides all the necessary "plumbing" to parse input streams, readers, files
    and strings - thereby requiring subclasses to <i>only</i> implement the
    {@link #parse(JPlateBuilderIfc)} method.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/javacc/impl/AbstractJavaccParser.java $
    </pre>

    @param <B> A JPlate builder used to build things as tokens are parsed.

*/
public abstract class AbstractJavaccParser <B extends JPlateBuilderIfc <?>>
    implements JavaccParserIfc <B>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
    //
    // Static class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static member definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( AbstractJavaccParser.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * {@inheritDoc}
     *
     */
    public void parse ( final Reader reader, final B builder )
        throws JPlateParsingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Parsing using reader [" + reader + " builder [" + builder + "]"
            );
        }

        Assert.isReferenced ( READER_IS_NULL_MSG,  reader  );
        Assert.isReferenced ( BUILDER_IS_NULL_MSG, builder );

        try
        {
			ReInit ( reader  );
			parse  ( builder );
		}

        catch ( final JPlateParsingException parsingException )
        {
            _log.error ( "Problem parsing", parsingException );

            throw parsingException;
        }

        catch ( final Exception exception )
        {
            _log.error ( "Problem parsing", exception );

            throw new JPlateParsingException ( exception );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void parse ( final InputStream inputStream, final B builder )
        throws JPlateParsingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Parsing using inputStream [" + inputStream + " builder [" +
                builder + "]"
            );
        }

        Assert.isReferenced ( INPUT_STREAM_IS_NULL_MSG, inputStream );
        Assert.isReferenced ( BUILDER_IS_NULL_MSG,      builder     );

        try
        {
			ReInit ( inputStream );
            parse  ( builder     );
        }

        catch ( final JPlateParsingException parsingException )
        {
            _log.error ( "Problem parsing", parsingException );

            throw parsingException;
        }

        catch ( final Exception exception )
        {
            _log.error ( "Problem parsing", exception );

            throw new JPlateParsingException ( exception );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void parse ( final String string, final B builder )
        throws JPlateParsingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Parsing using string [" + string + " builder [" + builder + "]"
            );
        }

        Assert.notEmptyString ( STRING_IS_EMPTY_MSG, string );

        try
        {
            parse ( new StringReader ( string ), builder );
        }

        catch ( final JPlateParsingException parsingException )
        {
            _log.error ( "Problem parsing", parsingException );

            throw parsingException;
        }

        catch ( final Exception exception )
        {
            _log.error ( "Problem parsing", exception );

            throw new JPlateParsingException ( exception );
        }
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public void parse ( final File file, final B builder )
        throws JPlateParsingException
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Parsing using file [" + file + " builder [" + builder + "]"
            );
        }

        Assert.isReferenced ( FILE_IS_NULL_MSG, file );

        if ( ! file.exists () )
        {
            _log.error ( "File [" + file + "] does not exist" );

            throw
                new JPlateParsingException
                (
                    "\"" + file + "\"" + FILE_DOES_NOT_EXIST_MSG
                );
        }

        FileReader fileReader = null;

        try
        {
            fileReader = new FileReader ( file );

            parse ( fileReader, builder );
        }

        catch ( final JPlateParsingException parsingException )
        {
            _log.error ( "Problem parsing", parsingException );

            throw parsingException;
        }

        catch ( final Exception exception )
        {
            _log.error ( "Problem parsing", exception );

            throw new JPlateParsingException ( exception );
        }

        finally
        {
            Cleanup.close ( fileReader );
        }
    }


    /**
     *
     * Is called by self to start parsing.
     *
     * @param builder The object who can create objects from data contained in
     *        parser input stream/reader.
     *
     * @throws Exception If any issue arise during parsing.
     *
     */
    protected abstract void parse ( B builder ) throws Exception;
}


