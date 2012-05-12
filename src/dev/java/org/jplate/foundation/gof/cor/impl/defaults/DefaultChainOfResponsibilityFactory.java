package org.jplate.foundation.gof.cor.impl.defaults;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.cor.ChainOfResponsibilityFactoryIfc;
import org.jplate.foundation.gof.cor.ChainOfResponsibilityIfc;

import org.jplate.foundation.gof.factory.impl.AbstractFactory;

import org.jplate.foundation.processor.ProcessorIfc;


/**
 
    Default implementation of ChainOfResponsibilityFactoryIfc.  This class creates
    DefaultChainOfResponsibility instances.

    <br/>

    <p/><a  name = "Examples"/>

    The following example illustrates a trivial implementation of a person, a
    person processor and the chain of responsibility for processing a person:

    <pre>
public final class PersonIfc
{
    public String getName ();

    public int getAge ();
}

final class PersonAgeProcessor implements ProcessorIfc &lt;PersonIfc&gt;
{
    public PersonIfc process ( final PersonIfc person )
    {
        // Do some person age work here...

        return person;
    }
}

final ChainOfResponsibilityFactory
    &lt;DefaultChainOfResponsibility &lt;PersonIfc, PersonAgeProcessor&gt;&gt;
        corFactory =
            new DefaultChainOfResponsibilityFactory &lt;PersonIfc, PersonAgeProcessor&gt;

final ChainOfResponsibility &lt;PersonIfc, PersonAgeProcessor&gt; cor =
    corFactory.create ();
    </pre>

    <br/>

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/cor/impl/defaults/DefaultChainOfResponsibilityFactory.java $
    </pre>

    @param <V> The object to be processed.

    @param <P> The processors in the chain.

*/
public class DefaultChainOfResponsibilityFactory
    <V, P extends ProcessorIfc <V>>
        extends    AbstractFactory <DefaultChainOfResponsibility <V, P>>
        implements ChainOfResponsibilityFactoryIfc
            <DefaultChainOfResponsibility <V, P>>
{
    // ----------------------------------------------------------------------
    //
    // Interface definitions follow...
    //
    // ----------------------------------------------------------------------

    
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
     * Used for serialization.
     *
     */
    private static final long serialVersionUID = -4408044167698590227L;


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

    /**
     *
     * Used for logging.
     *
     */
    private final transient Log _log =
        LogFactory.getLog ( DefaultChainOfResponsibilityFactory.class );


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
    public DefaultChainOfResponsibilityFactory ()
    {
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
    public DefaultChainOfResponsibility <V, P> create ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning a new DefaultChainOfResponsibility" );
        }

        return new DefaultChainOfResponsibility <V, P> ();
    }
}
