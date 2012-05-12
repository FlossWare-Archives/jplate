package org.jplate.tmplate.directive.util;

import org.jplate.tmplate.directive.NamedDirectiveDefIfc;

/**
 *
 * This interface defines the API to get all the named directives.
 *
 */
public interface NamedDirectiveDefFacadeIfc
{
    /**
     *
     * This method will get all named directives.
     *
     * @return all named directives.
     *
     */
    public NamedDirectiveDefIfc[] getNamedDirectives ();
}
