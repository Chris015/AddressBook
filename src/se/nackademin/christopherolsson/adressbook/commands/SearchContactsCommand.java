package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.registry.Contact;
import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.functions.ContactFormatter;
import se.nackademin.christopherolsson.adressbook.functions.ContactListSorter;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class SearchContactsCommand implements Command{
    private String name = "search";
    private String description = "Searches after contacts";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private List<String> parameters;

    public SearchContactsCommand() {}

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
    public void execute() {
        try {
            if(validate()) {
                List<Contact> contactList = new ArrayList<>();
                contactList.addAll(registry.search(parameters.get(0)));
                contactList.addAll(remoteRegistry.search(parameters.get(0)));
                contactList = ContactListSorter.sort(contactList);
                for (Contact contact : contactList) {
                    consolePrinter.print(ContactFormatter.format(contact));
                }
            }
        } catch (InvalidCommandParameterException e) {
            consolePrinter.print(e.getMessage()); //TODO get localized message?
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if(parameters.size() == 1) {
            return true;
        }
        throw new InvalidCommandParameterException(name + " only accepts one parameter. Got: " + parameters.size());
    }
}
