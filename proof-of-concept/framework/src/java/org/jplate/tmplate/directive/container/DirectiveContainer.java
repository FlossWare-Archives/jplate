package org.jplate.tmplate.directive.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.DirectiveIfc;

import org.jplate.tmplate.directive.util.Translator;

import org.jplate.util.environment.EnvironmentFactoryIfc;
import org.jplate.util.environment.EnvironmentFactoryMgrIfc;
import org.jplate.util.environment.EnvironmentFactoryMgr;
import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This class satisfies the DirectiveContainerIfc interface and acts as a
 * container for DirectiveIfc's.
 *
 */
final class DirectiveContainer implements DirectiveContainerIfc
{
    /**
     *
     * This is our environment.
     *
     */
    private final EnvironmentIfc _environment;

    /**
     *
     * This is our collection of directive containers.
     *
     */
    private final List _directiveContainerList;

    /**
     *
     * This is our parent.
     *
     */
    private DirectiveContainerIfc _parent;

    /**
     *
     * This is our directive.
     *
     */
    private DirectiveIfc _directive;

    /**
     *
     * This is our directive cache.
     *
     */
    private DirectiveCacheIfc _directiveCache;

    /**
     *
     * Default constructor.
     *
     */
    DirectiveContainer ()
    {
        final EnvironmentFactoryIfc factory =
            EnvironmentFactoryMgr.getSingleton ().getFactory ( getClass () );

        _directiveContainerList = new ArrayList ();
        _environment            = factory.createEnvironment ();
    }

    /**
     *
     * This is a copy constructor.
     *
     * @param directiveContainer represents the directive container to copy.
     *
     */
    private DirectiveContainer ( final DirectiveContainer directiveContainer )
    {
        final List directiveContainerList = new ArrayList ();

        directiveContainerList.addAll
        (
            directiveContainer._directiveContainerList
        );

        final Iterator itr = directiveContainerList.iterator ();
        while ( itr.hasNext () )
        {
            final DirectiveContainerIfc child =
                ( DirectiveContainerIfc ) itr.next ();

            child.setParent ( this );
        }
        
        _environment = directiveContainer.getEnvironment ().createCopy ();

        _directiveContainerList = directiveContainerList;

        _directive = directiveContainer._directive;

        _directiveCache = directiveContainer._directiveCache;
    }

    /**
     *
     * This method will request self to translate its contents.  If no directive
     * exists, it will step over all child directives requesting each one to
     * translate (concatenating all translation to gether) for the return value.
     *
     * @return self translated.
     *
     * @throws JPlateException if any problems arise during translation.
     *
     */
    public String translate () throws JPlateException
    {
        final DirectiveIfc directive = _directive;

        return
            directive != null ? directive.translate ( this ) : 
                Translator.getSingleton ().translateChildren ( this );
    }

    /**
     *
     * This method will request self to translate its contents.  If no directive
     * exists, it will step over all child directives requesting each one to
     * translate (concatenating all translation to gether) for the return value.
     *
     * Please note that tempParent becomes the temporary parent for this
     * translation.  This allows us to temporarily become part of another
     * directive container hierarchy.
     *
     * @param tempParent represents a temporary parent to use when translating.
     *
     * @return self translated.
     *
     * @throws JPlateException if any problems arise during translation.
     *
     */
    public String translate ( final DirectiveContainerIfc tempParent )
        throws JPlateException
    {
        final DirectiveContainerIfc oldParent = _parent;

        _parent = tempParent;

        try
        {
            return translate ();
        }

        finally
        {
            _parent = oldParent;
        }
    }
    
    /**
     *
     * This method will return the container's environment...
     *
     * @return the directive's environment.
     *
     */
    public EnvironmentIfc getEnvironment ()
    {
        return _environment;
    }

    /**
     *
     * This method will set our parent.
     *
     * @param newParent represents the new parent.
     *
     */
    public void setParent ( final DirectiveContainerIfc newParent )
    {
        _parent = newParent;
    }
    
