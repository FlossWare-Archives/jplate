package org.jplate.util.version;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Date;

import org.jplate.util.resourcemgr.ResourceMgr;
import org.jplate.util.resourcemgr.ResourceMgrIfc;

/**
 *
 * This class satisfies the VersionIfc interface.
 *
 */
final class Version implements VersionIfc
{
    /**
     *
     * This is the version date.
     *
     */
    private final Date _versionDate;

    /**
     *
     * This is the version number.
     *
     */
    private final String _versionNumber;

    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private Version ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor will create a file containing the version date (current
     * date )and version number.
     *
     * @param fileName represents the file name (including path) for the
     *        version date and version number.
     *
     * @param versionNumber represents the version number.
     *
     * @throws VersionException if any problems arise creating the version file.
     *
     */
    Version ( final String fileName, final String versionNumber )
        throws VersionException
    {
        final File versionFile = new File ( fileName );
        final File parentDir   = versionFile.getParentFile ();

        parentDir.mkdirs ();

        final Date versionDate = new Date ();

        FileOutputStream fos = null;

        try
        {
            fos = new FileOutputStream ( versionFile );

            final BufferedOutputStream bos = new BufferedOutputStream ( fos );
            final ObjectOutputStream   oos = new ObjectOutputStream   ( bos );

            oos.writeObject ( versionDate   );
            oos.writeObject ( versionNumber );

            oos.flush ();
            oos.close ();
        }

        catch ( final Exception exception )
        {
            throw new VersionException ( exception );
        }

        finally
        {
            if ( fos != null )
            {
                try
                {
                    fos.close ();
                }

                catch ( final IOException ioException )
                {
                    ioException.printStackTrace ();
                }
            }
        }

        _versionDate   = versionDate;
        _versionNumber = versionNumber;
    }

    /**
     *
     * This constructor will populate self with data contained from
     * resourceName.
     *
     * @param resourceName represents the name of a resource who contains the
     *        version data.
     *
     * @throws VersionException if any problems arise populating self from
     *         resourceName.
     *
     */
    Version ( final String resourceName ) throws VersionException
    {
        final ResourceMgrIfc resourceMgr = ResourceMgr.getSingleton ();

        final InputStream is = resourceMgr.getResource ( resourceName );

        if ( is == null )
        {
            throw new VersionException
            (
                new IllegalArgumentException ( resourceName )
            );
        }

        try
        {
            final BufferedInputStream bis = new BufferedInputStream ( is  );
            final ObjectInputStream   ois = new ObjectInputStream   ( bis );

            final Date   versionDate   = ( Date   ) ois.readObject ();
            final String versionNumber = ( String ) ois.readObject ();

            _versionDate   = versionDate;
            _versionNumber = versionNumber;
        }

        catch ( final Exception exception )
        {
            throw new VersionException ( exception );
        }

        finally
        {
            try
            {
                is.close ();
            }

            catch ( final IOException ioException )
            {
                ioException.printStackTrace ();
            }
        }
    }

    /**
     *
     * This method will return the version date.
     *
     * @return the version date.
     *
     */
    public Date getVersionDate ()
    {
        return _versionDate;
    }

    /**
     *
     * This method will return the version number.
     *
     * @return the version number.
     *
     */
    public String getVersionNumber ()
    {
        return _versionNumber;
    }
}
