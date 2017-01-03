package se.nackademin.christopherolsson.adressbook;

import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.registries.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registries.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.AutoSave;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;
import se.nackademin.christopherolsson.adressbook.user_interface.CommandLineInterface;
import se.nackademin.christopherolsson.adressbook.user_interface.Console;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Application {
    private final static Logger log = Logger.getLogger(Application.class.getName());
    private RemoteRegistry remoteRegistry = new RemoteRegistry();
    private Registry registry = new Registry();
    private Console console = new Console();
    private CatalogueLoader catalogueLoader = new CatalogueLoader(console, remoteRegistry, "localhost");
    private RegistryPersister registryPersister = new RegistryPersister(registry);
    private AutoSave autoSave = new AutoSave(registryPersister);

    public static void main(String[] args) {
        Application application = new Application();
        application.logSetup();
        application.start();
    }

    private void logSetup() {
        try (FileInputStream fileInputStream = new FileInputStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load log properties");
        }
    }

    private void start() {
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
