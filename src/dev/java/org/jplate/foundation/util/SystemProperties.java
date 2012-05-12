package org.jplate.foundation.util;

import java.util.HashMap;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Properties;


/**

    Represents non-synchronized read-only access to system properties.
    Commonly used system properties are defined here as public static strings
    thereby eliminating calling
    <code>System.getProperties ( &lt;property name&gt; )</code> - eliminates a
    method call as well as a call to a synchronized collection (namely
    {@link java.util.Properties} which is a subclass of {@link java.util.Hashtable}
    ).
    
    <p/>

    <b>Please note:</b>  system properties are read and stored at class load time.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $ <br/>
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/util/SystemProperties.java $
    </pre>
 
*/
public final class SystemProperties
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
    //
    // Static class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Holds the system properties in a non-synchronized collection.
     *
     */
    private static final Map <String, String> _systemProperties;


    /**
     *
     * Line separator property name.
     *
     */
    public static final String LINE_SEPARATOR_PROPERTY = "line.separator";


    /**
     *
     * Default new line.
     *
     */
    private static final String DEFAULT_NEW_LINE = "\n";


    /**
     *
     * File separator property name.
     *
     */
    public static final String FILE_SEPARATOR_PROPERTY = "file.separator";

        
    /**
     *
     * Class path property name.
     *
     */
    public static final String CLASS_PATH_PROPERTY = "java.class.path";


    /** 
     *
     * Class version property name.
     *
     */
    public static final String CLASS_VERSION_PROPERTY = "java.class.version";


    /**
     *
     * Java home property name.
     *
     */
    public static final String JAVA_HOME_PROPERTY = "java.home";


    /**
     *
     * Java vendor property name.
     *
     */
    public static final String JAVA_VENDOR_PROPERTY = "java.vendor";


    /**
     *
     * Java vendor URL property name.
     *
     */
    public static final String JAVA_VENDOR_URL_PROPERTY = "java.vendor.url";


    /**
     *
     * Java version property name.
     *
     */
    public static final String JAVA_VERSION_PROPERTY = "java.version";
        

    /**
     *
     * Operating system architecture property name.
     *
     */
    public static final String OS_ARCHITECTURE_PROPERTY = "os.arch";


    /**
     *
     * Operating system name property name.
     *
     */
    public static final String OS_NAME_PROPERTY = "os.name";


    /**
     *
     * Operating system version property name.
     *
     */
    public static final String OS_VERSION_PROPERTY = "os.version";
       

    /**
     *
     * Path separator property name.
     *
     */
    public static final String PATH_SEPARATOR_PROPERTY = "path.separator";
        

    /**
     *
     * Current working user dir property name.
     *
     */
    public static final String USER_DIR_PROPERTY = "user.dir";


    /**
     *
     * User home property name.
     *
     */
    public static final String USER_HOME_PROPERTY = "user.home";


    /**
     *
     * User name property name.
     *
     */
    public static final String USER_NAME_PROPERTY = "user.name";


    /**
     *
     * Access to line separator so one does not have to query a collection....
     *
     */
    public static final String LINE_SEPARATOR;
    

    /**
     *
     * Access to file separator so one does not have to query a collection....
     *
     */
    public static final String FILE_SEPARATOR;
    

    /**
     *
     * Access to class path so one does not have to query a collection....
     *
     */
    public static final String CLASS_PATH;


    /** 
     *
     * Access to class version so one does not have to query a collection....
     *
     */
    public static final String CLASS_VERSION;


    /**
     *
     * Access to java home so one does not have to query a collection....
     *
     */
    public static final String JAVA_HOME;


    /**
     *
     * Access to java vendor so one does not have to query a collection....
     *
     */
    public static final String JAVA_VENDOR;


    /**
     *
     * Access to java vendor URL so one does not have to query a collection....
     *
     */
    public static final String JAVA_VENDOR_URL;


    /**
     *
     * Access to java version so one does not have to query a collection....
     *
     */
    public static final String JAVA_VERSION;
        

    /**
     *
     * Access to operating system architecture so one does not have to query a
     * collection....
     *
     */
    public static final String OS_ARCHITECTURE;


    /**
     *
     * Access to operating system name so one does not have to query a
     * collection....
     *
     */
    public static final String OS_NAME;


    /**
     *
     * Access to operating system version so one does not have to query a
     * collection....
     *
     */
    public static final String OS_VERSION;
       

    /**
     *
     * Access to path separator so one does not have to query a collection....
     *
     */
    public static final String PATH_SEPARATOR;
        

    /**
     *
     * Access to current working user dir so one does not have to query a
     * collection....
     *
     */
    public static final String USER_DIR;


    /**
     *
     * Access to user home so one does not have to query a collection....
     *
     */
    public static final String USER_HOME;


    /**
     *
     * Access to user name so one does not have to query a collection....
     *
     */
    public static final String USER_NAME;


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * We will loop through all system properties and store the properties in
     * a non-synchronized read-only <code>Map</code> as well as gather the commonly
     * used properties and store as data members (for instance the system line
     * separator).
     *
     */
    static
    {
        final Map <String, String> systemProperties =
            new HashMap <String, String> ();

        for ( final Map.Entry entry : System.getProperties ().entrySet () )
        {
            final Object value = entry.getValue ();

            systemProperties.put
            (
                entry.getKey ().toString (),
                ( value != null ? value.toString () : "" )
            );
        }

        LINE_SEPARATOR =
            ComputeData.computeValue
            (
                systemProperties.get ( LINE_SEPARATOR_PROPERTY ),
                DEFAULT_NEW_LINE
            );

        FILE_SEPARATOR  = systemProperties.get ( FILE_SEPARATOR_PROPERTY  );
        CLASS_PATH      = systemProperties.get ( CLASS_PATH_PROPERTY      );
        CLASS_VERSION   = systemProperties.get ( CLASS_VERSION_PROPERTY   );
        JAVA_HOME       = systemProperties.get ( JAVA_HOME_PROPERTY       );
        JAVA_VENDOR     = systemProperties.get ( JAVA_VENDOR_PROPERTY     );
        JAVA_VENDOR_URL = systemProperties.get ( JAVA_VENDOR_URL_PROPERTY );
        JAVA_VERSION    = systemProperties.get ( JAVA_VERSION_PROPERTY    );
        OS_ARCHITECTURE = systemProperties.get ( OS_ARCHITECTURE_PROPERTY );
        OS_NAME         = systemProperties.get ( OS_NAME_PROPERTY         );
        OS_VERSION      = systemProperties.get ( OS_VERSION_PROPERTY      );
        PATH_SEPARATOR  = systemProperties.get ( PATH_SEPARATOR_PROPERTY  );
        USER_DIR        = systemProperties.get ( USER_DIR_PROPERTY        );
        USER_HOME       = systemProperties.get ( USER_HOME_PROPERTY       );
        USER_NAME       = systemProperties.get ( USER_NAME_PROPERTY       );

        _systemProperties = systemProperties;
    }


    /**
     *
     * Return a property value for the property entitled <code>name</code> or null
     * if one does not exist.
     *
     * @param name The property name for which a value is to be sought.
     *
     * @return null If no property exists whose name is name.
     *
     */
    public static String getProperty ( final String name )
    {
        return _systemProperties.get ( name );
    }


    /**
     *
     * Return a property value for property <code>name</code> or
     * <code>defaultValue</code> if one does not exist.
     *
     * @param name         The property name for which a value is to be sought.
     *
     * @param defaultValue The value to return if no property value
     *                     exists for <code>name</code>.
     *
     * @return The value for <code>name</code> or <code>defaultValue</code> if no
     *         property exists whose name is <code>name</code>.
     *
     */
    public static String getProperty
        ( final String name, final String defaultValue )
    {
        return ComputeData.computeString ( getProperty ( name ), defaultValue );
    }


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------

    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private SystemProperties ()
    {
        throw new UnsupportedOperationException ();
    }

    
    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
 
