import java.util.ArrayList;

/**
 * An object that contains a word and the line numbers they are found in.
 * 
 */
public class WordLine implements Comparable<WordLine> {
    String word;
    ArrayList<Integer> lineNumbers = new ArrayList<>();
    
    /**
     * Default constructor for a WordLine. It only takes in a word, but not the line number.
     * Useful for adding a new entry to a Map.
     * 
     * @param w The word to be added.
     */
    public WordLine(String w) {
        word = w;
    }
    
    /**
     * Default constructor for a WordLine, that takes in the word and the line number it was found in. 
     * 
     * @param w The word to be added.
     * @param ln The line number the word was found in.
     */
    public WordLine(String w, int ln) {
        if(ln < 1)
            throw new InvalidWordLineException("Line number cannot be less than 1!");
        word = w;
        lineNumbers.add(ln);
    }
    
    /**
     * If a word already exists, we can add additional line numbers they were found in.
     * 
     * @param ln The line number the word was found in.
     */
    public void addNewLineNumber(int ln) {
        if(ln < 1)
            throw new InvalidWordLineException("Line number cannot be less than 1!");
        lineNumbers.add(ln);
    }
    
    /**
     * Define compareTo for the Comparable interface to allow sorting
     */
    @Override
    public int compareTo(WordLine other) {
        return this.word.compareTo(other.word); // We can use the compareTo in the String class which means most of the work is done for us already.
    }
}
