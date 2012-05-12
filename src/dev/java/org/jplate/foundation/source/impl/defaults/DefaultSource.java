package org.jplate.foundation.source.impl.defaults;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.source.SourceIfc;

import org.jplate.foundation.util.Assert;
import org.jplate.foundation.util.SystemProperties;


/**
 
    Default implementation of {@link org.jplate.foundation.source.SourceIfc}.

    <p/><a  name = "Examples"/>
    The following are some examples on how to use this class:

    <p/>
    <ul>
        <li>
            Create a URL source that contains data at line 10 and column 50:
            <pre>
final SourceIfc &lt;URL&gt; urlSource =
    new DefaultSource &lt;URL&gt; DefaultSource ( new URL ( "http://jplate.sourceforge.net", 10, 50 ) );
            </pre>
        </li>

        <li>
            Create a File source that contains data at line 1 and column 11:
            <pre>
final SourceIfc &lt;File&gt; fileSource =
    new DefaultSource &lt;File&gt; DefaultSource ( new File ( "/home/sfloess/some-file.txt", 1, 11 ) );
            </pre>
        </li>
    </ul>

    <b><i>Please note:</i></b>  Instances can also be created using
                      DefaultSourceFactory.  Doing so allows a greater degree of
                      flexibility by not coupling code to this class.
    <p/>
    <pre>
Modifications:
   $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
   $Revision: 479 $
   $Author: sfloess $
   $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/source/impl/defaults/DefaultSource.java $
    </pre>

    @param <S> The real "source" (for instance, file, URL, etc).
 
*/
public final class DefaultSource <S> implements SourceIfc <S>
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


    /**
     *
     * Denotes that source is null.
     *
     */
    public static final String SOURCE_IS_NULL_MSG = "source == null";


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
    private static final long serialVersionUID = -1569053263759468648L;


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
    private final transient Log _log = LogFactory.getLog ( DefaultSource.class );


    /**
     *
     * This is the source from whence something exists.
     *
     */
    private final S _source;


    /**
     *
     * This is the line where something exists in source.
     *
     */
    private final int _line;


    /**
     *
     * This is the column where something exists in source.
     *
     */
    private final int _column;


    /**
     *
     * The hash code.
     *
     */
    private final int _hashCode;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor sets-up the source, line an column where something
     * exists.
     *
     * @param source The place from which something exists or originates (for
     *               instance a file).
     *
     * @param line   The line number in <code>source</code>.
     *
     * @param column The column number in <code>source</code>.
     *
     */
    public DefaultSource
        ( final S source, final int line, final int column )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "New source created:  source [" + source + "] line [" + line +
                "] column [" + column + "]"
            );
        }

        Assert.isReferenced ( SOURCE_IS_NULL_MSG, source );

        _source   = source;
        _line     = line;
        _column   = column;
        _hashCode = source.hashCode () + line + column;
    }


    /**
     *
     * Default constructor not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private DefaultSource ()
    {
        _log.error ( "Default constructor not allowed" );

        throw new UnsupportedOperationException ();
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This method returns a String representation of self.
     *
     * @return A String representation of self.
     *
     */
    public String toString ()
    {
        return toString ( "" );
    }
    

    /**
     *
     * {@inheritDoc}
     *
     */
    public String toString ( final String prepend )
    {
        final StringBuilder sb      = new StringBuilder ();
        final String        tab     = prepend + prepend;
        final String        newLine = SystemProperties.LINE_SEPARATOR; 

        sb.append ( prepend ).append ( getClass ().getName () ).append ( ':' );
        sb.append ( newLine );

        sb.append ( tab ).append ( "_source = <" ).append ( _source );
        sb.append ( '>' ).append ( newLine );

        sb.append ( tab ).append ( "_line   = <" ).append ( _line );
        sb.append ( '>' ).append ( newLine );

        sb.append ( tab ).append ( "_column = <" ).append ( _column );
        sb.append ( '>' ).append ( newLine );

        return sb.toString ();
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public S getSource ()
    {
        return _source;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int getLine ()
    {
        return _line;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int getColumn ()
    {
        return _column;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public int hashCode ()
    {
        return _hashCode;
    }


    /**
     *
     * Determines object equality.
     *
     * @param object to compare.
     *
     * @return true if self is equal to <code>object</code>.
     *
     */
    public boolean equals ( final Object object )
    {
        boolean retVal;

        if ( object == null )
        {
            retVal = false;
        }
        else if ( object == this )
        {
            retVal = true;
        }
        else if ( object.getClass () == DefaultSource.class )
        {
            DefaultSource src = ( DefaultSource ) object;

            retVal =
                _hashCode == src._hashCode  &&
                _line     == src._line      &&
                _column   == src._column    &&
                _source.equals ( src._source );
        }
        else if ( object instanceof SourceIfc )
        {
            SourceIfc src = ( SourceIfc ) object;

            retVal =
                _hashCode == src.hashCode  () &&
                _line     == src.getLine   () &&
                _column   == src.getColumn () &&
                _source.equals ( src.getSource () );
        }
        else
        {
            retVal = false;
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Compared self to object [" + object + "] = [" + retVal + "]"
            );
        }

        return retVal;
    }
}
