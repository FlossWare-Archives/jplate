package org.jplate.tmplate.directive.parserstrategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;
import org.jplate.tmplate.directive.PCDataDirectiveIfc;
import org.jplate.tmplate.directive.UnknownNamedDirectiveException;

import org.jplate.tmplate.directive.cache.DirectiveCacheFactoryIfc;
import org.jplate.tmplate.directive.cache.DirectiveCacheFactoryMgr;

import org.jplate.tmplate.directive.container.DirectiveContainerFactoryIfc;
import org.jplate.tmplate.directive.container.DirectiveContainerFactoryMgr;

import org.jplate.tmplate.directive.named.HolderDirective;

import org.jplate.util.environment.EnvironmentIfc;

/**
 *
 * This class will process JPlate tokens as they are parsed.
 *
 */
final class DirectiveParserStrategy implements DirectiveParserStrategyIfc
{
    /**
     *
     * Message used when the directive cache is null...
     *
     */
    private static final String DIRECTIVE_CACHE_IS_NULL_MSG =
        "directiveCache == null";

    /**
     *
     * This is our stack - used in parsing...
     *
     */
    private final LinkedList _stack;

    /**
     *
     * This is the directive cache to use when parsing to create directives
     * and/or parsed character data.
     *
     */
    private final DirectiveCacheIfc _directiveCache;

    /**
     *
     * The "root" directive container this will contain everything parsed.
     *
     */
    private final DirectiveContainerIfc _rootDirectiveContainer;

    /**
     *
     * The current directive container.
     *
     */
    private DirectiveContainerIfc _currentDirectiveContainer;

    /**
     *
     * The current directive name.
     *
     */
    private String _currentDirectiveName;

    /**
     *
     * The current attribute name.
     *
     */
    private String _currentAttributeName;

    /**
     *
     * This is a flag denoting directive content (meaning a tree)...
     *
     */
    private boolean _isDirectiveContent;

    /**
     *
     * Default constructor.  
     *
     */
    DirectiveParserStrategy ()
    {
        final DirectiveContainerFactoryIfc containerFactory =
            DirectiveContainerFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        final DirectiveContainerIfc rootDirectiveContainer =
            containerFactory.createDirectiveContainer ();

        final DirectiveCacheFactoryIfc cacheFactory =
            DirectiveCacheFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        rootDirectiveContainer.setDirectiveCache
        (
            cacheFactory.createDirectiveCache ()
        );

        _rootDirectiveContainer = rootDirectiveContainer;
        _directiveCache         = cacheFactory.createDirectiveCache ();
        _stack                  = new LinkedList ();
    }

    /**
     *
     * This constructor sets the directive cache to be used while parsing.
     *
     * @param directiveCache represents the directive cache to be used
     *        while parsing.
     *
     */
    DirectiveParserStrategy ( final DirectiveCacheIfc directiveCache )
    {
        if ( directiveCache == null )
        {
            throw new NullPointerException ( DIRECTIVE_CACHE_IS_NULL_MSG );
        }

        final DirectiveContainerFactoryIfc containerFactory =
            DirectiveContainerFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        final DirectiveContainerIfc rootDirectiveContainer =
            containerFactory.createDirectiveContainer ();

        rootDirectiveContainer.setDirectiveCache ( directiveCache );

        _rootDirectiveContainer = rootDirectiveContainer;
        _directiveCache         = directiveCache;
        _stack                  = new LinkedList ();
    }

    /**
     *
     * This method will push the current directive container on to the stack.
     *
     */
    private void push ()
    {
        _stack.add
        (
            new Object[] { _currentDirectiveContainer, _currentDirectiveName }
        );
    }

    /**
     *
     * This method will pop the current directive container from the stack.
     *
     * @param beginLine represents the line where the pop was issued.
     *
     * @param beginColumn represents the column number where the pop was issued.
     *
     * @param endLine represents the pop was issued.
     *
     * @param endColumn represents the column number where the pop was issued.
     *
     * @throws UnbalancedDirectiveTreeException if a pop is attempted when
     *         there is no item to be popped.
     *
     */
    private void pop
        ( final int beginLine, final int beginColumn, final int endLine,
          final int endColumn )
            throws UnbalancedDirectiveTreeException
    {
        final LinkedList stack = _stack;
        final int        size  = stack.size ();

        if ( size < 1 )
        {
            throw new UnbalancedDirectiveTreeException
            (
                "size = " + size, beginLine, beginColumn, endLine, endColumn
            );
        }

        final Object current[] = ( Object[] ) stack.removeLast ();

        _currentDirectiveContainer = ( DirectiveContainerIfc ) current [ 0 ];
        _currentDirectiveName      = ( String             ) current [ 1 ];
    }

