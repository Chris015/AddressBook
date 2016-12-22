package se.nackademin.christopherolsson.adressbook.registry_file_handler;

import se.nackademin.christopherolsson.adressbook.registry.Contact;
import se.nackademin.christopherolsson.adressbook.registry.Registry;

import java.io.*;
import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RegistryPersister {

    private File file = new File("contactRegister.txt");
    private Registry registry;

    public RegistryPersister(Registry registry) {
        this.registry = registry;
    }

    public void load() {

        if (file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                registry.load((List<Contact>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void save() {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(registry.getContacts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
