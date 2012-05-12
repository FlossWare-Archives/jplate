package org.jplate.tmplate.util;

import org.jplate.tmplate.directive.DirectiveContainerIfc;

import org.jplate.tmplate.directive.util.DirectiveContainerFacadeIfc;
import org.jplate.tmplate.directive.util.DirectiveContainerFacade;

/**
 *
 * This application class will load jplate resource files and translate them.
 *
 * <p>
 * <b>Useage</b>
 *
 * <pre>
 * java org.jplate.tmplate.util.Main <jplate resource name(s)> 
 * </pre>
 *
 * To load the jplate resources <code>foo.jp</code> and <code>bar.jp</code>, do
 * the following:
 *
 * <pre>
 * java org.jplate.tmplate.util.Main foo.jp bar.jp
 * </pre>
 *
 * <b>Please note:</b>  This class simply retrieves the resource(s) requested
 * and has <code>org.jplate.tmplate.directive.util.DirectiveContainerFacade
 * </code> translate the resource.
 *
 * @see org.jplate.tmplate.directive.util.DirectiveContainerFacadeIfc
 * @see org.jplate.tmplate.directive.util.DirectiveContainerFacade
 *
 */
public final class Main
{
    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private Main ()
    {
        throw new UnsupportedOperationException ();
    }
    
    /**
     *
     * This is the application method.  The assumption is jplate resource names
     * are contained in args.
     *
     * @param args represent an array of Strings that should be jplate resource
     *        names.
     *
     */
    public static void main ( String args[] )
    {
        final int argCount = args.length;

        if ( argCount < 1 )
        {
            System.out.println
            (
                "\n\nUseage:  java " + Main.class.getName () +
                " <resource name of jplate file1> [ ... <resource name of " +
                "jplate fileN>]\n\n"
            );

            System.exit ( 1 );
        }
        else
        {
            final DirectiveContainerFacadeIfc facade =
                DirectiveContainerFacade.getSingleton ();

            final Class mainClass = Main.class;

            for ( int loop = 0; loop <argCount; loop++ )
            {
                final String jplateFile = args [ loop ];

                System.out.println ( "JPlate file:  " + jplateFile );

                System.out.println ( "-----------------------" );

                try
                {
                    final DirectiveContainerIfc container =
                        facade.convertFromInputStream
                        (
                            mainClass.getResourceAsStream ( jplateFile )
                        );

                    System.out.println ( container.translate () );
                }

                catch ( final Throwable throwable )
                {
                    throwable.printStackTrace ();
                }
            }
        }
    }
}
