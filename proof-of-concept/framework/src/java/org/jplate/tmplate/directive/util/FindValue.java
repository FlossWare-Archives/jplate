package org.jplate.tmplate.directive.util;

import org.jplate.tmplate.directive.DirectiveContainerIfc;

/**
 *
 * This class satisfies the FindValueIfc interface and adheres to the Singleton
 * pattern.  It will find a value from directive container's environments.
 *
 */
public final class FindValue implements FindValueIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class FindValueSingleton
    {
        static final FindValueIfc _singleton = new FindValue ();
    }

    /**
     *
     * Default constructor.
     *
     */
    private FindValue ()
    {
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singelton.
     *
     */
    public static FindValueIfc getSingleton ()
    {
        return FindValueSingleton._singleton;
    }

    /**
     *
     * This method will return a value for name or null if no value could be
     * found.  Please note that if name is not found in directiveContainer's
     * environment, its parent will be searched.  This will continue until
     * either the value is found or no parent is found.
     *
     * @param directiveContainer represents the directive container for whom we
     *        search for a value for name.
     *
     * @param name represents the name for a value desired.
     *
     * @return the value for name or null if no value can be found.
     *
     */
    public String findValue
        ( final DirectiveContainerIfc directiveContainer, final String name )
    {
        String retVal;

        if ( directiveContainer == null )
        {
            retVal = null;
        }
        else
        {
            retVal = directiveContainer.getEnvironment ().getValue ( name );

            if ( retVal == null )
            {
                retVal = findValue ( directiveContainer.getParent (), name );
            }
        }

        return retVal;
    }
}
