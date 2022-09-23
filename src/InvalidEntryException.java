public class InvalidEntryException extends Exception {
    enum ExceptionType {
        INVALID,VALID
    }

    public InvalidEntryException(String message) {
        super(message);
    }
}
