package se.nackademin.christopherolsson.adressbook.commands;

import se.nackademin.christopherolsson.adressbook.Application;
import se.nackademin.christopherolsson.adressbook.exceptions.InvalidCommandParameterException;
import se.nackademin.christopherolsson.adressbook.registry_file_handler.RegistryPersister;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class QuitCommand implements Command {
    private final static Logger log = Logger.getLogger(QuitCommand.class.getName());
    private String name = "quit";
    private String description = "Exits the application";

    private Application application;
    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter;
    private List<String> parameters;

    public QuitCommand() {
    }

    public QuitCommand(Application application, RegistryPersister registryPersister, ConsolePrinter consolePrinter, ArrayList<String> parameters) {
        this.application = application;
        this.registryPersister = registryPersister;
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
            log.info("Terminating the application...");
            registryPersister.save();
            consolePrinter.print("Goodbye!");
            application.quit();
        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == 0) {
            return true;
        }
        throw new InvalidCommandParameterException(name + " doesn't require any parameters\n");

    }
}
