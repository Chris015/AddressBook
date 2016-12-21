package se.nackademin.christopherolsson.adressbook.user_interface;

import se.nackademin.christopherolsson.adressbook.commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class HelpMenu {
    private List<Command> commands = new ArrayList<>();

    public HelpMenu() {
        build();
    }

    private void build() {
        commands.add(new AddContactCommand());
        commands.add(new DeleteContactCommand());
        commands.add(new ListContactsCommand());
        commands.add(new SearchContactsCommand());
        commands.add(new QuitCommand());
    }

    public List<Command> getCommands() {
        return commands;
    }
}
