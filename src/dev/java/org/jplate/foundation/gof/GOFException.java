package org.jplate.foundation.gof;

import org.jplate.foundation.FoundationException;

/**

    Base exception for all "Gang of Four" errors.

    <p/>
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/GOFException.java $
    </pre>
  
*/
public class GOFException extends FoundationException
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
    public GOFException ()
    {
    }

    /**
     *
     * This constructor sets the message.
     *
     * @param msg A message about why self was raised.
     *
     */
    public GOFException ( final String msg )
    {
        super ( msg );
    }


    /**
     *
     * This constructor sets the root cause.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     */
    public GOFException ( final Throwable rootCause )
    {
        super ( rootCause );
    }


    /**
     *
     * This constructor sets the message and root cause.
     *
     * @param msg       A message about why self was raised.
     *
     * @param rootCause The exception that caused self to be raised.
     *
     */
    public GOFException ( final String msg, final Throwable rootCause )
    {
        super ( msg, rootCause );
    }


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------
}
