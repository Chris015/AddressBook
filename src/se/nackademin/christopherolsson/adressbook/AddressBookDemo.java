package se.nackademin.christopherolsson.adressbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AddressBookDemo {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("logging.properties")){
            LogManager.getLogManager().readConfiguration(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load log properties");
        }

        new Application().start();
    }
}
