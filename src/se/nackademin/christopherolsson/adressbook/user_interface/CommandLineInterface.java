package se.nackademin.christopherolsson.adressbook.user_interface;

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
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Registry registry = new Registry();
    private Console console = new Console();
    private CommandInterpreter interpreter = new CommandInterpreter(console, registry, remoteRegistry);
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);


    public CommandLineInterface()
    {
        registryPersister.load();
        autoSave.autoSave();
        CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry);
        catalogueLoader.run();
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
