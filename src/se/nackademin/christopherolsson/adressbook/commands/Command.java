package se.nackademin.christopherolsson.adressbook.commands;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public interface Command {
    String getName();
    String getDescription();
    void execute();
}
