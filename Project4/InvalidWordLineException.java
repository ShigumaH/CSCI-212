@SuppressWarnings("serial")

/**
 * An exception that will occur when the line number is invalid for a WordLine.
 * 
 */
public class InvalidWordLineException extends IllegalArgumentException{
    /**
     * Calls the super class for the Exception.
     * 
     * @param message The message to be displayed if this Exception occurs.
     */
    public InvalidWordLineException(String message) {
        super(message);
    }
}
