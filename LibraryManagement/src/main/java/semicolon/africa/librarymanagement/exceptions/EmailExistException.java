package semicolon.africa.librarymanagement.exceptions;

public class EmailExistException extends RuntimeException{
    public EmailExistException(String message) {
        super(message);
    }
}
