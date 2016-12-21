package se.nackademin.christopherolsson.adressbook;

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

    private void start() {new CommandLineInterface(this);}

    public void quit() {
        System.out.println("HEJ");
        System.exit(0);}

}
