package org.jplate.tmplate.directive;

import java.util.List;

import org.jplate.JPlateException;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This interface defines the API for containers of DirectiveIfc's.
 *
 */
public interface DirectiveContainerIfc
{
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
    public String translate () throws JPlateException;

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
    public String translate ( DirectiveContainerIfc tempParent )
        throws JPlateException;
    
    /**
     *
     * This method will return the container's environment...
     *
     * @return the directive's environment.
     *
     */
    public EnvironmentIfc getEnvironment ();

    /**
     *
     * This method will set our parent.
     *
     * @param newParent represents the new parent.
     *
     */
    public void setParent ( DirectiveContainerIfc newParent );

    /**
     *
     * This method will return the directive container's parent - or null if no
     * parent exists.
     *
     * @return the parent or null if no parent exists.
     *
     */
    public DirectiveContainerIfc getParent ();

    /**
     *
     * This method will return the contained directive.
     *
     * @return the contained directive.
     *
     */
    public DirectiveIfc getDirective ();

    /**
     *
     * This method will set the contained directive.
     *
     * @param directive represents the new contained directive.
     *
     */
    public void setDirective ( DirectiveIfc directive );

    /**
     *
     * This method will return the contained directive cache.
     *
     * @return the contained directive cache.
     *
     */
    public DirectiveCacheIfc getDirectiveCache ();

    /**
     *
     * This method will set the contained directive factory.
     *
     * @param directiveCache represents the new contained directive cache.
     *
     */
    public void setDirectiveCache ( DirectiveCacheIfc directiveCache );

    /**
     *
     * This method will append a child container.
     *
     * @param toAppend represents the child container to append.
     *
     */
    public void append ( DirectiveContainerIfc toAppend );

    /**
     *
     * This method will prepend a child container.
     *
     * @param toPrepend represents the child container to prepend.
     *
     */
    public void prepend ( DirectiveContainerIfc toPrepend );

    /**
     *
     * This method will insert a child container at index.
     *
     * @param index represents the index where toInsert will be inserted.
     *
     * @param toInsert represents the child container to insert.
     *
     */
    public void insert ( int index, DirectiveContainerIfc toInsert );

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
    public void replace ( int index, DirectiveContainerIfc toReplace );

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
        ( DirectiveContainerIfc oldDirectiveContainer,
          DirectiveContainerIfc newDirectiveContainer );

    /**
     *
     * This method will remove a child container.
     *
     * @param toRemove represents the child container to remove.
     *
     */
    public void remove ( DirectiveContainerIfc toRemove );
    
    /**
     *
     * This method will remove a child container at index.
     *
     * @param index represents the index of child container to remove.
     *
     * @return the child container removed at index.
     *
     */
    public void remove ( int index );

    /**
     *
     * This method will remove all childen.
     *
     */
    public void removeAll ();

    /**
     *
     * This method will return a child container at index.
     *
     * @param index represents the index of child container to remove.
     *
     * @return the child container at index index.
     *
     */
    public DirectiveContainerIfc getAt ( int index );

    /**
     *
     * This method will return the index of child in the child list.
     *
     * @param child represents the child for whom we desire the position in the
     *        child list.
     *
     * @return the index of child or -1 if child not found.
     *
     */
    public int getIndex ( DirectiveContainerIfc child );

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
        ( DirectiveContainerIfc child );

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
    public DirectiveContainerIfc getNextChild ( DirectiveContainerIfc child );

    /**
     *
     * This method will return all child containers.
     *
     * @return an array of all child containers.
     *
     */
    public DirectiveContainerIfc[] getChildren ();

    /**
     *
     * This method will return the total number of child containers.
     *
     * @return the number of child containers.
     *
     */
    public int getSize ();

    /**
     *
     * This method will request self to be copied.
     *
     * @return a copy of self.
     *
     */
    public DirectiveContainerIfc createCopy ();
}
