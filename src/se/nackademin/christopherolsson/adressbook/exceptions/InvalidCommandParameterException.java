package se.nackademin.christopherolsson.adressbook.exceptions;

/**
 * Created by Fredrik Grimmenhag on 2016-12-21.
 */
public class InvalidCommandParameterException extends Exception {
    public InvalidCommandParameterException(String message) {
        super(message);
    }
}