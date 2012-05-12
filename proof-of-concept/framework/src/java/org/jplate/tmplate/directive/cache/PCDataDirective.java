package org.jplate.tmplate.directive.cache;

import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.PCDataDirectiveIfc;

/**
 *
 * This class satisfies the PCDataDirectiveIfc interface.
 *
 */
final class PCDataDirective implements PCDataDirectiveIfc
{
    /**
     *
     * This is the parsed character data.
     *
     */
    private String _pcData;

    /**
     *
     * Default constructor.
     *
     */
    PCDataDirective ()
    {
        _pcData = "";
    }

    /**
     *
     * This constructor sets-up the parsed characer data.
     *
     */
    PCDataDirective ( final String pcData )
    {
        _pcData = ( pcData != null ? pcData : "" );
    }

    /**
     *
     * This method requests that the data container in container be translated.
     *
     * @param container represents the directive container where translation
     *        will be done.
     *
     * @return the contents of container translated.
     *
     * @throws JPlateException if any problems arise performing translation for
     *         container.
     *
     */
    public String translate ( final DirectiveContainerIfc container )
    {
        return _pcData;
    }

    /**
     *
     * This method will return the parsed character data.
     *
     * @return the parsed character data.
     *
     */
    public String getPCData ()
    {
        return _pcData;
    }
    
    /**
     *
     * This method will set the parsed character data.
     *
     * @param pcData represents the parsed character data.
     *
     */
    public void setPCData ( final String pcData )
    {
        _pcData = pcData;
    }
}
