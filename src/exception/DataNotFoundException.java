package exception;

/**
 * Exception thrown when requested data is not found
 * (e.g., user not found, module not found)
 */
public class DataNotFoundException extends RuntimeException {
    
    public DataNotFoundException(String message) {
        super(message);
    }
    
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
