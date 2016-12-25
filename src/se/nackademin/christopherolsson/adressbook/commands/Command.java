package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;

public interface Command {
    String getName();

    String getDescription();

    void execute() throws InvalidCommandParameterException;
}
