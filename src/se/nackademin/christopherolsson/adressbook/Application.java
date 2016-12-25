package se.nackademin.christopherolsson.adressbook;

import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registries.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.AutoSave;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;
import se.nackademin.christopherolsson.adressbook.user_interface.CommandLineInterface;
import se.nackademin.christopherolsson.adressbook.user_interface.Console;

import java.util.logging.Logger;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class Application {
    private final static Logger log = Logger.getLogger(Application.class.getName());
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Registry registry = new Registry();
    private Console console = new Console();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(console, remoteRegistry, "localhost");
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);

    public void start() {
        log.info("Program started.");
        catalogueLoader.run();
        registryPersister.load();
        autoSave.autoSave();
        new CommandLineInterface(this, console, registryPersister, registry, remoteRegistry);
    }

    public void quit() {
        log.info("Program terminated.");
        System.exit(0);
    }
}