    /**
     *
     * This method will return the directive container's parent - or null if no
     * parent exists.
     *
     * @return the parent or null if no parent exists.
     *
     */
    public DirectiveContainerIfc getParent ()
    {
        return _parent;
    }

    /**
     *
     * This method will return the contained directive.
     *
     * @return the contained directive.
     *
     */
    public DirectiveIfc getDirective ()
    {
        return _directive;
    }

    /**
     *
     * This method will set the contained directive.
     *
     * @param directive represents the new contained directive.
     *
     */
    public void setDirective ( final DirectiveIfc directive )
    {
        _directive = directive;
    }

    /**
     *
     * This method will return the contained directive cache.
     *
     * @return the contained directive cache.
     *
     */
    public DirectiveCacheIfc getDirectiveCache ()
    {
        return _directiveCache;
    }

    /**
     *
     * This method will set the contained directive cache.
     *
     * @param directiveCache represents the new contained directive cache.
     *
     */
    public void setDirectiveCache ( final DirectiveCacheIfc directiveCache )
    {
        _directiveCache = directiveCache;
    }

    /**
     *
     * This method will fix an inserted directive container's parent.
     *
     * Specifically, if the insered directive container already has a parent,
     * the parent will be told to remove that child.
     *
     * @param toFix represents the directive container whose parent we should
     *        attempt to fix.
     *
     */
    private void fixParent ( final DirectiveContainerIfc toFix )
    {
        final DirectiveContainerIfc parent = toFix.getParent ();

        if ( parent != null )
        {
            parent.remove ( toFix );
        }
    }

    /**
     *
     * This method will append a child container.
     *
     * @param toAppend represents the child container to append.
     *
     */
    public void append ( final DirectiveContainerIfc toAppend )
    {
        fixParent ( toAppend );

        _directiveContainerList.add ( toAppend );
        
        toAppend.setParent ( this );
    }

    /**
     *
     * This method will prepend a child container.
     *
     * @param toPrepend represents the child container to prepend.
     *
     */
    public void prepend ( final DirectiveContainerIfc toPrepend )
    {
        fixParent ( toPrepend );

        _directiveContainerList.add ( 0, toPrepend );

        toPrepend.setParent ( this );
    }

    /**
     *
     * This method will insert a child container at index.
     *
     * @param index represents the index where toInsert will be inserted.
     *
     * @param toInsert represents the child container to insert.
     *
     */
    public void insert ( final int index, final DirectiveContainerIfc toInsert )
    {
        fixParent ( toInsert );

        _directiveContainerList.add ( 0, toInsert );

        toInsert.setParent ( this );
    }

    /**
     *
     * This method will replace child directive container with toReplace at
     * index.
     *
     * @param index represents the index where toReplace will replace the
     *        current child directive container.
     *
     * @param toReplace represents the child directive container that will be
     *        used to replace the child container currently at index.
     *
     */
    public void replace
        ( final int index, final DirectiveContainerIfc toReplace )
    {
        final List directiveContainerList = _directiveContainerList;
        
        final DirectiveContainerIfc current = 
            ( DirectiveContainerIfc ) directiveContainerList.get ( index );

        fixParent ( toReplace );

        current.setParent ( null );

        directiveContainerList.set ( index, toReplace );

        toReplace.setParent ( this );
    }

    /**
     *
     * This method will replace oldDirectiveContainer with
     * newDirectiveContainer.
     *
     * @param oldDirectiveContainer represents the child directive container
     *        that will be replaced by newDirectiveContainer.
     *
     * @param newDirectiveContainer represents the replacement for
     *        oldDirectiveContainer.
     *
     */
    public void replace
        ( final DirectiveContainerIfc oldDirectiveContainer,
          final DirectiveContainerIfc newDirectiveContainer )
    {
        final List directiveContainerList = _directiveContainerList;

        final int index =
            directiveContainerList.indexOf ( oldDirectiveContainer );

        if ( index > -1 )
        {
            oldDirectiveContainer.setParent ( null );

            directiveContainerList.set ( index, newDirectiveContainer );

            fixParent ( newDirectiveContainer );

            newDirectiveContainer.setParent ( this );
        }
    }