    /**
     *
     * This method is called when parsing is to begin.
     *
     * @throws JPlateException if parsing should not proceed.
     *
     */
    public void processParseStart () throws JPlateException
    {
        final DirectiveContainerIfc rootDirectiveContainer =
            _rootDirectiveContainer;

        rootDirectiveContainer.removeAll ();

        _currentDirectiveContainer = rootDirectiveContainer;
        _isDirectiveContent        = false;
    }

    /**
     *
     * This method is called when parsing has completed.
     *
     * @param line represents the line where the parse ended.
     *
     * @param column represents the column number where the parse ended.
     *
     * @throws JPlateException if there is a problem with parsing being
     *         completed.
     *
     */
    public void processParseEnd ( int line, int column ) throws JPlateException
    {
        final LinkedList stack = _stack;
        final int        size  = stack.size ();

        if ( size > 0 )
        {
            final StringBuffer sb = new StringBuffer ();

            sb.append ( "<EOF> size = " );
            sb.append ( size );
            sb.append ( "   [" );
            sb.append ( _currentDirectiveName );

            final Iterator stackItr = stack.iterator ();

            boolean isMore = stackItr.hasNext ();

            while ( isMore )
            {
                final Object content[] = ( Object[] ) stackItr.next ();
                final Object name      = content [ 1 ];

                isMore = stackItr.hasNext ();

                if ( isMore )
                {
                    sb.append ( ' ' );
                }

                if ( name != null )
                {
                    sb.append ( name );
                }
            }

            sb.append ( "]" );

            throw new UnbalancedDirectiveTreeException ( sb.toString () );
        }
    }

    /**
     *
     * This method is called when the start of a directive has been encountered.
     *
     * @param directiveStartToken represents the string that denoted the start
     *        of a directive.
     *
     * @param beginLine represents the line where the directive start begins.
     *
     * @param beginColumn represents the column number where the directive
     *        start begins.
     *
     * @param endLine represents the line where the directive start ends.
     *
     * @param endColumn represents the column number where the directive start
     *        ends.
     *
     * @throws JPlateException if there is a problem with a directive content
     *         start being encountered.
     *
     */
    public void processDirectiveStart
        ( String directiveStartToken, int beginLine, int beginColumn,
          int endLine, int endColumn )
            throws JPlateException
    {
        final DirectiveContainerFactoryIfc containerFactory =
            DirectiveContainerFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        final DirectiveContainerIfc directiveContainer =
            containerFactory.createDirectiveContainer ();
            
        directiveContainer.setDirectiveCache ( _directiveCache );

        _currentDirectiveContainer.append ( directiveContainer );

        push ();

        _currentDirectiveContainer = directiveContainer;
        _currentDirectiveName      = "";
    }

    /**
     *
     * This method is called when the end of a directive has been encountered.
     *
     * @param directiveEndToken represents the string that denoted the end
     *        of a directive.
     *
     * @param beginLine represents the line where the directive end begins.
     *
     * @param beginColumn represents the column number where the directive
     *        end begins.
     *
     * @param endLine represents the line where the directive end ends.
     *
     * @param endColumn represents the column number where the directive end
     *        ends.
     *
     * @throws JPlateException if there is a problem with a directive content
     *         end being encountered.
     *
     */
    public void processDirectiveEnd
        ( String directiveEndToken, int beginLine, int beginColumn,
          int endLine, int endColumn )
            throws JPlateException
    {
        pop ( beginLine, beginColumn, endLine, endColumn );

        _isDirectiveContent = false;
    }

    /**
     *
     * This method is called when the start of a directive content has been
     * encountered.
     *
     * @param contentStartToken represents the string that denoted the start of
     *        directive content.
     *
     * @param beginLine represents the line where the directive content start
     *        begins.
     *
     * @param beginColumn represents the column number where the directive
     *        content start begins.
     *
     * @param endLine represents the line where the directive content start
     *        ends.
     *
     * @param endColumn represents the column number where the directive content
     *        start ends.
     *
     * @throws JPlateException if there is a problem with a directive content
     *         start being encountered.
     *
     */
    public void processDirectiveStartContent
        ( String contentStartToken, int beginLine, int beginColumn, int endLine,
          int endColumn )
            throws JPlateException
    {
    }

    /**
     *
     * This method is called when the end of a directive content has been
     * encountered.
     *
     * @param contentEndToken represents the string that denoted the end of
     *        directive content.
     *
     * @param beginLine represents the line where the directive content end
     *        begins.
     *
     * @param beginColumn represents the column number where the directive
     *        content end begins.
     *
     * @param endLine represents the line where the directive content end
     *        ends.
     *
     * @param endColumn represents the column number where the directive content
     *        end ends.
     *
     * @throws JPlateException if there is a problem with a directive content
     *         end being encountered.
     *
     */
    public void processDirectiveEndContent
        ( String contentEndToken, int beginLine, int beginColumn, int endLine,
          int endColumn )
            throws JPlateException
    {
        _isDirectiveContent = true;
    }

