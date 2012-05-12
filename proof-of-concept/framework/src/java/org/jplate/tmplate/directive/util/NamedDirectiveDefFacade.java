package org.jplate.tmplate.directive.util;

import org.jplate.tmplate.directive.NamedDirectiveDefIfc;

import org.jplate.tmplate.directive.def.NamedDirectiveDefFactoryIfc;
import org.jplate.tmplate.directive.def.NamedDirectiveDefFactoryMgrIfc;
import org.jplate.tmplate.directive.def.NamedDirectiveDefFactoryMgr;

import org.jplate.tmplate.directive.named.*;

/**
 *
 * This class satisfies the NamedDirectiveDefFacadeIfc interface and adheres to
 * the Singleton pattern.  This class will get all the named directives.
 *
 */
public final class NamedDirectiveDefFacade implements NamedDirectiveDefFacadeIfc
{
    /**
     *
     * This class manages our singleton.
     *
     */
    private static final class NamedDirectiveDefFacadeSingleton
    {
        static final NamedDirectiveDefFacadeIfc _singleton =
            new NamedDirectiveDefFacade ();
    }

    /**
     *
     * These are the named directives.
     *
     */
    private final NamedDirectiveDefIfc _namedDirectives[];

    /**
     *
     * Default constructor not allowed.
     *
     */
    private NamedDirectiveDefFacade ()
    {
        final NamedDirectiveDefFactoryMgrIfc defFactoryMgr =
            NamedDirectiveDefFactoryMgr.getSingleton ();

        final NamedDirectiveDefFactoryIfc defFactory =
            defFactoryMgr.getFactory ( getClass () );

        _namedDirectives =
            new NamedDirectiveDefIfc[]
            {
                defFactory.createNamedDirectiveDef
                (
                     "Alias", new AliasDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Block", new BlockDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "CatchException", new CatchExceptionDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "ComputeValue", new ComputeValueDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Copy", new CopyDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Count", new CountDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Date", new DateDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "DefaultValue", new DefaultValueDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "GetContent", new GetContentDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "GetProperties", new GetPropertiesDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "GetProperty", new GetPropertyDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "GetValue", new GetValueDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "IfValueDefined", new IfValueDefinedDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "IfValueEqual", new IfValueEqualDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Import", new ImportDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Loop", new LoopDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "New", new NewDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "OperatingSystemCall",
                     new OperatingSystemCallDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "Pause", new PauseDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "RequiredValue", new RequiredValueDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "SetProperty", new SetPropertyDirective ()
                ),

                defFactory.createNamedDirectiveDef
                (
                     "SetValue", new SetValueDirective ()
                )
            };
    }

    /**
     *
     * This method will return our singleton.
     *
     * @return our singelton.
     *
     */
    public static NamedDirectiveDefFacadeIfc getSingleton ()
    {
        return NamedDirectiveDefFacadeSingleton._singleton;
    }

    /**
     *
     * This method will get all named directives.
     *
     * @return all named directives.
     *
     */
    public NamedDirectiveDefIfc[] getNamedDirectives ()
    {
        return _namedDirectives;
    }
}
