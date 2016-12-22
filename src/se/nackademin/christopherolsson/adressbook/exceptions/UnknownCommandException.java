package se.nackademin.christopherolsson.adressbook.exceptions;

/**
 * @author Christopher Olsson on 2016-12-22.
 */
public class UnknownCommandException extends Exception {
    public UnknownCommandException(String message) {
        super(message);
    }
}
