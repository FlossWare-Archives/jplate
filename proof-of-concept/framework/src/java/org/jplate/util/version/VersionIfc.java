package org.jplate.util.version;

import java.util.Date;

/**
 *
 * This interface defines the API to retrieve the latest version information -
 * specifically the date and number.
 *
 */
public interface VersionIfc
{
    /**
     *
     * This method will return the version date.
     *
     * @return the version date.
     *
     */
    public Date getVersionDate ();

    /**
     *
     * This method will return the version number.
     *
     * @return the version number.
     *
     */
    public String getVersionNumber ();
}
