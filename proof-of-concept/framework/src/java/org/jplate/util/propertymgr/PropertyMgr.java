package org.jplate.util.propertymgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jplate.JPlateException;

import org.jplate.util.xml.hierarchy.AttributeIfc;
import org.jplate.util.xml.hierarchy.HierarchyIfc;

import org.jplate.util.xml.facade.HierarchyFacadeIfc;
import org.jplate.util.xml.facade.HierarchyFacade;

/**
 *
 * This class satisfies the PropertyMgrIfc interface and adheres to the
 * Singleton pattern.
 *
 */
public final class PropertyMgr implements PropertyMgrIfc
{
    /**
     *
     * Denotes klass is null message.
     *
     */
    private static final String KLASS_IS_NULL_MSG = "klass == null";

    /**
     *
     * Denotes property name is null message.
     *
     */
    private static final String PROPERTY_NAME_IS_NULL_MSG =
        "propertyName == null";

    /**
     *
     * This is the name of the xml file containing all our properties...
     *
     */
    private static final String XML_FILE =
        PropertyMgr.class.getName () + ".xml";

    /**
     *
     * This is the default key.  For any given class, a default property
     * may be defined.  If so, its signified by this value.  A default property
     * is one in which, if a property has not been assigned, a default can be
     * defined and be the one returned.
     *
     */
    private static final Object DEFAULT_KEY = new byte [ 0 ];

    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class PropertyMgrSingleton
    {
        static final PropertyMgr _singleton = new PropertyMgr ();
    }

    /**
     *
     * This caches our class properties...
     *
     */
    private final Map _classCache;

    /**
     *
     * This caches our system properties...
     *
     */
    private final Map _systemCache;

    /**
     *
     * This array contains all classes who have properties assigned to them.
     *
     */
    private final Class _assignedProperties[];

