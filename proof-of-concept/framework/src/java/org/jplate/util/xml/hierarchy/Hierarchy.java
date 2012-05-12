package org.jplate.util.xml.hierarchy;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * This class satisfies the HierarchIfc interface.
 *
 */
final class Hierarchy implements HierarchyIfc
{
    /**
     *
     * No name/value defined.
     *
     */
    private static final String EMPTY_STRING = "";

    /**
     *
     * These are empty attributes...
     *
     */
    private static final AttributeIfc NO_ATTRIBUTES[] = new AttributeIfc [ 0 ];

    /**
     *
     * These are empty children...
     *
     */
    private static final HierarchyIfc NO_CHILDREN[] = new HierarchyIfc [ 0 ];

    /**
     *
     * This is the name of the hierarchy.
     *
     */
    private final String _name;

    /**
     *
     * This is the value of the hierarchy.
     *
     */
    private final String _value;

    /**
     *
     * These are the attributes.
     *
     */
    private final AttributeIfc _attributes[];

    /**
     *
     * This is the parent.
     *
     */
    private final HierarchyIfc _parent;

    /**
     *
     * These are the child hierarchies.
     *
     */
    private final HierarchyIfc _children[];

    /**
     *
     * Default constructor is not allowed.
     *
     * @throws UnsupportedOperationException if this constructor is called.
     *
     */
    private Hierarchy ()
    {
        throw new UnsupportedOperationException ();
    }

    /**
     *
     * This constructor will populate self using home/name as a resource.
     *
     * @param document represents the XML document to process.
     *
     */
    Hierarchy ( final Document document )
    {
        this ( null, document );
    }

    /**
     *
     * This constructor will populate self using parent as the parent and
     * node.
     *
     * @param parent represents the parent.
     *
     * @param node represents the data to populate with self.
     *
     */
    private Hierarchy ( final Hierarchy parent, final Node node )
    {
        _name       = node.getNodeName  ();
        _value      = processValue      ( node );
        _attributes = processAttributes ( node );
        _children   = processNode       ( node );
        _parent     = parent;
    }

    /**
     *
     * This method will process the node and look to see if it has a value
     *
     * @param node represents the node for which we are after a value.
     *
     * @return the value.
     *
     */
    private String processValue ( final Node node )
    {
        final short    textNodeType = Node.TEXT_NODE;
        final NodeList nodeList     = node.getChildNodes ();
        final int      nodeSize     = nodeList.getLength ();

        String retVal = null;
        int    index  = 0;

        while ( retVal == null && index < nodeSize )
        {
            final Node child = nodeList.item ( index++ );
            if ( child.getNodeType () == textNodeType )
            {
                retVal = child.getNodeValue ().trim ();
            }
        }

        return ( retVal == null ? "" : retVal );
    }

    /**
     *
     * This method will process the attributes of a node.
     *
     * @param node represents the node for which we are processing attributes.
     *
     * @return the attributes processed.
     *
     */
    private AttributeIfc[] processAttributes ( final Node node )
    {
        final NamedNodeMap attributes = node.getAttributes   ();

        final int size = ( attributes != null ? attributes.getLength () : 0 );

        AttributeIfc retVal[];

        if ( size > 0 )
        {
            final List attributeList = new ArrayList ( size );

            for ( int loop = 0; loop < size; loop++ )
            {
                final Node attribute = attributes.item ( loop );
            
                attributeList.add
                (
                    new Attribute
                    (
                        attribute.getNodeName (), attribute.getNodeValue ()
                    )
                );
            }

            retVal = new AttributeIfc [ size ];
            attributeList.toArray ( retVal );
        }
        else
        {
            retVal = NO_ATTRIBUTES;
        }

        return retVal;
    }
        
    /**
     *
     * This method will process a node.
     *
     * @param node represents the node to process.
     *
     */
    private HierarchyIfc[] processNode ( final Node node )
    {
        final short    elementNodeType = Node.ELEMENT_NODE;
        final NodeList nodeList        = node.getChildNodes ();
        final int      nodeSize        = nodeList.getLength ();

        final List childList = new ArrayList ( nodeSize );

        int totalChildHierarchy = 0;

        for ( int nodeLoop = 0; nodeLoop < nodeSize; nodeLoop++ )
        {
            final Node  childNode = nodeList.item ( nodeLoop );
            final short nodeType  = childNode.getNodeType ();

            if ( nodeType == elementNodeType )
            {
                childList.add ( new Hierarchy ( this, childNode ) );
                totalChildHierarchy++;
            }
        }

        HierarchyIfc retVal[];

        if ( totalChildHierarchy > 0 )
        {
            retVal = new HierarchyIfc [ totalChildHierarchy ];
            childList.toArray ( retVal );
        }
        else
        {
            retVal = NO_CHILDREN;
        }

        return retVal;
    }

    /**
     *
     * This method will return the name of the hierarchy.
     *
     * @return the name of the hierarchy.
     *
     */
    public String getName ()
    {
        return _name;
    }

    /**
     *
     * This method will return the value of the hierarchy.
     *
     * @return the value.
     *
     */
    public String getValue ()
    {
        return _value;
    }

    /**
     *
     * This method will return the attributes.
     *
     * @return the attributes.
     *
     */
    public AttributeIfc[] getAttributes()
    {
        final AttributeIfc attributes[] = _attributes;
        final int          size         = attributes.length;
        final AttributeIfc retVal[]     = new AttributeIfc [ size ];

        System.arraycopy ( attributes, 0, retVal, 0, size );

        return retVal;
    }

    /**
     *
     * This method will return the parent.
     *
     * @return the parent or null if no parent exists.
     *
     */
    public HierarchyIfc getParent ()
    {
        return _parent;
    }

    /**
     *
     * This method will return the children or an array of length 0 if no
     * children exist.
     *
     * @return an array of children or a zero length array if no children
     *         exist.
     *
     */
    public HierarchyIfc[] getChildren ()
    {
        final HierarchyIfc children[] = _children;
        final int          size       = children.length;
        final HierarchyIfc retVal[]   = new Hierarchy [ size ];

        System.arraycopy ( children, 0, retVal, 0, size );

        return retVal;
    }
}
