package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.registry.Contact;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class DeleteContactCommand implements Command {

    private String name = "delete";
    private String description = "Removes a contact from the registry";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ArrayList<String> parameters;

    public DeleteContactCommand() {
    }

    public DeleteContactCommand(ConsolePrinter consolePrinter, Registry registry,RemoteRegistry remoteRegistry, ArrayList<String> parameters) {
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
            if(registry.getContacts().size() != 0) {
                for (Contact contact : registry.getContacts()) {
                    if (contact.getId().equals(parameters.get(0))) {
                        consolePrinter.print(contact.getFirstName() + " was removed.");
                    } else {
                        consolePrinter.print("No contact with id " + parameters.get(0) + " found.");
                        return;
                    }
                }
            } else {
                consolePrinter.print("Registry is empty.");
                return;
            }

            registry.deleteContact(parameters.get(0));

            for (Contact contact : remoteRegistry.getContacts()) {
                if(contact.getId().equals(parameters.get(0))) {
                    consolePrinter.print("Can't delete a contact from a remote registry.");
                }
            }

        }
    }


    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 1) {
            return true;
        } else {
            throw new InvalidCommandParameterException(name + " only accepts one parameter. Got: " + parameters.size());
        }
    }
}
