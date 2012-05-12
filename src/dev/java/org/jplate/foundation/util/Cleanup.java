package org.jplate.foundation.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**

    Provides common cleanup code for things like streams, database connections, etc.
    When cleaning up, exception are silently ignored.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/Cleanup.java $
    </pre>

 */
public final class Cleanup
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
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Close the connection, <code>connection</code> if it is not null.  It will
     * attempt to commit the connection first.  Any error is silently ignored.
     *
     * @param connection The connection to close.
     *
     */
    public static void closeCommit ( final Connection connection )
    {
        if ( connection != null )
        {
            try
            {
                connection.commit ();
            }

            catch ( final SQLException sqlException )
            {
            }

            close ( connection );
        }
    }


    /**
     *
     * Close the connection, <code>connection</code> if it is not null.  It will
     * attempt to rollback the connection first.  Any error is silently ignored.
     *
     * @param connection The connection to close.
     *
     */
    public static void closeRollback ( final Connection connection )
    {
        if ( connection != null )
        {
            try
            {
                connection.rollback ();
            }

            catch ( final SQLException sqlException )
            {
            }

            close ( connection );
        }
    }


    /**
     *
     * Close the connection, <code>connection</code> if it is not null.  Any error
     * is silently ignored.
     *
     * @param connection The connection to close.
     *
     */
    public static void close ( final Connection connection )
    {
        if ( connection != null )
        {
            try
            {
                connection.close ();
            }

            catch ( final SQLException sqlException )
            {
            }
        }
    }


    /**
     *
     * Close the statement, <code>statement</code> if it is not null.  Any error
     * is silently ignored.
     *
     * @param statement The statement to close.
     *
     */
    public static void close ( final Statement statement )
    {
        if ( statement != null )
        {
            try
            {
                statement.close ();
            }

            catch ( final SQLException sqlException )
            {
            }
        }
    }


    /**
     *
     * Close the result set, <code>resultSet</code> if it is not null.  Any error
     * is silently ignored.
     *
     * @param resultSet The result set to close.
     *
     */
    public static void close ( final ResultSet resultSet )
    {
        if ( resultSet != null )
        {
            try
            {
                resultSet.close ();
            }

            catch ( final SQLException sqlException )
            {
            }
        }
    }


    /**
     *
     * Close the connection, <code>connection</code>, and statement,
     * <code>statement<code>, if not null.  Any error is silently ignored.
     *
     * @param connection The connection to close.
     *
     * @param statement The statement to close.
     *
     */
    public static void close
        ( final Connection connection, final Statement statement )
    {
        close ( statement  );
        close ( connection );
    }


    /**
     *
     * Close the connection, <code>connection</code>, statement,
     * <code>statement<code>, and result set, <code>resultSet</code>, if not null.
     * Any error is silently ignored.
     *
     * @param connection The connection to close.
     *
     * @param statement The statement to close.
     *
     * @param resultSet The result set to close.
     *
     */
    public static void close
        ( final Connection connection, final Statement statement,
          final ResultSet resultSet )
    {
        close ( resultSet  );
        close ( statement  );
        close ( connection );
    }


    /**
     *
     * Close the reader, <code>reader</code> if not null.  Any error is silently
     * ignored.
     *
     * @param reader The reader set to close.
     *
     */
    public static void close ( final Reader reader )
    {
        if ( reader != null )
        {
            try
            {
                reader.close ();
            }

            catch ( final IOException ioException )
            {
            }
        }
    }


    /**
     *
     * Close the writer, <code>writer</code> if not null.  All data will be flushed
     * first.  Any error is silently ignored.
     *
     * @param writer The writer set to close.
     *
     */
    public static void closeFlushed ( final Writer writer )
    {
        if ( writer != null )
        {
            try
            {
                writer.flush ();
            }

            catch ( final IOException ioException )
            {
            }

            close ( writer );
        }
    }


    /**
     *
     * Close the writer, <code>writer</code> if not null.  Any error is silently
     * ignored.
     *
     * @param writer The writer set to close.
     *
     */
    public static void close ( final Writer writer )
    {
        if ( writer != null )
        {
            try
            {
                writer.close ();
            }

            catch ( final IOException ioException )
            {
            }
        }
    }


    /**
     *
     * Close the input stream, <code>inputStream</code> if not null.  Any error is
     * silently ignored.
     *
     * @param inputStream The input stream set to close.
     *
     */
    public static void close ( final InputStream inputStream )
    {
        if ( inputStream != null )
        {
            try
            {
                inputStream.close ();
            }

            catch ( final IOException ioException )
            {
            }
        }
    }


    /**
     *
     * Close the output stream, <code>outputStream</code> if not null.  The output
     * stream will be flushed first.  Any error is silently ignored.
     *
     * @param outputStream The output stream set to close.
     *
     */
    public static void closeFlushed ( final OutputStream outputStream )
    {
        if ( outputStream != null )
        {
            try
            {
                outputStream.flush ();
            }

            catch ( final IOException ioException )
            {
            }

            close ( outputStream );
        }
    }


    /**
     *
     * Close the output stream, <code>outputStream</code> if not null.  Any error is
     * silently ignored.
     *
     * @param outputStream The output stream set to close.
     *
     */
    public static void close ( final OutputStream outputStream )
    {
        if ( outputStream != null )
        {
            try
            {
                outputStream.close ();
            }

            catch ( final IOException ioException )
            {
            }
        }
    }
}
