package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;
import se.nackademin.christopherolsson.adressbook.user_interface.HelpMenu;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class HelpCommand implements Command {
    private final static Logger log = Logger.getLogger(HelpCommand.class.getName());
    private String name = "help";
    private String description = "Displays the help menu";

    private HelpMenu helpMenu;
    private ConsolePrinter consolePrinter;
    private List<String> parameters;

    public HelpCommand() {
    }


    public HelpCommand(ConsolePrinter consolePrinter, List<String> parameters) {
        this.helpMenu = new HelpMenu();
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
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            log.info("Showing help menu...");
            String menu = "";
            List<Command> commands = helpMenu.getCommands();
            for (Command command : commands) {
                menu += format(command);
            }
            consolePrinter.print(menu);
            log.info("Successfully showed the help menu.");
        }

    }

    private static String format(Command command) {
        return String.format("%-10s%s\n", command.getName(), command.getDescription());
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 0) {
            return true;
        } else {
            throw new InvalidCommandParameterException(name + " doesn't require any parameters\n");
        }

    }
}
