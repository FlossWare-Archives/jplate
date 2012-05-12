package org.jplate.util.xml.hierarchy;

import org.w3c.dom.Document;

/**
 *
 * This class satisfies the HierarchyFactoryIfc interface and adheres to the
 * singleton pattern.
 *
 */
public final class HierarchyFactory implements HierarchyFactoryIfc
{
    /**
     *
     * This class manages the singleton.
     *
     */
    private static final class HierarchyFactorySingleton
    {
        /**
         *
         * This is the actual singleton.
         *
         */
        private static final HierarchyFactory _singleton =
            new HierarchyFactory ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private HierarchyFactory ()
    {
    }

    /**
     *
     * This method will return the singleton.
     *
     * @return the singleton.
     *
     */
    public static HierarchyFactory getSingleton ()
    {
        return HierarchyFactorySingleton._singleton;
    }

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
    public HierarchyIfc createHierarchyFromDocument ( final Document document )
    {
        return new Hierarchy ( document );
    }
}
