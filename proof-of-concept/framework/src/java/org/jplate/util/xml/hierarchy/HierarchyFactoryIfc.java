package org.jplate.util.xml.hierarchy;

import org.w3c.dom.Document;

/**
 *
 * This interface defines the API to create a hierarchy from XML.  This is API
 * is simplifies the DOM API.  For instance, a hierarchy is nothing more than
 * a name with an optional value, optional attributes and optional children.
 *
 */
public interface HierarchyFactoryIfc
{
    /**
     *
     * This method will create a hierarchy from a document.
     *
     * @param document represents the document from which to construct a
     *        hierarchy.
     *
     * @return a hierarchy who is populated from document.
     *
     */
    public HierarchyIfc createHierarchyFromDocument ( Document document );
}
