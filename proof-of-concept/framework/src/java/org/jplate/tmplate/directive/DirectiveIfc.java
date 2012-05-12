package org.jplate.tmplate.directive;

import org.jplate.JPlateException;

/**
 *
 * This interface defines the API for directives.
 *
 */
public interface DirectiveIfc
{
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
    public String translate ( DirectiveContainerIfc container )
        throws JPlateException;
}
