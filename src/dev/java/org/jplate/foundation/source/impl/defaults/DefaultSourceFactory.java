package org.jplate.foundation.source.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.source.SourceFactoryIfc;
import org.jplate.foundation.source.SourceIfc;


/**

    Default implementation of {@link org.jplate.foundation.source.SourceFactoryIfc}
    that creates {@link DefaultSource}.

    <p/><a  name = "Examples"/>
    The following are some examples on how to use this class:<br/>

    <p/>
    <ul>
        <li>
            Create a URL source that contains data at line 1 and column 1:
            <pre>
final SourceFactoryIfc &lt;URL&gt; sourceFactory =
    new DefaultSourceFactory &lt;URL&gt; ();

final SourceIfc &lt;URL&gt; urlSource =
    sourceFactory.create ( new URL ( "http://jplate.sourceforge.net", 1, 1 ) );
            </pre>
        </li>

        <li>
            Create a File source that contains data at line 20 and column 50:
            <pre>
final SourceFactoryIfc &lt;File&gt; sourceFactory =
    new DefaultSourceFactory &lt;File&gt; ();

final SourceIfc &lt;File&gt; fileSource =
    sourceFactory.create ( new File ( "/home/sfloess/some-file.txt", 20, 50 ) );
            </pre>
        </li>
    </ul>

    <b><i>Please note:</i></b>  Instances of DefaultSource can be created using the
                                default constructor of DefaultSource.
    <p/>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/source/impl/defaults/DefaultSourceFactory.java $
    </pre>

    @param <S> The real "source" (for instance, file, URL, etc).

    @see org.jplate.foundation.source.impl.defaults.DefaultSource

*/
public final class DefaultSourceFactory <S> implements SourceFactoryIfc <S>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
    //
    // Static class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static member definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------

    /**
     *
     * For serialization purposes.
     *
     */
    private static final long serialVersionUID = -4015873532569324627L;


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance member definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( DefaultSourceFactory.class );


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Default constructor.
     *
     */
    public DefaultSourceFactory ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "New source factory created" );
        }
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * {@inheritDoc}
     *
     */
    public SourceIfc <S> createSource
        ( final S source, final int line, final int column )
    {
        final SourceIfc <S> retVal =
            new DefaultSource <S> ( source, line, column );

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Created new source [" + retVal + "]" );
        }

        return retVal;
    }
}