    /**
     *
     * This method is called when a directive has been encountered.
     *
     * @param directiveName represents the name of the directive encountered.
     *
     * @param beginLine represents the line where the directive begins.
     *
     * @param beginColumn represents the column number where the directive
     *        begins.
     *
     * @param endLine represents the line where the directive ends.
     *
     * @param endColumn represents the column number where the directive ends.
     *
     * @throws JPlateException if there is a problem with a directive being
     *         encounterd.
     *
     */
    public void processDirective 
        ( String directiveName, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn  )
            throws JPlateException
    {
        if ( ! _isDirectiveContent )
        {
            final DirectiveCacheIfc directiveCache = _directiveCache;

            NamedDirectiveIfc directive;

            //
            // We may need to use a holder directive for later defined
            // directives...
            //
            if ( directiveCache.isValidDirectiveName ( directiveName ) )
            {
                directive = directiveCache.getNamedDirective ( directiveName );
            }
            else
            {
                directive = new HolderDirective ( directiveName );
            }

            _currentDirectiveContainer.setDirective ( directive );

            _currentDirectiveName = directiveName;
        }
        else
        {
            if ( ! directiveName.equals ( _currentDirectiveName ) )
            {
                throw new UnbalancedDirectiveTreeException
                (
                    directiveName + " != " + _currentDirectiveName, beginLine,
                    beginColumn, endLine, endColumn
                );
            }
        }
    }

    /**
     *
     * This method is called when an attribute name has been encountered.
     *
     * @param attributeName represents the name of the attribute encountered.
     *
     * @param beginLine represents the line where the attribute value begins.
     *
     * @param beginColumn represents the column number where the attribute value
     *        begins.
     *
     * @param endLine represents the line where the attribute value ends.
     *
     * @param endColumn represents the column number where the attribute value
     *        ends.
     *
     * @throws JPlateException if there is a problem with an attribute name
     *         being encounterd.
     *
     */
    public void processAttributeName
        ( final String attributeName, final int beginLine,
          final int beginColumn, final int endLine, final int endColumn )
            throws JPlateException
    {
        final EnvironmentIfc env = _currentDirectiveContainer.getEnvironment ();
        
        env.setValue ( attributeName, "" );

        _currentAttributeName = attributeName;
    }

    /**
     *
     * This method is called when an attribute value has been encountered.
     *
     * @param attributeValue represents the value of the attribute encountered.
     *
     * @param beginLine represents the line where the attribute value begins.
     *
     * @param beginColumn represents the column number where the attribute value
     *        begins.
     *
     * @param endLine represents the line where the attribute value ends.
     *
     * @param endColumn represents the column number where the attribute value
     *        ends.
     *
     * @throws JPlateException if there is a problem with an attribute value
     *         being encounterd.
     *
     */
    public void processAttributeValue
        ( final String value, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
            throws JPlateException
    {
        final EnvironmentIfc env = _currentDirectiveContainer.getEnvironment ();
        
        env.setValue ( _currentAttributeName, value );
    }

    /**
     *
     * This method is called when a parsed character data has been encountered.
     *
     * @param pcData represents the parsed character data encountered.
     *
     * @param beginLine represents the line where the parsed character data
     *        begins.
     *
     * @param beginColumn represents the column number where the parsed
     *        chartacter data begins.
     *
     * @param endLine represents the line where the parsed character data ends.
     *
     * @param endColumn represents the column number where the parsed
     *        chartacter data ends.
     *
     * @throws JPlateException if there is a problem with parsed character data
     *         being encounterd.
     *
     */
    public void processPCData
        ( final String pcData, final int beginLine, final int beginColumn,
          final int endLine, final int endColumn )
            throws JPlateException
    {
        final DirectiveCacheIfc directiveCache = _directiveCache;

        final DirectiveContainerFactoryIfc containerFactory =
            DirectiveContainerFactoryMgr.getSingleton ().getFactory
            (
                getClass ()
            );

        final DirectiveContainerIfc directiveContainer =
            containerFactory.createDirectiveContainer ();

        directiveContainer.setDirective
        (
            directiveCache.createPCDataDirective ( pcData )
        );

        directiveContainer.setDirectiveCache ( directiveCache );

        _currentDirectiveContainer.append ( directiveContainer );
    }

    /**
     *
     * This method returns the directive cache it is using while parsing.
     *
     * @return the directive cache being used while parsing.
     *
     */
    public DirectiveCacheIfc getDirectiveCache ()
    {
        return _directiveCache;
    }

    /**
     *
     * This method will return the directive container that was built when
     * parsing.
     * 
     * @return the directive container that was built when parsing.
     *
     */
    public DirectiveContainerIfc getDirectiveContainer ()
    {
        return _rootDirectiveContainer;
    }
}