    /**
     *
     * Default constructor not allowed.
     *
     */
    private PropertyMgr ()
    {
        //
        // Avoiding getop operation...
        //
        final Map  systemCache  = new HashMap   ();
        final Map  classCache   = new HashMap   ();
        final List assignedList = new ArrayList ( 100 );

        //
        // Avoid getopt byte code call...
        //
        final Object defaultKey = DEFAULT_KEY;

        systemCache.putAll ( System.getProperties () );

        try
        {
            final HierarchyFacadeIfc hierarchyFacade =
                HierarchyFacade.getSingleton ();

            final HierarchyIfc hierarchy =
                hierarchyFacade.createValidatingHierarchy ( XML_FILE );

            //
            // hierarchy will be null if the resource cannot be found...
            //
            if ( hierarchy != null )
            {
                //
                // There should only be 1 root element - namely proprty-mgr.
                //
                final HierarchyIfc root = hierarchy.getChildren () [ 0 ];

                //
                // We will be looping through all properties...
                //
                final HierarchyIfc props[] = root.getChildren ();
                final int propsSize = props.length;

                for ( int propsLoop = 0; propsLoop < propsSize; propsLoop++ )
                {
                    //
                    // We need to operate upon the properties element...
                    //
                    final HierarchyIfc properties = props [ propsLoop ];

                    //
                    // We need the class name.  There should only be 1 attribute
                    // attribute - namely class...
                    //
                    final String className =
                        properties.getAttributes ()[ 0 ].getValue ();

                    try
                    {
                        final Class klass = Class.forName ( className );

                        Map klassMap = ( Map ) classCache.get ( klass );

                        if ( klassMap == null )
                        {
                            klassMap = new HashMap ();
                            classCache.put ( klass, klassMap );
                            assignedList.add ( klass );
                        }

                        //
                        // Now loop through the actual property elements...
                        //
                        final HierarchyIfc property[] =
                            properties.getChildren ();
                        final int propertySize = property.length;

                        for ( int loop=0; loop<propertySize; loop++ )
                        {
                            HierarchyIfc aProperty = property [ loop ];

                            //
                            // If the number of attributes is less than 1, this
                            // is the default leaf...
                            //
                            final AttributeIfc attrs[] =
                                aProperty.getAttributes ();

                            final String propValue = aProperty.getValue ();

                            //
                            // This looks odd...  However, there should be 1
                            // attribute for the property - namely name.  Name's
                            // value is the name of the property and the value
                            // of the property element is the actual value of
                            // the property.
                            //
                            final Object propKey =
                                (
                                    attrs.length > 0 ? attrs [ 0 ].getValue () :
                                    defaultKey
                                );
                            klassMap.put ( propKey, propValue );
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

        final int   assignedSize         = assignedList.size ();
        final Class assignedProperties[] = new Class [ assignedSize ];

        assignedList.toArray ( assignedProperties );

        _systemCache        = systemCache;
        _classCache         = classCache;
        _assignedProperties = assignedProperties;
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singleton.
     *
     */
    public static PropertyMgrIfc getSingleton ()
    {
        return PropertyMgrSingleton._singleton;
    }

    /**
     *
     * This method will return a property for name.
     *
     * @param name represents the name of the property desired.
     *
     * @return the value for property or null if no property exists.
     *
     */
    public String getProperty ( String property )
    {
        return ( String ) _systemCache.get ( property );
    }

    /**
     *
     * This method will return a property for klass.
     *
     * @param klass represents the klass for which a property is desired.
     *
     * @param propertyName represents the name of the property for which a
     *        value is desired.
     *
     * @return the property for klass.  If the property does not exist, the
     *         default value will be returned.  If no default value is defined
     *         and the property does not exist, null will be returned.
     *
     * @throws NullPointerException if klass or propertyName are null.
     *
     */
    public String getProperty ( final Class klass, final String propertyName )
    {
        if ( klass == null )
        {
            throw new NullPointerException ( KLASS_IS_NULL_MSG );
        }
        else if ( propertyName == null )
        {
            throw new NullPointerException ( PROPERTY_NAME_IS_NULL_MSG );
        }

        final Map klassMap = ( Map ) _classCache.get ( klass );

        String retVal;

        if ( klassMap != null )
        {
            retVal = ( String ) klassMap.get ( propertyName );
            if ( retVal == null )
            {
                retVal = ( String ) klassMap.get ( DEFAULT_KEY );
            }
        }
        else
        {
            retVal = null;
        }

        return retVal;
    }

    /**
     *
     * This method returns the key used when setting the default property value
     * for a class.  Please note that this key is guarenteed to be unique and
     * therefore can compare using == versus .equals() when determining if
     * examing the default value (as a key).
     *
     * @return the key used when setting the default property value for a class.
     *
     */
    public Object getDefaultKey ()
    {
        return DEFAULT_KEY;
    }

    /**
     *
     * This method will return the default property for klass.  If no default
     * was defined, null will be returned.
     *
     * @return the default property for klass or null if no default was
     *         defined.
     *
     * @throws NullPointerException if klass is null.
     *
     */
    public String getDefaultProperty ( Class klass )
    {
        if ( klass == null )
        {
            throw new NullPointerException ( KLASS_IS_NULL_MSG );
        }

        final Map klassMap = ( Map ) _classCache.get ( klass );

        return 
            klassMap != null ? ( String ) klassMap.get ( DEFAULT_KEY ) : null;
    }

    /**
     *
     * This method will return a map of all properties for klass.  The returned
     * value will be a non-thread safe map and will be a copy of the map
     * contained within self.
     *
     * @param klass represents the class whose properties are desired.
     *
     * @return a map of all properties for klass.
     *
     * @throws NullPointerException if klass is null.
     *
     */
    public Map getProperties ( Class klass )
    {
        if ( klass == null )
        {
            throw new NullPointerException ( KLASS_IS_NULL_MSG );
        }

        final Map retVal   = new HashMap ();
        final Map klassMap = ( Map ) _classCache.get ( klass );

        if ( klassMap != null )
        {
            retVal.putAll ( klassMap );
        }

        return retVal;
    }

    /**
     *
     * This method will return an array of classes for which properties have
     * been assigned.  The array returned will be a copy of the array contained
     * within self.
     *
     * @return an array of classes for which properties have been assigned.
     *
     */
    public Class[] getClassesAssignedProperties ()
    {
        final Class assignedProperties[] = _assignedProperties;
        final int   size                 = assignedProperties.length;
        final Class retVal[]             = new Class [ size ];

        System.arraycopy ( assignedProperties, 0, retVal, 0, size );

        return retVal;
    }
}
