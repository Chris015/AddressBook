package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.commands.*;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class CommandInterpreter {

    private Console console;
    private Registry registry;
    private RemoteRegistry remoteRegistry;

    public CommandInterpreter(Console console, Registry registry, RemoteRegistry remoteRegistry) {
        this.console = console;
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }

    public Command interpret(CommandLine commandLine) {

        String command = commandLine.getCommand();

        Command returnCommand;

        switch (command) {
            case "add":
                returnCommand = new AddContactCommand(console, registry, commandLine.getParameters());
                break;
            case "delete":
                returnCommand = new DeleteContactCommand(console, registry, commandLine.getParameters());
                break;
            case "list":
                returnCommand = new ListContactsCommand(console, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "search":
                returnCommand = new SearchContactsCommand(console, registry, remoteRegistry, commandLine.getParameters());
                break;
            default:
                returnCommand = new UnknownCommand();
                break;
        }

        return returnCommand;
    }

}
