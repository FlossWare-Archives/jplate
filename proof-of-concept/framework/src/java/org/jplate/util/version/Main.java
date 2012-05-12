package org.jplate.util.version;

/**
 *
 * This class is an application to create a version file.
 *
 * <p>
 * The required command line params are:
 * <ul>
 *      <li><code>-fileName &lt;version file name&gt;</code></li>
 *      
 *      <p>
 *      <li><code>-version &lt;version number&gt;</code></li>
 *  <ul>
 *
 */
public final class Main
{
    /**
     *
     * This represents the file name argument.
     *
     */
    public static final String FILE_NAME_ARG = "-fileName";

    /**
     *
     * This line represents the version argument.
     *
     */
    public static final String VERSION_ARG = "-version";

    /**
     *
     * Default constructor is not allowed.
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
     * This is our application method.
     *
     * @param args represents the arguments to the application.
     *
     */
    public static void main ( final String args[] )
    {
        boolean isExitFailure = false;

        try
        {
            final String fileNameArg = FILE_NAME_ARG;
            final String versionArg  = VERSION_ARG;

            String fileName = null;
            String version  = null;

            final int total = args.length;

            for ( int index = 0; index < total; index++ )
            {
                final String arg = args [ index ];

                if ( fileNameArg.equals ( arg ) )
                {
                    fileName = args [ ++index ];
                }
                else if ( versionArg.equals ( arg ) )
                {
                    version = args [ ++index ];
                }
            }

            if ( fileName == null || "".equals ( fileName ) )
            {
                System.out.println ( "File name is required!" );
                isExitFailure = true;
            }

            if ( version == null || "".equals ( version ) )
            {
                System.out.println ( "Version is required!" );
                isExitFailure = true;
            }
        }

        catch ( final Throwable throwable )
        {
            throwable.printStackTrace ();

            isExitFailure = true;
        }

        if ( isExitFailure )
        {
            System.exit ( 1 );
        }
    }
}
