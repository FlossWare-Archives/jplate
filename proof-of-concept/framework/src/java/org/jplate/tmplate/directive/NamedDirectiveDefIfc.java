package org.jplate.tmplate.directive;

/**
 *
 * This interface defines the API that associates a named directive to a name.
 *
 */
public interface NamedDirectiveDefIfc
{
    /**
     *
     * This method will return the name.
     *
     * @return the name.
     *
     */
    public String getName ();

    /**
     *
     * This method will return the named directive.
     *
     * @return the named directive.
     *
     */
    public NamedDirectiveIfc getNamedDirective ();

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public NamedDirectiveDefIfc createCopy ();
}
