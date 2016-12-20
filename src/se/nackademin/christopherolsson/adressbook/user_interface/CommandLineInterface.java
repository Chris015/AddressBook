package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.registry.Registry;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {

    private Registry registry = new Registry(); //TODO: Finish
    private Console console = new Console();
    private CommandInterpreter interpreter = new CommandInterpreter(console,registry);


    public CommandLineInterface()
    {
        console.registerInputHandler(this);
        console.readInput();
    }

    @Override
    public void handle(CommandLine commandline)
    {
        interpreter.interpret(commandline);
    }
}
