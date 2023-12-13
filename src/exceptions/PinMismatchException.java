package exceptions;

public class PinMismatchException extends RuntimeException {
    public PinMismatchException(String message) {
        super(message);
    }
}
