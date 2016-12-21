package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.Application;
import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.AutoSave;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {
    private Application application;
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Registry registry = new Registry();
    private Console console = new Console();
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private CommandInterpreter interpreter;


    public CommandLineInterface(Application application) {
        this.application = application;
        registryPersister.load();
        AutoSave autoSave = new AutoSave(registryPersister);
        autoSave.autoSave();
        CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry, "localhost", "foobar");
        catalogueLoader.run();
        interpreter = new CommandInterpreter(this.application, registryPersister, console, registry, remoteRegistry);
        console.registerInputHandler(this);
        console.readInput();
    }

    @Override
    public void handle(CommandLine commandline)
    {
        Command command = interpreter.interpret(commandline);
        command.execute();
    }
}
