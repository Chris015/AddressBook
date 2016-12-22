package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.Application;
import se.nackademin.christopherolsson.adressbook.commands.*;
import se.nackademin.christopherolsson.adressbook.exceptions.UnknownCommandException;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class CommandInterpreter {
    private Application application;
    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;

    public CommandInterpreter(Application application, RegistryPersister registryPersister, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        this.application = application;
        this.registryPersister = registryPersister;
        this.consolePrinter = consolePrinter;
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
    }

    public Command interpret(CommandLine commandLine) throws UnknownCommandException {

        String command = commandLine.getCommand();

        Command returnCommand;

        switch (command) {
            case "add":
                returnCommand = new AddContactCommand(consolePrinter, registry, commandLine.getParameters());
                break;
            case "delete":
                returnCommand = new DeleteContactCommand(consolePrinter, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "list":
                returnCommand = new ListContactsCommand(consolePrinter, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "search":
                returnCommand = new SearchContactsCommand(consolePrinter, registry, remoteRegistry, commandLine.getParameters());
                break;
            case "quit":
                returnCommand = new QuitCommand(application, registryPersister, consolePrinter, commandLine.getParameters());
                break;
            case "help":
                returnCommand = new HelpCommand(consolePrinter, commandLine.getParameters());
                break;
            default:
                throw new UnknownCommandException(command + " is not a valid command");
        }

        return returnCommand;
    }

}
