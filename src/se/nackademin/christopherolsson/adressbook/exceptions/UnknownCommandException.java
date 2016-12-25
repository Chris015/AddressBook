package se.nackademin.christopherolsson.adressbook.exceptions;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String message) {
        super(message);
    }
}
