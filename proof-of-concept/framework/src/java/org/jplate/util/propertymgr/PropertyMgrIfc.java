package org.jplate.util.propertymgr;

import java.util.Map;

/**
 *
 * This interface defines the API for properties - either System or class based.
 *
 */
public interface PropertyMgrIfc
{
    /**
     *
     * This method will return a property for name.
     *
     * @param name represents the name of the property desired.
     *
     * @return the value for property or null if no property exists.
     *
     */
    public String getProperty ( String property );

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
     */
    public String getProperty ( Class klass, String propertyName );

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
    public Object getDefaultKey ();

    /**
     *
     * This method will return the default property for klass.  If no default
     * was defined, null will be returned.
     *
     * @return the default property for klass or null if no default was
     *         defined.
     *
     */
    public String getDefaultProperty ( Class klass );

    /**
     *
     * This method will return a map of all properties for klass.  The returned
     * value will be a non-thread safe map and will be a copy of the map
     * contained within the implementation of this interface.
     *
     * @param klass represents the class whose properties are desired.
     *
     * @return a map of all properties for klass.
     *
     */
    public Map getProperties ( Class klass );

    /**
     *
     * This method will return an array of classes for which properties have
     * been assigned.  The array returned will be a copy of the array contained
     * within the implementation of this interface.
     *
     * @return an array of classes for which properties have been assigned.
     *
     */
    public Class[] getClassesAssignedProperties ();
}
