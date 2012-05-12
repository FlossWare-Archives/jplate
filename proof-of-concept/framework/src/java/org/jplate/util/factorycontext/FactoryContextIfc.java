package org.jplate.util.factorycontext;

import org.jplate.factory.FactoryIfc;
import org.jplate.factory.FactoryMgrIfc;

/**
 *
 * This interface defines the API by which to retrieve a factory for a given
 * FactoryMgrIfc by context.
 *
 */
public interface FactoryContextIfc
{
    /**
     *
     * This method will return a FactoryIfc based upon context.  If no
     * context has been defined, the default factory will be returned if it has
     * been defined.
     *
     * @param factoryMgr represents the factory manager for whom a factory is
     *        desired based upon context.
     *
     * @param classContext represents the class context for which a FactoryIfc
     *        is desired.  This allows one to return arbitrary implementations
     *        of a factory based upon a class.
     *
     * @return an implementation of FactoryIfc for context, or the default
     *         factory if it has been defined.  If no default factory is defined
     *         null will be returned.
     *
     */
    public FactoryIfc getFactoryForContext
        ( FactoryMgrIfc factoryMgr, Class classContext );

    /**
     *
     * This method will return the default FactoryIfc for factoryMgr or null
     * if one does not exist.
     *
     * @param factoryMgr represents the factory manager for whom a factory is
     *        desired based upon context.
     *
     * @return an implementation of FactoryIfc for that is the default factory
     *         for factoryMgr.
     *
     */
    public FactoryIfc getDefaultFactory ( FactoryMgrIfc factoryMgr );
}
