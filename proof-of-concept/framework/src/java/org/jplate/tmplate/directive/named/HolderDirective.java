package org.jplate.tmplate.directive.named;

import org.jplate.JPlateException;

import org.jplate.tmplate.directive.DirectiveCacheIfc;
import org.jplate.tmplate.directive.DirectiveContainerIfc;
import org.jplate.tmplate.directive.NamedDirectiveIfc;
import org.jplate.tmplate.directive.UnknownNamedDirectiveException;

/**
 *
 * This directive "acts" as a place holder for directives that may not yet
 * be defined.  Self will be replaced by a real directive when self is
 * requested to translate.
 *
 */
public final class HolderDirective implements NamedDirectiveIfc
{
    /**
     *
     * This is the directive name to use for replacement.
     *
     */
    private final String _directiveName;

    /**
     *
     * This is our "real" named directive.
     *
     */
    private NamedDirectiveIfc _namedDirective;

    /**
     *
     * The line where the holder name began.
     *
     */
    private final int _beginLine;

    /**
     *
     * The column where the holder name began.
     *
     */
    private final int _beginColumn;

    /**
     *
     * The line where the holder name ended.
     *
     */
    private final int _endLine;

    /**
     *
     * The column where the holder name ended.
     *
     */
    private final int _endColumn;

    /**
     *
     * The default constructor is not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private HolderDirective ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor sets the name of the "real" directive to be used when
     * self is asked to translate - i.e., we will need to replace self with the
     * directive whose name is name.
     *
     * @param directiveName represents the name of the directive who will
     *        replace self.
     *
     * @param beginLine represents the line where holder name began.
     *
     * @param beginColumn represents the column where holder name began.
     *
     * @param endLine represents the line where holder name ends.
     *
     * @param endColumn represents the column where holder name ends.
     *
     */
    public HolderDirective
        ( final String directiveName, final int beginLine,
          final int beginColumn, final int endLine, final int endColumn )
    {
        _directiveName = directiveName;
        _beginLine     = beginLine;
        _beginColumn   = beginColumn;
        _endLine       = endLine;
        _endColumn     = endColumn;
    }

    /**
     *
     * This constructor sets the name of the "real" directive to be used when
     * self is asked to translate - i.e., we will need to replace self with the
     * directive whose name is name.
     *
     * @param directiveName represents the name of the directive who will
     *        replace self.
     *
     */
    public HolderDirective ( final String directiveName )
    {
        _directiveName = directiveName;
        _beginLine     = 0;
        _beginColumn   = 0;
        _endLine       = 0;
        _endColumn     = 0;
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
        throws JPlateException
    {
        NamedDirectiveIfc namedDirective = _namedDirective;

        if ( namedDirective == null )
        {
            final DirectiveCacheIfc directiveCache =
                container.getDirectiveCache ();

            final String directiveName = _directiveName;

            if ( ! directiveCache.isValidDirectiveName ( directiveName ) )
            {
                throw new
                    UnknownNamedDirectiveException
                    (
                        directiveName, _beginLine, _beginColumn, _endLine,
                        _endColumn
                    );
            }

            namedDirective = directiveCache.getNamedDirective ( directiveName );

            _namedDirective = namedDirective;
        }

        return namedDirective.translate ( container );
    }

    /**
     *
     * This method will create a copy of self.
     *
     * @return a copy of self.
     *
     */
    public NamedDirectiveIfc createCopy ()
    {
        return new HolderDirective ();
    }
}
