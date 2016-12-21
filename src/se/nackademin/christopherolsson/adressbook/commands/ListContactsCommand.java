package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.Contact;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class ListContactsCommand implements Command{

    private String name = "list";
    private String description = "Lists contacts in registry";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ArrayList<String> parameters;

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
    public void execute() {
        if(validate()) {
            List<Contact> contactList = registry.getContacts();
            for (Contact contact : remoteRegistry.getContacts()) {
                contactList.add(contact);
            }
            for (Contact contact : contactList) {
                consolePrinter.print(contact.getId() + "\n" +
                        contact.getFirstName() + "\n" +
                        contact.getLastName() + "\n" +
                        contact.getEmailAdress() + "\n");
            }
        }
    }
    private boolean validate()
    {
        return parameters.size() == 0;
    }
}
