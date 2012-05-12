package org.jplate.util.resourcemgr;

import java.io.InputStream;

/**
 *
 * This interface defines the API to load resources.
 *
 */
public interface ResourceMgrIfc
{
    /**
     *
     * The resource home location - meaning all resources are relative to this
     * location.
     *
     */
    public static final String RESOURCE_HOME = "/resources/";


    /**
     *
     * This method will return a stream for resourceName.
     *
     * @param resourceName is the name of the resource desired.
     *
     * @return the stream for resource or null if one is not found.
     *
     */
    public InputStream getResource ( String resourceName );
}
