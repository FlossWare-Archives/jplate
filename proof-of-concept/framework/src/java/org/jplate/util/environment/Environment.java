package org.jplate.util.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * This class is the implementation of the EnvironmentIfc interface and provides
 * the environment functionality.
 *
 */
final class Environment implements EnvironmentIfc
{
    /**
     *
     * This is our cache of values.
     *
     */
    private final Map _valueCache;

    /**
     *
     * This is a list of our names.
     *
     */
    private final List _nameList;

    /**
     *
     * This is our cache of data.
     *
     */
    private final Map _dataCache;

    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    Environment ()
    {
        _valueCache = new HashMap   ();
        _nameList   = new ArrayList ();
        _dataCache  = new HashMap   ();
    }

    /**
     *
     * This is the copy constructor.
     *
     * @param environment represents the environment to copy.
     *
     */
    private Environment ( final Environment environment )
    {
        final Map  valueCache = new HashMap   ();
        final List nameList   = new ArrayList ();
        final Map  dataCache  = new HashMap   ();

        valueCache.putAll ( environment._valueCache );
        nameList.addAll   ( environment._nameList   );
        dataCache.putAll  ( environment._dataCache  );

        _valueCache = valueCache;
        _nameList   = nameList;
        _dataCache  = dataCache;
    }

    /**
     *
     * This method will set a value for name.
     *
     * @param name represents the name for which value is a value.
     *
     * @param value represents a value for name.
     *
     */
    public void setValue ( final String name, final String value )
    {
        final Map valueCache = _valueCache;

        if ( valueCache.get ( name ) == null )
        {
            _nameList.add ( name );
        }

        valueCache.put ( name, value );
    }

    /**
     *
     * This method will return a value for name, or null if no value exists.
     *
     * @param name represents the name for which a value is desired.
     *
     * @return the value for name or null if no value exists for name.
     *
     */
    public String getValue ( final String name )
    {
        return ( String ) _valueCache.get ( name );
    }

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
    public String getValue ( final String name, final String defaultValue )
    {
        final String value = getValue ( name );

        return ( value != null ? value : defaultValue );
    }

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
    public String getRequiredValue ( final String name )
        throws ValueNotFoundException
    {
        final String retVal = getValue ( name );

        if ( retVal == null )
        {
            throw new ValueNotFoundException ( "name = <" + name + ">" );
        }

        return retVal;
    }

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
    public String removeValue ( final String name )
    {
        final String value = ( String ) _valueCache.remove ( name );

        if ( value != null )
        {
            _nameList.remove ( name );
        }

        return value;
    }

    /**
     *
     * This method will return an array of all names in the order in which
     * they were set.
     *
     * @return an array of all names in the order in which they were set.
     *
     */
    public String[] getNames ()
    {
        final List   nameList = _nameList;
        final int    size     = nameList.size ();
        final String names[]  = new String [ size ];

        nameList.toArray ( names );

        return names;
    }

    /**
     *
     * This method will set data for name.
     *
     * @param key represents the key for which data is the value.
     *
     * @param data represents the data referred to by name.
     *
     */
    public void setData ( final Object key, final Object data )
    {
        _dataCache.put ( key, data );
    }

    /**
     *
     * This method will return data for key, or null if no data exists.
     *
     * @param key represents the key for which a value is desired.
     *
     * @return the data for key or null if no value exists for key.
     *
     */
    public Object getData ( final Object key )
    {
        return _dataCache.get ( key );
    }

    /**
     *
     * This method will return data for key, or defaultData if no data exists.
     *
     * @param key represents the key for which a value is desired.
     *
     * @return the data for key or defaultData if no value exists for key.
     *
     */
    public Object getData ( final Object key, final Object defaultData )
    {
        final Object data = getData ( key );

        return ( data != null ? data : defaultData );
    }

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
    public Object getRequiredData ( final Object key )
        throws ValueNotFoundException
    {
        final Object retVal = getData ( key );

        if ( key == null )
        {
            throw new ValueNotFoundException
            (
                "key = <" + key.toString () + ">"
            );
        }

        return key;
    }

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
    public Object removeData ( final Object key )
    {
        return _dataCache.remove ( key );
    }

    /**
     *
     * This method will return an array of all keys.
     *
     * @return an array of all keys.
     *
     */
    public Object[] getDataKeys ()
    {
        final Set    keySet = _dataCache.keySet ();
        final int    size   = keySet.size ();
        final Object keys[] = new Object [ size ];

        keySet.toArray ( keys );

        return keys;
    }

    /**
     *
     * This method will put all data (including name/values) from self to the
     * specified environment.
     *
     * @param environment represents the environment for which data will be
     *        placed from self.
     *
     */
    public void putAll ( final EnvironmentIfc environment )
    {
        final Map      valueCache   = _valueCache;
        final Iterator nameIterator = _nameList.iterator ();

        while ( nameIterator.hasNext () )
        {
            final String key = ( String ) nameIterator.next ();

            environment.setValue ( key, ( String ) valueCache.get ( key ) );
        }
        
        final Map      dataCache = _dataCache;
        final Iterator dataItr   = dataCache.keySet ().iterator ();

        while ( dataItr.hasNext () )
        {
            final Object key = dataItr.next ();

            environment.setData ( key, dataCache.get ( key ) );
        }
    }

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public EnvironmentIfc createCopy ()
    {
        return new Environment ( this );
    }
}
 
