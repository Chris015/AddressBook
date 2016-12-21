package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.client.CatalogueLoader;
import se.nackademin.christopherolsson.adressbook.commands.Command;
import se.nackademin.christopherolsson.adressbook.registry.Registry;
import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLineInterface implements InputHandler {
    private RemoteRegistry remoteRegistry;
    private Registry registry = new Registry(); //TODO: Needs the actual Registry.
    private Console console = new Console();
    private CommandInterpreter interpreter = new CommandInterpreter(console,registry, remoteRegistry);


    public CommandLineInterface()
    {
        remoteRegistry = new RemoteRegistry();
        CatalogueLoader catalogueLoader = new CatalogueLoader(remoteRegistry);
        catalogueLoader.run();
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
