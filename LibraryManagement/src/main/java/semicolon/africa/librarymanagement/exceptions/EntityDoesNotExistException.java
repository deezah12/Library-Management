package semicolon.africa.librarymanagement.exceptions;

public class EntityDoesNotExistException extends RuntimeException{
    public EntityDoesNotExistException(String message) {
        super(message);
    }
}
