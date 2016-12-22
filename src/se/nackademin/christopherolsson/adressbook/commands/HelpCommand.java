package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.functions.CommandFormatter;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;
import se.nackademin.christopherolsson.adressbook.user_interface.HelpMenu;

import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class HelpCommand implements Command {

    private String name = "Help";
    private String description = "Displays the help menu";

    private HelpMenu helpMenu = new HelpMenu();
    ConsolePrinter consolePrinter;
    private List<String> parameters;

    public HelpCommand(ConsolePrinter consolePrinter, List<String> parameters) {
        this.consolePrinter = consolePrinter;
        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {
        try {
            if (validate()) {
                String menu = "";
                List<Command> commands = helpMenu.getCommands();
                for (Command command : commands) {
                    menu += CommandFormatter.format(command);
                }
                consolePrinter.print(menu);
            }
        } catch (InvalidCommandParameterException e) {
            e.printStackTrace();
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 0) {
            return true;
        } else {
            throw new InvalidCommandParameterException("Help doesn't require any parameters");
        }

    }
}
