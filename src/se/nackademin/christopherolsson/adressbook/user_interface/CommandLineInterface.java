package se.nackademin.christopherolsson.adressbook.user_interface;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {

    private Console console = new Console();

    public CommandLineInterface()
    {
        console.registerInputHandler(this);
        console.readInput();
    }

    @Override
    public void handle(CommandLine commandline) {
        
    }
}
