package exception;

/**
 * Exception thrown when input validation fails
 * (e.g., invalid email format, empty required fields)
 */
public class ValidationException extends RuntimeException {
    
    public ValidationException(String message) {
        super(message);
    }
    
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
