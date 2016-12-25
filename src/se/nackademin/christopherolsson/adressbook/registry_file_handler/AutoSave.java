package se.nackademin.christopherolsson.adressbook.registry_file_handler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
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
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, "Something wrong occurred", e);
                }
                registryPersister.save();
            }
        }).start();
    }
}
