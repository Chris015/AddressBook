package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class DeleteContactCommand implements Command {

    private String name = "delete";
    private String description = "Removes a contact from the registry";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private ArrayList<String> parameters;

    public DeleteContactCommand(ConsolePrinter consolePrinter, Registry registry, ArrayList<String> parameters) {
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
    public void execute() {
        if (validate())
        {
            registry.deleteContact(parameters.get(0));
        }
    }

    private boolean validate()
    {
        return parameters.size() == 1;
    }


}
