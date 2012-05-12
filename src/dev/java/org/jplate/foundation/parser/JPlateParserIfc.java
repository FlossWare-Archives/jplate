package org.jplate.foundation.parser;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;


/**
 
    Defines a parser who can parse from streams, readers, files and strings.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/parser/JPlateParserIfc.java $
    </pre>

    @param <B> A builder who can build things on behalf of self.

*/
public interface JPlateParserIfc <B extends JPlateBuilderIfc <?>>
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
     * This method is called to parse data from <code>inputStream</code>.
     *
     * @param inputStream A stream containing data to be parsed.
     *
     * @param builder A builder who can construct things on behalf of self.
     *
     * @throws JPlateParsingException If any problems arise parsing from
     *         <code>inputStream</code>.
     *
     */
    public void parse ( InputStream inputStream, B builder )
        throws JPlateParsingException;


    /**
     *
     * This method is called to parse data from <code>reader</code>.
     *
     * @param reader Contains data to be parsed.
     *
     * @param builder A builder who can construct things on behalf of self.
     *
     * @throws JPlateParsingException If any problems arise parsing from
     *         <code>reader</code>.
     *
     */
    public void parse ( Reader reader, B builder ) throws JPlateParsingException;


    /**
     *
     * This method is called to parse data from <code>string</code>.
     *
     * @param string A string containing data to be parsed.
     *
     * @param builder A builder who can construct things on behalf of self.
     *
     * @throws JPlateParsingException if any problems arise parsing from
     *         <code>string</code>.
     *
     */
    public void parse ( String string, B builder ) throws JPlateParsingException;


    /**
     *
     * This method is called to parse data from <code>file</code>.
     *
     * @param file is the file containing data to be parsed.
     *
     * @param builder is the builder who can construct things on behalf of self.
     *
     * @throws JPlateParsingException if any problems arise parsing from
     *         <code>file</code>.
     *
     */
    public void parse ( File file, B builder ) throws JPlateParsingException;
}
