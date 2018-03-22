package exceptions;

public class IdOrNameAlreadyTakenException extends Exception {

    public IdOrNameAlreadyTakenException(String message)
    {
        super(message);
    }
}
