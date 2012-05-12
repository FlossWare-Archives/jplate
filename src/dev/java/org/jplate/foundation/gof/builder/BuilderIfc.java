package org.jplate.foundation.gof.builder;

/**
 
    Defines the "Gand of Four" Builder pattern:  <i>"Separate the construction of a
    complex object from its representation so that the same construction process can
    create different representations,"</i> p97 Design Patterns - Elements of
    Reusable Object-Oriented Software.

    Subclasses are responsible for providing their respective domain
    <code>build()</code> methods.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/builder/BuilderIfc.java $
    </pre>

    @param <V> The object built by self.

*/
public interface BuilderIfc <V>
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
     * Return the built object.
     *
     * @return the built object.
     *
     */
    public V getResult ();


    /**
     *
     * Reset any result currently held.
     *
     */
    public void reset ();
}
