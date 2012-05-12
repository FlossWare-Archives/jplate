package org.jplate.util.xml.document;

import java.io.InputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.jplate.util.resourcemgr.ResourceMgrIfc;
import org.jplate.util.resourcemgr.ResourceMgr;

/**
 *
 * This class will resolve system entities.  To resolve system entities, this
 * class relies on the <code>org.jplate.util.resourcemgr</code> family of
 * classes.
 *
 * @see org.jplate.util.resourcemgr
 *
 */
final class DTDEntityResolver implements EntityResolver
{
    /**
     *
     * This is used as part of the URI - like file:// http://
     *
     */
    public static final String URI_DELIMETER = "://";

    /**
     *
     * This is the length of the URI delimiter.
     *
     */
    public static final int URL_DELIMETER_LENGTH = URI_DELIMETER.length ();

    /**
     *
     * This ckass manages our singleton.
     *
     */
    private static final class DTDEntityResolverSingleton
    {
        /**
         *
         * This is the singleton.
         *
         */
        static final DTDEntityResolver _singleton = new DTDEntityResolver ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DTDEntityResolver ()
    {
    }

    /**
     *
     * This method will return the singleton.
     *
     * @return the singleton.
     *
     */
    static EntityResolver getSingleton ()
    {
        return DTDEntityResolverSingleton._singleton;
    }

    /**
     *
     * This method will return the input source for systemId or null if the
     * default resolver should be used.
     *
     * @param publicId represents the public identifier of the external entity
     *        being referenced or null if non supplied.
     *
     * @param systemId represents the system identifier of the external entity
     *        being references.
     *
     */
    public InputSource resolveEntity
        ( final String publicId, final String systemId )
    {
        final int pos = systemId.indexOf ( URI_DELIMETER );

        final String realSystemId =
        (
            pos != -1 ?
                systemId.substring ( pos + URL_DELIMETER_LENGTH ) : systemId
        );

        final InputStream inputStream =
            ResourceMgr.getSingleton ().getResource ( realSystemId );

        return ( inputStream != null ? new InputSource ( inputStream ) : null );
    }
}
