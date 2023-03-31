/**
 * BadFileException.java - This class is an exception class that is thrown when the file is bad.
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class BadFileException extends RuntimeException {
    /**
     * Error
     * @param message error message
     */
    public BadFileException(String message) {
        super(message);
    }

}
