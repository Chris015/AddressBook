package se.nackademin.christopherolsson.adressbook.user_interface;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {
    private CommandLine commandLine = new CommandLine(null, null);
    private Console console = new Console();

    public CommandLineInterface()
    {
        console.registerInputHandler(this);
    }

    @Override
    public void handle(CommandLine commandline) {
        
    }



}
