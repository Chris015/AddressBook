package se.nackademin.christopherolsson.adressbook.commands;

/**
 * @author Christopher Olsson on 2016-12-20.
 */
public class UnknownCommand implements Command{

    private String name = "";
    private String description = "Unknown command";


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
        //TODO: Log shit here
    }
}
