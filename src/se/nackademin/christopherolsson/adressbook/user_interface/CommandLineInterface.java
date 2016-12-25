package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.Application;
import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.exceptions.UnknownCommandException;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registries.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLineInterface implements InputHandler {
    private final static Logger log = Logger.getLogger(CommandLineInterface.class.getName());
    private Console console;
    private CommandInterpreter interpreter;


    public CommandLineInterface(Application application, Console console, RegistryPersister registryPersister, Registry registry,
                                RemoteRegistry remoteRegistry) {
        this.console = console;
        interpreter = new CommandInterpreter(application, registryPersister, this.console, registry, remoteRegistry);
        consoleSetup();

    }

    private void consoleSetup() {
        console.registerInputHandler(this);
        console.print("Welcome!\n");
        console.readInput();
    }

    @Override
    public void handle(CommandLine commandline) {
        try {
            Command command = interpreter.interpret(commandline);
            command.execute();
        } catch (UnknownCommandException | InvalidCommandParameterException e) {
            console.print(e.getMessage());
            log.log(Level.WARNING, "Something wrong occurred", e);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Something wrong occurred", e);
        }
    }
}
