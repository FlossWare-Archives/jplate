package org.jplate.foundation.node.parser;


import org.jplate.foundation.node.NodeIfc;

import org.jplate.foundation.parser.JPlateParserIfc;


/**
 
    Defines a parser who parses {@link org.jplate.foundation.node.NodeIfc}'s.

    <pre>
Modifications:
    $Date: 2008-12-02 12:32:45 -0500 (Tue, 02 Dec 2008) $
    $Revision: 479 $
    $Author: sfloess $
    $HeadURL: https://jplate.svn.sourceforge.net/svnroot/jplate/trunk/src/dev/java/org/jplate/foundation/node/parser/NodeParserIfc.java $
    </pre>

    @param <B> A node builder who can build nodes on behalf of self.

*/
public interface NodeParserIfc <B extends NodeBuilderIfc <?>>
    extends JPlateParserIfc <B>
{
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
    // Instance class definitions follow...
    //
    // ----------------------------------------------------------------------


    // ----------------------------------------------------------------------
    //
    // Instance method definitions follow...
    //
    // ----------------------------------------------------------------------


}
