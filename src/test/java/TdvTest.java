import java.util.List;

import org.jplate.tabular.util.TdvUtil;

public class TdvTest
{
    public static void main ( final String[] args )
    {
        try
        {
            final List <List <String>> tdvList =
                TdvUtil.getAsList
                (
                    "line 1 col 1\n" +
                    "line 2 col 1\tLine 2 col 2\n" +
                    "line 3 col 1\tLine 3 col 2\tLine 3 Col 3\n" +
                    "line 4 col 1\tLine 4 col 2"
                );

            System.out.println ();
            System.out.println ();

            for ( List <String> record : tdvList )
            {
                System.out.print ( "Record:  " );

                for ( String field : record )
                {
                    System.out.print ( field );
                    System.out.print ( ':'   );
                }

                System.out.println ();
            }

            System.out.println ();
        }

        catch ( final Throwable throwable )
        {
            throwable.printStackTrace ();
        }
    }
}
