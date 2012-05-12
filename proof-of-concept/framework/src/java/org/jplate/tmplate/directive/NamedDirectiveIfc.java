package org.jplate.tmplate.directive;

/**
 *
 * This interface defines the API for named directives.
 *
 */
public interface NamedDirectiveIfc extends DirectiveIfc
{
    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public NamedDirectiveIfc createCopy ();
}
