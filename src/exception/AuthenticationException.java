package exception;

/**
 * Exception thrown when authentication fails
 * (e.g., invalid credentials, user not found)
 */
public class AuthenticationException extends RuntimeException {
    
    public AuthenticationException(String message) {
        super(message);
    }
    
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
