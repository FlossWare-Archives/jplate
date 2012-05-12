package org.jplate.util.version;

/**
 *
 * This interface defines the API to create implementations of VersionIfc.
 *
 */
public interface VersionFactoryIfc
{
    /**
     *
     * This method will create a version object whose contents will be stored
     * in file name.
     *
     * @param fileName represents the name of the file to store the date of the
     *        version as well as version number.
     *
     * @param versionNumber represents the version number.
     *
     * @return a version object whose date and number are contained in fileName.
     *
     * @throws VersionException if any problems arise create the version object.
     *
     */
    public VersionIfc createVersion ( String fileName, String version )
        throws VersionException;

    /**
     *
     * This method will create a version object whose contents are stored in
     * resourceName.
     *
     * @param resourceName represents the name of the resource who contains the
     *        contents of the version object to be returned.
     *
     * @return a version object whose contents are contained in resourceName.
     *
     * @throws VersionException if any problems arise create the version object.
     *
     */
    public VersionIfc createVersion ( String resourceName )
        throws VersionException;
}
