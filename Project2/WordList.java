/**
 * An abstract class that contains the structure for a linked list, that contains Strings as data.
 *
 */
public abstract class WordList {
    protected WordNode first, last, node; // Create WordNode variables for first, last, and node. 
    protected int length;
    
    /**
     * Empty constructor for a WordList, creates a dummy head node and sets the last node to first for an empty list.
     */
    public WordList() {
        first = new WordNode(null); // Dummy head node.
        last = first;
        node = first; // A node used for traversal
    }
    
    /**
     * Gets the length of the LinkedList
     * @return How many elements there are in the list
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Resets the traversal node to the beginning of the List
     */
    public void reset() {
        node = first;
    }
    
    /**
     * Checks to see if current node is linked to another node.
     * @return True if the node points to something else, false otherwise.
     */
    public boolean hasNext() {
        return (node.next != null);
     }

    /**
     * Moves the traversal node to the next node, throws an exception if next is null
     * @return The String inside the node
     */
    public String next() {
        if(node == null)
           throw new NullPointerException("Null node!");
        node = node.next;
        return node.data;
     }
    
    /**
     * This method is taken from Lab 16, it overrides the properties of toString
     * to be able to print out all the data from a whole linked list.
     */
    public String toString() {
        WordNode p = first.next;
        String returnString = "";
        while (p != null) {
            returnString += p.data + " ";
            p = p.next;
        }
        return returnString;
    }
}
