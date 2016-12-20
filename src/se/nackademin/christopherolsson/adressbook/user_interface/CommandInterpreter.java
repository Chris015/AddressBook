package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.commands.Command;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class CommandInterpreter {

    public Command interpret(CommandLine commandLine)
    {
        System.out.println(commandLine.getCommand());
        String command = commandLine.getCommand();
        for (ValidCommands validCommand : ValidCommands.values()) {
            if(command.equals(validCommand.name().toLowerCase())) {

            }
        }
        // TODO if valid command, return command, else throw invalid command exception
        return null;
    }

}
