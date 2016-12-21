package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.Application;
import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {
    private Console console = new Console();
    private CommandInterpreter interpreter;


    public CommandLineInterface(Application application, RegistryPersister registryPersister, Registry registry,
                                RemoteRegistry remoteRegistry) {
        ConsolePrinter consolePrinter = new Console();
        interpreter = new CommandInterpreter(application, registryPersister, consolePrinter, registry, remoteRegistry);
        consoleSetup();

    }

    private void consoleSetup() {
        console.registerInputHandler(this);
        console.readInput();
    }

    @Override
    public void handle(CommandLine commandline) {
        Command command = interpreter.interpret(commandline);
        command.execute();
    }
}
