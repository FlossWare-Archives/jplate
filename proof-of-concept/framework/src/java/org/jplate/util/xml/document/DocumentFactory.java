package org.jplate.util.xml.document;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.EntityResolver;

import org.w3c.dom.Document;

import org.jplate.util.resourcemgr.ResourceMgrIfc;
import org.jplate.util.resourcemgr.ResourceMgr;

/**
 *
 * This class satisfies the DocumentFactoryIfc interface and adheres to the
 * Singleton pattern.
 *
 */
public final class DocumentFactory implements DocumentFactoryIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class DocumentFactorySingleton
    {
        /**
         *
         * This is the actual singleton.
         *
         */
        static final DocumentFactory _singleton = new DocumentFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private DocumentFactory ()
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return the singleton.
     *
     */
    public static DocumentFactory getSingleton ()
    {
        return DocumentFactorySingleton._singleton;
    }

    /**
     *
     * This method will create a document.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @param isValidating represents a flag, if true the XML document will be
     *        validated, false it will not.
     *
     * @param entityResolver represents the object that will get system
     *        resources.
     *
     * @return a document whose XML is contained at xmlResourceName or null
     *         if no system resource exists with the name xmlResourceName.
     *
     * @throws DocumentException if any problems arise creating the document.
     *
     */
    private Document createDocument
        ( final String xmlResourceName, final boolean isValidating,
          final EntityResolver entityResolver )
            throws DocumentException
    {
        try
        {
            final DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance ();

            dbf.setValidating ( isValidating );

            final DocumentBuilder db = dbf.newDocumentBuilder ();

            final ResourceMgrIfc resourceMgr = ResourceMgr.getSingleton ();

            db.setEntityResolver ( entityResolver );

            final InputStream inputStream =
                resourceMgr.getResource ( xmlResourceName );

            return
                ( inputStream != null ? db.parse ( inputStream, "/" ) : null );
        }

        catch ( final Exception exception )
        {
            throw new DocumentException ( exception );
        }
    }

    /**
     *
     * This method will create a validating document whose XML is contained
     * in the system resource xmlResourceName and also contained in the XML is
     * the DTD.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @return a validating document whose XML is contained at xmlResourceName 
     *         or null if no system resource exists with the name
     *         xmlResourceName.
     *
     * @throws DocumentException if any problems arise creating the document.
     *
     */
    public Document createValidatingDocument ( final String xmlResourceName )
        throws DocumentException
    {
        return
            createDocument
            (
                xmlResourceName, true, DTDEntityResolver.getSingleton ()
            );
    }

    /**
     *
     * This method will create a non validating document whose XML is contained
     * in the system resource xmlResourceName.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @return a document whose XML is contained at xmlResourceName or null
     *         if no system resource exists with the name xmlResourceName.
     *
     * @throws DocumentException if any problems arise creating the document.
     *
     */
    public Document createDocument ( final String xmlResourceName )
        throws DocumentException
    {
        return createDocument ( xmlResourceName, false, null );
    }
}
