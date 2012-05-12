package org.jplate.foundation.source;


import java.io.Serializable;

import org.jplate.foundation.FormattableIfc;


/**
 
    Defines a source:  meaning, the place from which something was defined as well
    as the line and column number where found.  For instance, consider data
    contained in a file:  the source defines three attributes - the file itself, the
    line number and column number in the file.

    For an example implementation and usage, please refer to
    {@link org.jplate.foundation.source.impl.defaults.DefaultSource}.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/source/SourceIfc.java $
    </pre>

    @param <S> The real "source" (for instance, file, URL, etc).

    @see org.jplate.foundation.source.impl.defaults.DefaultSource
     
*/
public interface SourceIfc <S> extends Serializable, FormattableIfc
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
     * Defines no known line in source.
     *
     */
    public static final int UNKNOWN_LINE = -1;


    /**
     *
     * Defines no known column in source.
     *
     */
    public static final int UNKNOWN_COLUMN = -1;


    // ----------------------------------------------------------------------
    //
    // Static methods follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * Returns the actual "source."  For instance if a source is defined by a File,
     * the file represents the actual source.
     *
     * @return The source.
     *
     */
    public S getSource ();


    /**
     *
     * Returns the line number in {@link #getSource}.
     *
     * @return The line number.
     *
     */
    public int getLine ();


    /**
     *
     * Returns the column number in {@link #getSource}.
     *
     * @return The column number.
     *
     */
    public int getColumn ();
}
