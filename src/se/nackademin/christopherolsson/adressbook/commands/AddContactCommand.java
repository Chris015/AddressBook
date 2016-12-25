package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class AddContactCommand implements Command {
    private final static Logger log = Logger.getLogger(AddContactCommand.class.getName());
    private String name = "add";
    private String description = "Adds a contact to the registries";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private ArrayList<String> parameters;

    public AddContactCommand() {
    }

    public AddContactCommand(ConsolePrinter consolePrinter, Registry registry, ArrayList<String> parameters) {
        this.consolePrinter = consolePrinter;
        this.registry = registry;
        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            log.info("Adding contact...");
            registry.addContact(parameters.get(0), parameters.get(1), parameters.get(2));
            consolePrinter.print(parameters.get(0) + " was added!");
            log.info("Successfully added a contact!");
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 3) {
            return true;
        } else {
            throw new InvalidCommandParameterException(name + " only accepts three parameters. Got: \n" + parameters.size());
        }
    }
}
