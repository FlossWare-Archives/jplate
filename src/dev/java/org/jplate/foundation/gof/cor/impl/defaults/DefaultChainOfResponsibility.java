package org.jplate.foundation.gof.cor.impl.defaults;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jplate.foundation.gof.cor.ChainOfResponsibilityIfc;

import org.jplate.foundation.processor.ProcessException;
import org.jplate.foundation.processor.ProcessorIfc;

import org.jplate.foundation.util.ListFactoryIfc;

import org.jplate.foundation.util.impl.UnsynchronizedLinkedListFactory;


/**
 
    Default implementation of the "Gang of Four" Chain of Responsibility pattern:
    <i>"Avoid coupling the sender of a request to its receiver by giving more than
    one object a chance to handle the request.  Chain the receiving objects and pass
    the request along the chain until an object handles it,"</i> p223 Design
    Patterns - Elements of Reusable Object-Oriented Software.

    <br/>

    <br/>
    
    <b><i>Please note:</i></b> when calling {@link #process}, if any processor
    returns <code>null</code>, no more processors will be requested to process and
    the <code>null</code> value will be returned.


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

final ChainOfResponsibility &lt;PersonIfc, PersonAgeProcessor&gt; cor =
    new DefaultChainOfResponsibility  &lt;PersonIfc, PersonAgeProcessor&gt; ();
    </pre>

    <br/>
    
    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/gof/cor/impl/defaults/DefaultChainOfResponsibility.java $
    </pre>

    @param <V> The object to be processed.

    @param <P> The processors in the chain.

*/
public class DefaultChainOfResponsibility <V, P extends ProcessorIfc <V>>
    implements ChainOfResponsibilityIfc <V, P>
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
    private final Log _log =
        LogFactory.getLog ( DefaultChainOfResponsibility.class );


    /**
     *
     * The list of processors in the chain.
     *
     */
    private final List <P> _list;


    // ----------------------------------------------------------------------
    //
    // Constructor definitions follow...
    //
    // ----------------------------------------------------------------------


    /**
     *
     * This constructor uses <code>listFactory</code> to build its internal
     * list to hold processors in the chain.
     *
     * @param listFactory The factory that will be used to create the list of
     *        processors in the chain.
     *
     */
    public DefaultChainOfResponsibility ( final ListFactoryIfc <P> listFactory )
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug
            (
                "Using this list factory:  [" + listFactory.getClass ().getName () +
                "]"
            );
        }

        _list = listFactory.create ();

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "List created:  [" + _list.getClass ().getName () + "]" );
        }
    }


    /**
     *
     * Default constructor.  It will use an unsynchronized list factory to create
     * the list.
     *
     */
    public DefaultChainOfResponsibility ()
    {
        this ( new UnsynchronizedLinkedListFactory <P> () );
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
    public V process ( final V toProcess ) throws ProcessException
    {
        V val = toProcess;

        final Iterator<P> itr = _list.iterator ();

        //
        // When a processor has consumed the object, it should return a null
        // value from its process() method.
        //
        while ( val != null && itr.hasNext () )
        {
            final ProcessorIfc<V> processor = itr.next ();

            if ( _log.isDebugEnabled () )
            {
                _log.debug
                (
                    "Requested processor [" + processor + "] to process val [" +
                    val + "]"
                );
            }

            val = processor.process ( val );

            if ( _log.isDebugEnabled () )
            {
                _log.debug
                (
                    "Processor [" + processor + "] returned [" +
                    val + "]"
                );
            }
        }

        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning  [" + val + "]" );
        }

        return val;
    }


    /**
     *
     * {@inheritDoc}
     *
     */
    public List <P> getProcessors ()
    {
        if ( _log.isDebugEnabled () )
        {
            _log.debug ( "Returning [" + _list + "]" );
        }

        return _list;
    }
}
