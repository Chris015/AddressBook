package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.Contact;
import se.nackademin.christopherolsson.adressbook.Functions.ContactFormatter;
import se.nackademin.christopherolsson.adressbook.Functions.ContactListSorter;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class UnknownCommand implements Command{

    private String name = "";
    private String description = "Unknown command";


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
        //TODO: Log shit here
        System.out.println("Unknown.");
    }
}
