package se.nackademin.christopherolsson.adressbook.registry_file_handler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoSave {
    private final static Logger log = Logger.getLogger(AutoSave.class.getName());
    private RegistryPersister registryPersister;

    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    public void autoSave() {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5_000);
                    log.info("Auto save started...");
                    registryPersister.save();
                    log.info("Auto save finished!");
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, "Something wrong occurred", e);
                }
            }
        }).start();
    }
}
