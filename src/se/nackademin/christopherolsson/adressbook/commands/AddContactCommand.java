package se.nackademin.christopherolsson.adressbook.commands;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class AddContactCommand implements Command {
    String name = "add";
    String description = "Adds a contact to the registry";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {

    }
}
