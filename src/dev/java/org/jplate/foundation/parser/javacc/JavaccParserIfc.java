package org.jplate.foundation.parser.javacc;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.jplate.JPlateException;

import org.jplate.foundation.util.Assert;
import org.jplate.foundation.util.Cleanup;

import org.jplate.foundation.parser.JPlateBuilderIfc;
import org.jplate.foundation.parser.JPlateParserIfc;
import org.jplate.foundation.parser.JPlateParsingException;


/**
 
    Defines the interface for all JavaCC related parsers.  Additionally defines
    some constant messages that can be used for errors.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/javacc/JavaccParserIfc.java $
    </pre>

    @param <B> A JPlate builder used to build things as tokens are parsed.

*/
public interface JavaccParserIfc <B extends JPlateBuilderIfc <?>>
    extends JPlateParserIfc <B>
{
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


    /**
     *
     * Denotes a null reader.
     *
     */
    public static final String READER_IS_NULL_MSG = "reader == null";


    /**
     *
     * Denotes a null input stream.
     *
     */
    public static final String INPUT_STREAM_IS_NULL_MSG = "inputStream == null";


    /**
     *
     * Denotes a null/empty string.
     *
     */
    public static final String STRING_IS_EMPTY_MSG = "string == null || \"\"";


    /**
     *
     * Denotes a null file.
     *
     */
    public static final String FILE_IS_NULL_MSG = "file == null";


    /**
     *
     * Denotes a non existent file.
     *
     */
    public static final String FILE_DOES_NOT_EXIST_MSG = "does not exist";


    /**
     *
     * Denotes a null builder.
     *
     */
    public static final String BUILDER_IS_NULL_MSG = "builder == null";


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * JavaCC will generate this method so it is not needed to be implemented.
     *
     * @param inputStream The stream from which parsing will commence.
     *
     */
    public void ReInit ( InputStream inputStream );


    /**
     *
     * JavaCC will generate this method so it is not needed to be implemented.
     *
     * @param inputStream The stream from which parsing will commence.
     *
     * @param encoding The character encoding to use when parsing.
     *
     */
    public void ReInit ( InputStream inputStream, String encoding );


    /**
     *
     * JavaCC will generate this method so it is not needed to be implemented.
     *
     * @param reader The reader from which parsing will commence.
     *
     */
    public void ReInit ( Reader reader );
}


