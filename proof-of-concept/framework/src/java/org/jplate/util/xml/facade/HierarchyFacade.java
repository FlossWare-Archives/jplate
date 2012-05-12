package org.jplate.util.xml.facade;

import org.w3c.dom.Document;

import org.jplate.JPlateException;

import org.jplate.util.xml.hierarchy.HierarchyIfc;
import org.jplate.util.xml.hierarchy.HierarchyIfc;
import org.jplate.util.xml.hierarchy.HierarchyFactoryIfc;
import org.jplate.util.xml.hierarchy.HierarchyFactory;

import org.jplate.util.xml.document.DocumentFactoryIfc;
import org.jplate.util.xml.document.DocumentFactory;

/**
 *
 * This class satisfies the HierarchyFacadeIfc interface and adheres to the
 * Singleton pattern.
 *
 */
public final class HierarchyFacade implements HierarchyFacadeIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class HierarchyFacadeSingleton
    {
        /**
         *
         * This is the singleton.
         *
         */
        static final HierarchyFacadeIfc _singleton = new HierarchyFacade ();
    }

    /**
     *
     * Default constructor not allowed.
     *
     */
    private HierarchyFacade ()
    {
    }

    /**
     *
     * This method will return the singleton.
     *
     * @return the singleton.
     *
     */
    public static HierarchyFacadeIfc getSingleton ()
    {
        return HierarchyFacadeSingleton._singleton;
    }

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
        throws HierarchyFacadeException
    {
        try
        {
            final DocumentFactoryIfc documentFactory =
                DocumentFactory.getSingleton ();

            final Document document =
                documentFactory.createValidatingDocument ( xmlResourceName );

            HierarchyIfc retVal;

            if ( document != null )
            {
                final HierarchyFactoryIfc hierarchyFactory =
                    HierarchyFactory.getSingleton ();
                    
                retVal =
                    hierarchyFactory.createHierarchyFromDocument ( document );
            }
            else
            {
                retVal = null;
            }

            return retVal;
        }

        catch ( final JPlateException jplateException )
        {
            throw new HierarchyFacadeException ( jplateException );
        }
    }

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
        throws HierarchyFacadeException
    {
        try
        {
            final DocumentFactoryIfc documentFactory =
                DocumentFactory.getSingleton ();

            final Document document =
                documentFactory.createDocument ( xmlResourceName );

            HierarchyIfc retVal;

            if ( document != null )
            {
                final HierarchyFactoryIfc hierarchyFactory =
                    HierarchyFactory.getSingleton ();
                    
                retVal =
                    hierarchyFactory.createHierarchyFromDocument ( document );
            }
            else
            {
                retVal = null;
            }

            return retVal;
        }

        catch ( final JPlateException jplateException )
        {
            throw new HierarchyFacadeException ( jplateException );
        }
    }
}
