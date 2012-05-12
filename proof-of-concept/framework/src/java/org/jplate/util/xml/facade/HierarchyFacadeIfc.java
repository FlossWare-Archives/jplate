package org.jplate.util.xml.facade;

import org.jplate.util.xml.hierarchy.HierarchyIfc;

/**
 *
 * This interface defines the API to create a document from various sources -
 * resources, input streams, etc.
 *
 */
public interface HierarchyFacadeIfc
{
    /**
     *
     * This method will create a hierarchy whose XML representation is a
     * validating XML document.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @return a hierarchy whose XML is contained at xmlResourceName or null
     *         if no resource can be found for xmlResourceName.
     *
     * @throws HierarchyFacadeException if any problems arise creating the
     *         hierarchy.
     *
     */
    public HierarchyIfc createValidatingHierarchy ( String xmlResourceName )
        throws HierarchyFacadeException;

    /**
     *
     * This method will create a hierarchy whose XML representation is contained
     * in xmlResourceName.
     *
     * @param xmlResourceName represents the system resource containing the XML.
     *
     * @return a hierarchy whose XML is contained at xmlResourceName or null
     *         if no resource can be found for xmlResourceName.
     *
     * @throws HierarchyFacadeException if any problems arise creating the
     *         hierarchy.
     *
     */
    public HierarchyIfc createHierarchy ( String xmlResourceName )
        throws HierarchyFacadeException;
}
