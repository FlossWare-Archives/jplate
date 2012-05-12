package org.jplate.tmplate.directive;

/**
 *
 * This interface defines the API to create/define directives.
 *
 */
public interface DirectiveCacheIfc
{
    /**
     *
     * This method will validate that name is an actual directive name.
     *
     * @param name represents the name of the directive.
     *
     * @return true if name is a valid directive name or false if not.
     *
     */
    public boolean isValidDirectiveName ( String name );

    /**
     *
     * This method will return a named directive.
     *
     * @param name represents the name of the directive.
     *
     * @return a named directive.
     *
     * @throws UnknownNamedDirectiveException if name cannot be found.  Please
     *         note that this should not be thrown if calling
     *         isValidDirectiveName ( name ) returns true!
     *
     */
    public NamedDirectiveIfc getNamedDirective ( String name )
        throws UnknownNamedDirectiveException;

    /**
     *
     * This method will define a new named directive.
     *
     * @param name represents the name of the named directive.
     *
     * @param directive represents the newly defined directive.
     *
     */
    public void defineNamedDirective
        ( String name, NamedDirectiveIfc directive );

    /**
     *
     * This method will define a new named directive.
     *
     * @param namedDirectiveDef represents the named directive definition.
     *
     */
    public void defineNamedDirective ( NamedDirectiveDefIfc namedDirectiveDef );

    /**
     *
     * This method will define new named directives.
     *
     * @param namedDirectiveDefs represents an array of named directive
     *        definitions.
     *
     */
    public void defineNamedDirectives
        ( NamedDirectiveDefIfc namedDirectiveDefs[] );

    /**
     *
     * This method will copy a directive.  By copy, really it maps newName
     * to the same directive as oldName.
     *
     * @param oldName represents the original name of a directive.
     *
     * @param newName represents the new name of a directive.
     *
     * @throws UnknownNamedDirectiveException if no directive exists for
     *         oldName.
     *
     */
    public void copyNamedDirective ( String oldName, String newName )
        throws UnknownNamedDirectiveException;

    /**
     *
     * This method will return all the names of directives defined.
     *
     * @return the name of all directives defined.
     *
     */
    public String[] getDirectiveNames ();

    /**
     *
     * This method will return all the named directives defined.
     *
     * @return the name of all named directives defined.
     *
     */
    public NamedDirectiveDefIfc[] getNamedDirectives ();

    /**
     *
     * This method will create a parsed character directive.
     *
     * @return a parsed character directive.
     *
     */
    public PCDataDirectiveIfc createPCDataDirective ();

    /**
     *
     * This method will create a parsed character directive with the data.
     *
     * @param pcData represents the parsed character data for the PCData
     *        directive.
     *
     * @return a parsed character directive.
     *
     */
    public PCDataDirectiveIfc createPCDataDirective ( String pcData );

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public DirectiveCacheIfc createCopy ();
}
