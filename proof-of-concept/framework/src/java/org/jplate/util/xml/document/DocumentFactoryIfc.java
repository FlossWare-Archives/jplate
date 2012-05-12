package org.jplate.util.xml.document;

import org.w3c.dom.Document;

/**
 *
 * This interface defines the API to create a document from resource names.
 *
 */
public interface DocumentFactoryIfc
{
    /**
     *
     * This method will create a validating document whose XML is contained
     * in the system resource xmlResourceName and also contained in the XML is
     * the DTD.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @return a document whose XML is contained at xmlResourceName or null
     *         if no system resource exists with the name xmlResourceName.
     *
     * @throws DocumentException if any problems arise creating the document.
     *
     */
    public Document createValidatingDocument ( String xmlResourceName )
        throws DocumentException;

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
    public Document createDocument ( String xmlResourceName )
        throws DocumentException;
}
