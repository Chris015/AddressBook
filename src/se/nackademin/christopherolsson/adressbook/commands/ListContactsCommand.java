package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.functions.ContactFormatter;
import se.nackademin.christopherolsson.adressbook.functions.ContactListSorter;
import se.nackademin.christopherolsson.adressbook.registries.Contact;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registries.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class ListContactsCommand implements Command {

    private String name = "list";
    private String description = "Lists contacts in registries";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ArrayList<String> parameters;

    public ListContactsCommand() {
    }

    public ListContactsCommand(ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry, ArrayList<String> parameters) {
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
            List<Contact> contactList = new ArrayList<>();
            contactList.addAll(registry.getContacts());
            contactList.addAll(remoteRegistry.getContacts());
            contactList = ContactListSorter.sort(contactList);
            if (contactList.size() != 0) {
                for (Contact contact : contactList) {
                    consolePrinter.print(ContactFormatter.format(contact));
                }
            } else {
                consolePrinter.print("Registry is empty.\n");
            }
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 0) {
            return true;
        } else {
            throw new InvalidCommandParameterException(name + " doesn't require any parameters\n");
        }
    }
}
