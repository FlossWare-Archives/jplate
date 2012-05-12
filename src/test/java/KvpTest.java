import java.util.List;

import org.jplate.kvp.KvpIfc;

import org.jplate.kvp.util.KvpUtil;

public class KvpTest
{
    public static void main ( final String[] args )
    {
        try
        {
            final List <KvpIfc> kvpList =
                KvpUtil.getAsList
                (
                    "line1-key=line1 value One\n" +
                    "line2-key=line2 value One Two\n" +
                    "line3-key=line3 value One Two Three\n" +
                    "line4-key=line4 value One Two Three Four"
                );

            System.out.println ();
            System.out.println ();

            for ( KvpIfc kvp : kvpList )
            {
                System.out.println ( "KVP:  [" + kvp + "]" );
            }

            System.out.println ();
        }

        catch ( final Throwable throwable )
        {
            throwable.printStackTrace ();
        }
    }
}
