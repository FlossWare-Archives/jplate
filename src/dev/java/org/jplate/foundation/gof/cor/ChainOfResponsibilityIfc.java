package org.jplate.foundation.gof.cor;

import java.util.List;

import org.jplate.foundation.processor.ProcessorIfc;


/**
 
    Defines the "Gang of Four" Chain of Responsibility pattern:  <i>"Avoid
    coupling the sender of a request to its receiver by giving more than one object
    a chance to handle the request.  Chain the receiving objects and pass the
    request along the chain until an object handles it,"</i> p223 Design Patterns -
    Elements of Reusable Object-Oriented Software.

    <br/>

    <b><i>Please note:</i></b> implementations may opt to stop requesting processors
    in the chain from processing if those processor return <code>null</code> on
    call to the {@link #process} method.  The default implementation
    {@link org.jplate.foundation.gof.cor.impl.defaults.DefaultChainOfResponsibility}
    does just this.

    <p/><a  name = "Examples"/>

    <br/>
    
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/cor/ChainOfResponsibilityIfc.java $
    </pre>

    @param <V> The object to be processed.

    @param <P> The processors in the chain.

*/
public interface ChainOfResponsibilityIfc <V, P extends ProcessorIfc <V>>
    extends ProcessorIfc <V>
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
     * Returns the processors who make up the chain.  This method may be used to
     * add/remove processors.  Implementations must ensure thread-safety in a
     * multi-threaded environment.
     *
     * @return the list of processors who make up the chain.
     *
     */
    public List <P> getProcessors ();
}
