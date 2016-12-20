package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.commands.AddContactCommand;
import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.commands.DeleteContactCommand;
import se.nackademin.christopherolsson.adressbook.registry.Registry;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class CommandInterpreter {

    private Console console;
    private Registry registry;

    public CommandInterpreter(Console console, Registry registry) {
        this.console = console;
        this.registry = registry;
    }

    public Command interpret(CommandLine commandLine)
    {

        String command = commandLine.getCommand();

        Command returnCommand = null;

        switch (command)
        {
            case "add":
                returnCommand = new AddContactCommand(console,registry,commandLine.getParameters());
                break;
            case "delete":
                returnCommand = new DeleteContactCommand(console,registry,commandLine.getParameters());
                break;
            case "list":
                break;

            default:
                //TODO: Adds throws exception for unknown command.
                break;

        }


        return returnCommand;
    }

}
