package exceptions;

public class PinAttemptException extends RuntimeException {
    public PinAttemptException(String message) {
        super(message);
    }
}
