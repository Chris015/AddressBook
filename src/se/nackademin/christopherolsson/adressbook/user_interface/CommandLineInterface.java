package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.registry.Registry;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {

    private Registry registry = new Registry(); //TODO: The actual registry
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
        Command command = interpreter.interpret(commandline);
        command.execute();
    }
}
