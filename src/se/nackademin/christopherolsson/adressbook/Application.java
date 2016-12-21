package se.nackademin.christopherolsson.adressbook;

import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.user_interface.CommandLineInterface;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class Application {

    public static void main(String[] args)
    {
        Application application = new Application();
        application.start();
    }

    public void start()
    {
        CommandLineInterface commandLineInterface = new CommandLineInterface();
    }

    public void quit()
    {

    }

}
