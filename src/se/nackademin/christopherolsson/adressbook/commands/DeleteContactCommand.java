package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registries.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class DeleteContactCommand implements Command {
    private final static Logger log = Logger.getLogger(DeleteContactCommand.class.getName());
    private String name = "delete";
    private String description = "Removes a contact from the registries";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ArrayList<String> parameters;

    public DeleteContactCommand() {
    }

    public DeleteContactCommand(ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry, ArrayList<String> parameters) {
        this.consolePrinter = consolePrinter;
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
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
            log.info("Deleting contact...");
            String id = parameters.get(0);

            if (registry.contactIdExists(id)) {
                registry.deleteContact(id);
                consolePrinter.print("Contact was removed.");
                log.info("Successfully deleted a contact!");
            } else if (remoteRegistry.contactIdExists(id)) {
                consolePrinter.print("Can't delete a contact from a remote registries.");
                log.info("Failed deleting a contact. User tried to delete from a remote registry.");
            } else {
                consolePrinter.print("No contact with id " + id + " found.");
                log.info("Failed deleting a contact. No contact with id " + id + " found.");
            }
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 1) {
            return true;
        } else {
            throw new InvalidCommandParameterException(name + " only accepts one parameter. Got: \n" + parameters.size());
        }
    }
}
