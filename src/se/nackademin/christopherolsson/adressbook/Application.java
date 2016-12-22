package se.nackademin.christopherolsson.adressbook;

import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.AutoSave;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;
import se.nackademin.christopherolsson.adressbook.user_interface.CommandLineInterface;
import se.nackademin.christopherolsson.adressbook.user_interface.Console;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class Application {
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Registry registry = new Registry();
    private Console console = new Console();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(console, remoteRegistry, "localhost");
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);

    public void start() {
        catalogueLoader.run();
        registryPersister.load();
        autoSave.autoSave();
        new CommandLineInterface(this, console,registryPersister, registry, remoteRegistry);
    }

    public void quit() {
        System.exit(0);
    }
}
