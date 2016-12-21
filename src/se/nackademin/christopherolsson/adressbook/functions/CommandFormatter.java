package se.nackademin.christopherolsson.adressbook.functions;

import se.nackademin.christopherolsson.adressbook.commands.Command;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class CommandFormatter {


    public static String format(Command command){
        return String.format("%-10s%s\n", command.getName(), command.getDescription());
    }



}
