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
import java.util.logging.Logger;

public class SearchContactsCommand implements Command {
    private final static Logger log = Logger.getLogger(SearchContactsCommand.class.getName());
    private String name = "search";
    private String description = "Searches after contacts";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private List<String> parameters;

    public SearchContactsCommand() {
    }

    public SearchContactsCommand(ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry, ArrayList<String> parameters) {
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
            log.info("Searching for contacts...");
            List<Contact> contactList = new ArrayList<>();
            contactList.addAll(registry.search(parameters.get(0)));
            contactList.addAll(remoteRegistry.search(parameters.get(0)));
            contactList = ContactListSorter.sort(contactList);
            if (contactList.size() != 0) {
                for (Contact contact : contactList) {
                    consolePrinter.print(ContactFormatter.format(contact));
                }
                log.info("Successfully searched for contacts.");
            } else {
                consolePrinter.print("Couldn't find a contact that is matching you search string.\n");
                log.info("Failed searching for contacts. " +
                        "Couldn't find a contact that is matching you search string.");
            }
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 1) {
            return true;
        }
        throw new InvalidCommandParameterException(name + " only accepts one parameter. Got: \n" + parameters.size());
    }
}
