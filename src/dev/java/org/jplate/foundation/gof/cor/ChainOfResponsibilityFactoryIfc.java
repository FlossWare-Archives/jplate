package org.jplate.foundation.gof.cor;

import org.jplate.foundation.gof.factory.FactoryIfc;

import org.jplate.foundation.processor.ProcessorIfc;


/**
 
    Defines a factory for creating implementations of
    {@link ChainOfResponsibilityIfc}.
    
    <p/><a  name = "Examples"/>

    <br/>
    
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/cor/ChainOfResponsibilityFactoryIfc.java $
    </pre>

    @param <V> The type of ChainOfResponsibilityIfc to be created.

*/
public interface ChainOfResponsibilityFactoryIfc
    <V extends ChainOfResponsibilityIfc <?, ?>>
        extends FactoryIfc <V>
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


}
