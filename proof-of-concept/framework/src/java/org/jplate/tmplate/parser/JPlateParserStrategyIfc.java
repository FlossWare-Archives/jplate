package org.jplate.tmplate.parser;

import org.jplate.JPlateException;

/**
 *
 * This interface defines the JPlate parser strategy.  Essentially methods
 * are called on implementations of this interface as items have been parsed.
 *
 */
public interface JPlateParserStrategyIfc
{
    /**
     *
     * This method is called when parsing is to begin.
     *
     * @throws JPlateException if parsing should not proceed.
     *
     */
    public void processParseStart () throws JPlateException;

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
    public void processParseEnd ( int line, int column ) throws JPlateException;

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
            throws JPlateException;

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
            throws JPlateException;

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
            throws JPlateException;

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
            throws JPlateException;

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
     *         encountered.
     *
     */
    public void processDirective
        ( String directiveName, int beginLine, int beginColumn, int endLine,
          int endColumn  )
            throws JPlateException;

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
     *         being encountered.
     *
     */
    public void processAttributeName
        ( String attributeName, int beginLine, int beginColumn, int endLine,
          int endColumn )
            throws JPlateException;

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
     *         being encountered.
     *
     */
    public void processAttributeValue
        ( String value, int beginLine, int beginColumn, int endLine,
          int endColumn )
            throws JPlateException;

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
     *         being encountered.
     *
     */
    public void processPCData
        ( String pcData, int beginLine, int beginColumn, int endLine,
          int endColumn ) throws JPlateException;
}
