/**
 * An object that contains a word and the line number it is found in.
 * 
 */
public class WordLine implements Comparable<WordLine> {
    String word;
    int lineNumber;
    
    /**
     * Constructor for a WordLine.
     * 
     * @param w A string containing the word
     * @param ln An integer containing the line number
     */
    public WordLine(String w, int ln) {
        if(ln < 1) {
            throw new InvalidWordLineException("Line number is less than 1!");
        }
        word = w;
        lineNumber = ln;
    }
    
    /**
     * Define compareTo for the Comparable interface to allow sorting for ArrayList
     */
    @Override
    public int compareTo(WordLine other) {
        return this.word.compareTo(other.word); // We can use the compareTo in the String class which means most of the work is done for us already.
    }
    
    /**
     * An override to allow the printing of the object's contents.
     */
    @Override
    public String toString() {
        return "\nLine " + this.lineNumber + ": \"" + this.word + "\"";
    }
}
