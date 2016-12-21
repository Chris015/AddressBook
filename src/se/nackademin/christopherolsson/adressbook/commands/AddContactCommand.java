package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class AddContactCommand implements Command {

    private String name = "add";
    private String description = "Adds a contact to the registry";

    private ConsolePrinter consolePrinter;
    private Registry registry;
    private ArrayList<String> parameters;

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
    public void execute(){
        try {
            if (validate())
            {
                registry.addContact(parameters.get(0),parameters.get(1),parameters.get(2));
            }
        } catch (InvalidCommandParameterException e) {
            e.printStackTrace();
        }

    }

    private boolean validate() throws InvalidCommandParameterException
    {
        if (parameters.size() == 3) {
            return true;
        }
        else
        {
            throw new InvalidCommandParameterException("Invalid amounts of parameters for command: "+parameters.size());
        }
    }




}
