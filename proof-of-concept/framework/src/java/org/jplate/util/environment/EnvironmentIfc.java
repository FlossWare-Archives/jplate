package org.jplate.util.environment;

/**
 *
 * This interface defines the API for an environment.  An environment contains
 * name/value pairs as well as aribitrary orbitrary data/value objects.
 *
 */
public interface EnvironmentIfc
{
    /**
     *
     * This method will set a value for name.
     *
     * @param name represents the name for which value is a value.
     *
     * @param value represents a value for name.
     *
     */
    public void setValue ( String name, String value );

    /**
     *
     * This method will return a value for name, or null if no value exists.
     *
     * @param name represents the name for which a value is desired.
     *
     * @return the value for name or null if no value exists for name.
     *
     */
    public String getValue ( String name );

    /**
     *
     * This method will return a value for name, or defaultValue if name
     * is not found.
     *
     * @param name represents the name for which a value is desired.
     *
     * @param defaultValue represents the default value to return if name is not
     *        found.
     *
     * @return the value for name or defaultValue if name is not found.
     *
     */
    public String getValue ( String name, String defaultValue );

    /**
     *
     * This method will return a required value for name.
     *
     * @param name represents the name for which a value is desired.
     *
     * @return the value for name.
     *
     * @throws ValueNotFoundException if no value could be found for name.
     *
     */
    public String getRequiredValue ( String name )
        throws ValueNotFoundException;

    /**
     *
     * This method will remove a value for name.  If name is not defined, then
     * no operation occurs.
     * 
     * @param name represents the name of a value desired to be removed.
     *
     * @return the value of name that was removed or null if name was not
     *         removed.
     *
     */
    public String removeValue ( String name );

    /**
     *
     * This method will return an array of all names in the order in which
     * they were set.
     *
     * @return an array of all names in the order in which they were set.
     *
     */
    public String[] getNames ();

    /**
     *
     * This method will set data for name.
     *
     * @param key represents the key for which data is the value.
     *
     * @param data represents the data referred to by name.
     *
     */
    public void setData ( Object key, Object data );

    /**
     *
     * This method will return data for key, or null if no data exists.
     *
     * @param key represents the key for which a value is desired.
     *
     * @return the data for key or null if no value exists for key.
     *
     */
    public Object getData ( Object key );

    /**
     *
     * This method will return data for key, or defaultData if no data exists.
     *
     * @param key represents the key for which a value is desired.
     *
     * @return the data for key or defaultData if no value exists for key.
     *
     */
    public Object getData ( Object key, Object defaultData );

    /**
     *
     * This method will return required data for key.
     *
     * @param key represents the key for which a value is desired.
     *
     * @return the data for key.
     *
     * @throws ValueNotFoundException if data could not be found for key. 
     *
     */
    public Object getRequiredData ( Object key ) throws ValueNotFoundException;

    /**
     *
     * This method will remove data for key.  If key is not defined, then
     * no operation occurs.
     * 
     * @param key represents the data desired to be removed.
     *
     * @return the data removed.
     *
     */
    public Object removeData ( Object key );

    /**
     *
     * This method will return an array of all keys.
     *
     * @return an array of all keys.
     *
     */
    public Object[] getDataKeys ();

    /**
     *
     * This method will put all data (including name/values) from self to the
     * specified environment.
     *
     * @param environment represents the environment for which data will be
     *        placed from self.
     *
     */
    public void putAll ( EnvironmentIfc environment );

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public EnvironmentIfc createCopy ();
}

