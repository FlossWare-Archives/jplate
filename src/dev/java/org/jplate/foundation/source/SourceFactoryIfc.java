package org.jplate.foundation.source;


import java.io.Serializable;


/**
 
    Defines the API for creating implementations of SourceIfc.

    For an example implementation and usage, please refer to
    {@link org.jplate.foundation.source.impl.defaults.DefaultSourceFactory}.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/source/SourceFactoryIfc.java $
    </pre>

    @param <S> The real "source" (for instance, file, URL, etc).

    @see org.jplate.foundation.source.impl.defaults.DefaultSourceFactory
 
*/
public interface SourceFactoryIfc <S> extends Serializable
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
     * Create and return a source.
     *
     * @param source The "real" source from which something exists (for instance a
     *               file).
     *
     * @param line   The line number in <code>source</code>.
     *
     * @param column The column number in <code>source.</code>
     *
     * @return A source.
     *
     */
    public SourceIfc <S> createSource ( S source, int line, int column );
}

