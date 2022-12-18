/**
 * An extension of the WordList class, which allows us to add nodes to the linked list in a sorted fashion.
 */
public class SortedWordList extends WordList {
    /**
     * Adds an element to the list in "sorted" order (alphabetical and ignoring case)
     * @param word A string which contains the word we want to insert into the list.
     */
    public void add(String word) {
        WordNode insert = new WordNode(word);
        WordNode p = first;
        
        while(p.next != null && (word.compareToIgnoreCase(p.next.data) >= 0))
            p = p.next; // Keep traversing until we find the correct spot, or reach the end of the list.
            
        insert.next = p.next; // The new node points to the proper next node (or null, if we are at the end)
        p.next = insert; // Current node points to the new node, effectively inserting the new node in between.
        length++;
    }
}
