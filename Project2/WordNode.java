/**
 * The structure for a node, the component that makes linked lists.
 *
 */
public class WordNode {
    String data;
    WordNode next;
    
    /**
     * Constructor for a word node.
     * @param d A string containing the data that we would like to insert into the node.
     */
    public WordNode(String d) {
       data = d;
       next = null;
    }
 }
