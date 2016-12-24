package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public interface Command {
    String getName();

    String getDescription();

    void execute() throws InvalidCommandParameterException;
}
