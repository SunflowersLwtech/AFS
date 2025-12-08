package exception;

/**
 * Exception thrown when attempting to create a duplicate entity
 * (e.g., duplicate email, duplicate module code)
 */
public class DuplicateEntityException extends RuntimeException {
    
    public DuplicateEntityException(String message) {
        super(message);
    }
    
    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