    /**
     *
     * This method will remove a child container.
     *
     * @param toRemove represents the child container to remove.
     *
     */
    public void remove ( final DirectiveContainerIfc toRemove )
    {
        if ( _directiveContainerList.remove ( toRemove ) )
        {
            toRemove.setParent ( null );
        }
    }

    /**
     *
     * This method will remove a child container at index.
     *
     * @param index represents the index of child container to remove.
     *
     * @return the child container removed at index.
     *
     */
    public void remove ( final int index )
    {
        final List directiveContainerList = _directiveContainerList;

        final DirectiveContainerIfc directiveContainer =
            ( DirectiveContainerIfc ) directiveContainerList.get ( index );

        directiveContainerList.remove ( index );

        directiveContainer.setParent ( null );
    }

    /**
     *
     * This method will remove all childen.
     *
     */
    public void removeAll ()
    {
        final List directiveContainerList = _directiveContainerList;

        final Iterator itr = directiveContainerList.iterator ();

        while ( itr.hasNext () )
        {
            final DirectiveContainerIfc directiveContainer =
                ( DirectiveContainerIfc ) itr.next ();

            directiveContainer.setParent ( null );
        }

        directiveContainerList.clear ();
    }

    /**
     *
     * This method will return a child container at index.
     *
     * @param index represents the index of child container to remove.
     *
     * @return the child container at index index.
     *
     */
    public DirectiveContainerIfc getAt ( int index )
    {
        return ( DirectiveContainerIfc ) _directiveContainerList.get ( index );
    }

    /**
     *
     * This method will return the index of child in the child list.
     *
     * @param child represents the child for whom we desire the position in the
     *        child list.
     *
     * @return the index of child or NO_INDEX if child not found.
     *
     */
    public int getIndex ( final DirectiveContainerIfc child )
    {
        return _directiveContainerList.indexOf ( child );
    }

    /**
     *
     * This method will return the previous child from child or null if there is
     * no previous child from child
     * 
     * @param child represents the child directive for whom we desire the
     *        child before it.
     *
     * @return the child directive who lies before child or null if no previous
     *         child exists.
     *
     */
    public DirectiveContainerIfc getPreviousChild
        ( final DirectiveContainerIfc child )
    {
        final List    dcl      = _directiveContainerList;
        final int     index    = dcl.indexOf ( child );
        final boolean isInList = ( index > -1 && index < dcl.size () - 1 );

        return
            isInList ? ( DirectiveContainerIfc ) dcl.get ( index - 1 ) : null;
    }

    /**
     *
     * This method will return the next child from child or null if there is
     * no next child from child
     * 
     * @param child represents the child directive for whom we desire the
     *        child after it.
     *
     * @return the child directive who lies after child or null if no next
     *         child exists.
     *
     */
    public DirectiveContainerIfc getNextChild
        ( final DirectiveContainerIfc child )
    {
        final List    dcl      = _directiveContainerList;
        final int     index    = dcl.indexOf ( child );
        final boolean isInList = ( index > -1 && index < dcl.size () - 1 );

        return
            isInList ? ( DirectiveContainerIfc ) dcl.get ( index + 1 ) : null;
    }


    /**
     *
     * This method will return all child containers.
     *
     * @return an array of all child containers.
     *
     */
    public DirectiveContainerIfc[] getChildren ()
    {
        final List directiveContainerList = _directiveContainerList;

        final DirectiveContainerIfc retVal[] = 
            new DirectiveContainerIfc [ directiveContainerList.size () ];

        directiveContainerList.toArray ( retVal );

        return retVal;
    }

    /**
     *
     * This method will return the total number of child containers.
     *
     * @return the number of child containers.
     *
     */
    public int getSize ()
    {
        return _directiveContainerList.size ();
    }

    /**
     *
     * This method will request self to be copied.
     *
     * @return a copy of self.
     *
     */
    public DirectiveContainerIfc createCopy ()
    {
        return new DirectiveContainer ( this );
    }
}
