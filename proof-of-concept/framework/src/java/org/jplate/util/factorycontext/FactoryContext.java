package org.jplate.util.factorycontext;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jplate.JPlateException;

import org.jplate.factory.FactoryIfc;
import org.jplate.factory.FactoryMgrIfc;

import org.jplate.util.xml.hierarchy.AttributeIfc;
import org.jplate.util.xml.hierarchy.HierarchyIfc;

import org.jplate.util.xml.facade.HierarchyFacadeIfc;
import org.jplate.util.xml.facade.HierarchyFacade;

/**
 *
 * This class satisfies the FactoryContextIfc interface and adheres to the
 * Singleton pattern.
 *
 */
public final class FactoryContext implements FactoryContextIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class FactoryContextSingleton
    {
        /**
         *
         * This is the real singleton.
         *
         */
        static final FactoryContextIfc _singleton = new FactoryContext ();
    }

    /**
     *
     * Denotes the factory manager is null...
     *
     */
    private static final String FACTORY_MGR_IS_NULL_MSG = "factoryMgr == null";

    /**
     *
     * This is the name of the xml file containing all our factories...
     *
     */
    private static final String XML_FILE =
        FactoryContext.class.getName () + ".xml";

    /**
     *
     * This defines the key that is used to signify the default factory.
     *
     */
    private static final Object DEFAULT_FACTORY_KEY = new byte [ 0 ];

    /**
     *
     * Our cache of factory managers.
     *
     */
    private final Map _cache;

    /**
     *
     * Default constructor not allowed.
     *
     */
    private FactoryContext ()
    {
        final Class  factoryMgrClass = FactoryMgrIfc.class;
        final Object defaultKey      = DEFAULT_FACTORY_KEY;

        final Map cache = new HashMap ();

        try
        {
            final HierarchyFacadeIfc hierarchyFacade =
                HierarchyFacade.getSingleton ();

            final HierarchyIfc hierarchy =
                hierarchyFacade.createValidatingHierarchy ( XML_FILE );

            //
            // The hierarchy is null if the resource cannot be found...
            //
            if ( hierarchy != null )
            {
                //
                // There should only be 1 root element - namely factory-context.
                //
                final HierarchyIfc root = hierarchy.getChildren () [ 0 ];

                //
                // We will be looping through all factory contexts...
                //
                final HierarchyIfc factoryContexts[] = root.getChildren ();
                final int fcSize = factoryContexts.length;

                for ( int fcLoop = 0; fcLoop < fcSize; fcLoop++ )
                {
                    //
                    // We need to operate upon the factory manager element...
                    //
                    final HierarchyIfc factoryMgr = factoryContexts [ fcLoop ];

                    //
                    // We need the class name.  There should only be 1 attribute
                    // attribute - namely class...
                    //
                    final String className =
                        factoryMgr.getAttributes ()[ 0 ].getValue ();

                    try
                    {
                        final Class klass = Class.forName ( className );

                        Map klassMap = ( Map ) cache.get ( klass );

                        if ( klassMap == null )
                        {
                            klassMap = new HashMap ();
                            cache.put ( klass, klassMap );
                        }

                        //
                        // Now loop through the actual context elements...
                        //
                        final HierarchyIfc contexts[] =
                            factoryMgr.getChildren ();

                        final int cSize = contexts.length;

                        for ( int cLoop = 0; cLoop < cSize; cLoop++ )
                        {
                            HierarchyIfc context = contexts [ cLoop ];

                            //
                            // If the number of attributes is less than 1, this
                            // is the default leaf...
                            //
                            final AttributeIfc attrs[] =
                                context.getAttributes ();

                            final String cValue = context.getValue ();

                            //
                            // This looks odd...  However, there should be 1
                            // attribute for the property - namely name.  Name's
                            // value is the name of the property and the value
                            // of the property element is the actual value of
                            // the property.
                            //
                            final Object cKey =
                            (
                                attrs.length > 0 ?
                                    Class.forName ( attrs [ 0 ].getValue () ) :
                                    defaultKey
                             );

                            klassMap.put ( cKey, cValue );
                        }
                    }

                    catch ( final ClassNotFoundException cnfe )
                    {
                        cnfe.printStackTrace ();
                    }
                }
            }
        }

        catch ( final JPlateException jplateException )
        {
            jplateException.printStackTrace ();
        }

        _cache = cache;
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singleton.
     *
     */
    public static FactoryContextIfc getSingleton ()
    {
        return FactoryContextSingleton._singleton;
    }

    /**
     *
     * This method will return a FactoryIfc based upon context.  If no
     * context has been defined, the default factory will be returned if it has
     * been defined.
     *
     * @param factoryMgr represents the factory manager for whom a factory is
     *        desired based upon context.
     *
     *
     * @param classContext represents the class context for which a FactoryIfc
     *        is desired.  This allows one to return arbitrary implementations
     *        of a factory based upon a class.
     *
     * @return an implementation of FactoryIfc for context, or the default
     *         factory if it has been defined.  If no default factory is defined
     *         null will be returned.
     *
     * @throws NullPointerException if factoryMgr is null.
     *
     */
    public FactoryIfc getFactoryForContext
        ( final FactoryMgrIfc factoryMgr, final Class classContext )
    {
        if ( factoryMgr == null )
        {
            throw new NullPointerException ( FACTORY_MGR_IS_NULL_MSG );
        }

        final Map cache = _cache;

        FactoryIfc retVal = null;

        if ( classContext != null )
        {
            final Map klassMap = ( Map ) cache.get ( factoryMgr.getClass () );

            if ( klassMap != null )
            {
                retVal = ( FactoryIfc ) klassMap.get ( classContext );

                if ( retVal == null )
                {
                    retVal =
                        ( FactoryIfc ) klassMap.get ( DEFAULT_FACTORY_KEY );
                }
            }
        }

        return retVal;
    }

    /**
     *
     * This method will return the default FactoryIfc for factoryMgr or null
     * if one does not exist.
     *
     * @param factoryMgr represents the factory manager for whom a factory is
     *        desired based upon context.
     *
     * @return an implementation of FactoryIfc for that is the default factory
     *         for factoryMgr.
     *
     */
    public FactoryIfc getDefaultFactory ( final FactoryMgrIfc factoryMgr )
    {
        if ( factoryMgr == null )
        {
            throw new NullPointerException ( FACTORY_MGR_IS_NULL_MSG );
        }

        final Map klassMap = ( Map ) _cache.get ( factoryMgr );

        return
            klassMap != null ? ( FactoryIfc ) klassMap.get
                ( DEFAULT_FACTORY_KEY ) : null;
    }
}
