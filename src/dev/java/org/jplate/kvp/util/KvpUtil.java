package org.jplate.kvp.util;


import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jplate.kvp.KvpIfc;
import org.jplate.kvp.KvpException;

import org.jplate.kvp.impl.defaults.DefaultKvp;
import org.jplate.kvp.impl.defaults.DefaultKvpFactory;

import org.jplate.kvp.parser.impl.defaults.DefaultKvpListBuilder;
import org.jplate.kvp.parser.impl.defaults.DefaultKvpMapBuilder;
import org.jplate.kvp.parser.impl.defaults.DefaultKvpParser;



/**
 
    KVP related utilities.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/kvp/util/KvpUtil.java $
    </pre>

*/
public class KvpUtil
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


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException If this constructor is called.
     *
     */
    private KvpUtil ()
    {
        throw new UnsupportedOperationException ();
    }



    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Create a {@link List} of KVP parsed data contained in
     * <code>inputStream</code>.
     *
     * @param inputStream A stream KVP data.
     *
     * @return A list of KVP records and fields.
     *
     * @throws KvpException If any problems arise getting KVP releated
     *         data from <code>inputStream</code>.
     *
     */
    public static List <KvpIfc> getAsList ( final InputStream inputStream )
            throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> kvpParser  =
                new DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> ();

            final DefaultKvpListBuilder <KvpIfc> listBuilder =
                new DefaultKvpListBuilder <KvpIfc>
                (
                    new DefaultKvpFactory ()
                );

            kvpParser.parse ( inputStream, listBuilder );

            return listBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link List} of KVP parsed data contained in
     * <code>reader</code>.
     *
     * @param reader Contains data to be parsed.
     *
     * @return A list of KVP records and fields.
     *
     * @throws KvpException If any problems arise parsing from
     *         <code>reader</code>.
     *
     */
    public static List <KvpIfc> getAsList ( final Reader reader )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> kvpParser  =
                new DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> ();

            final DefaultKvpListBuilder <KvpIfc> listBuilder =
                new DefaultKvpListBuilder <KvpIfc>
                (
                    new DefaultKvpFactory ()
                );

            kvpParser.parse ( reader, listBuilder );

            return listBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link List} of KVP parsed data contained in
     * <code>string</code>.
     *
     * @param string A string containing data to be parsed.
     *
     * @return A list of KVP records and fields.
     *
     * @throws KvpException if any problems arise parsing from
     *         <code>string</code>.
     *
     */
    public static List <KvpIfc> getAsList ( final String string )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> kvpParser  =
                new DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> ();

            final DefaultKvpListBuilder <KvpIfc> listBuilder =
                new DefaultKvpListBuilder <KvpIfc>
                (
                    new DefaultKvpFactory ()
                );

            kvpParser.parse ( string, listBuilder );

            return listBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link List} of KVP parsed data contained in
     * <code>file</code>.
     *
     * @param file is the file containing data to be parsed.
     *
     * @return A list of KVP records and fields.
     *
     * @throws KvpException if any problems arise parsing from
     *         <code>file</code>.
     *
     */
    public static List <KvpIfc> getAsList ( final File file )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> kvpParser  =
                new DefaultKvpParser <DefaultKvpListBuilder <KvpIfc>> ();

            final DefaultKvpListBuilder <KvpIfc> listBuilder =
                new DefaultKvpListBuilder <KvpIfc>
                (
                    new DefaultKvpFactory ()
                );

            kvpParser.parse ( file, listBuilder );

            return listBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a Map of KVP parsed data contained in <code>inputStream</code>.
     *
     * @param inputStream A stream KVP data.
     *
     * @return A Map of KVP records and fields.
     *
     * @throws KvpException If any problems arise getting KVP releated
     *         data from <code>inputStream</code>.
     *
     */
    public static Map <String, String> getAsMap ( final InputStream inputStream )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpMapBuilder> kvpParser  =
                new DefaultKvpParser <DefaultKvpMapBuilder> ();

            final DefaultKvpMapBuilder kvpBuilder = new DefaultKvpMapBuilder ();

            kvpParser.parse ( inputStream, kvpBuilder );

            return kvpBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link Map} of KVP parsed data contained in
     * <code>reader</code>.
     *
     * @param reader Contains data to be parsed.
     *
     * @return A kvp of KVP records and fields.
     *
     * @throws KvpException If any problems arise parsing from
     *         <code>reader</code>.
     *
     */
    public static Map <String, String> getAsMap ( final Reader reader )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpMapBuilder> kvpParser  =
                new DefaultKvpParser <DefaultKvpMapBuilder> ();

            final DefaultKvpMapBuilder kvpBuilder = new DefaultKvpMapBuilder ();

            kvpParser.parse ( reader, kvpBuilder );

            return kvpBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link Map} of KVP parsed data contained in
     * <code>string</code>.
     *
     * @param string A string containing data to be parsed.
     *
     * @return A kvp of KVP records and fields.
     *
     * @throws KvpException if any problems arise parsing from
     *         <code>string</code>.
     *
     */
    public static Map <String, String> getAsMap ( final String string )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpMapBuilder> kvpParser  =
                new DefaultKvpParser <DefaultKvpMapBuilder> ();

            final DefaultKvpMapBuilder kvpBuilder = new DefaultKvpMapBuilder ();

            kvpParser.parse ( string, kvpBuilder );

            return kvpBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }


    /**
     *
     * Create a {@link Map} of KVP parsed data contained in
     * <code>file</code>.
     *
     * @param file is the file containing data to be parsed.
     *
     * @return A kvp of KVP records and fields.
     *
     * @throws KvpException if any problems arise parsing from
     *         <code>file</code>.
     *
     */
    public static Map <String, String> getAsMap ( final File file )
        throws KvpException
    {
        try
        {
            final DefaultKvpParser <DefaultKvpMapBuilder> kvpParser  =
                new DefaultKvpParser <DefaultKvpMapBuilder> ();

            final DefaultKvpMapBuilder kvpBuilder = new DefaultKvpMapBuilder ();

            kvpParser.parse ( file, kvpBuilder );

            return kvpBuilder.getResult ();
        }

        catch ( final Exception exception )
        {
            throw new KvpException ( exception );
        }
    }
}
