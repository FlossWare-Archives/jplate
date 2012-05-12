package org.jplate.tmplate.directive.util;

import org.jplate.tmplate.directive.DirectiveContainerIfc;

/**
 *
 * This interface defines the API to find a value from directive container's
 * environments.
 *
 */
public interface FindValueIfc
{
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
        ( DirectiveContainerIfc directiveContainer, String name );
}
