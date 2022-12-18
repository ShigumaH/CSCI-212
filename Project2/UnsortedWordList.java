/**
 * An extension of the WordList class, which allows us to append nodes to the end of the linked list.
 *
 */
public class UnsortedWordList extends WordList {
    /**
     * Appends a node to the end of the list
     * @param word A string which contains the word we want to insert into the list.
     */
    public void append(String word) {
        WordNode ln = new WordNode(word);
        last.next = ln; // Add the new node to the end of the list
        last = ln; // The last element of the node IS the new node
        length++;
    }
}
