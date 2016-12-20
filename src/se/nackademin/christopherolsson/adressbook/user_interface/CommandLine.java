package se.nackademin.christopherolsson.adressbook.user_interface;

import java.util.ArrayList;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLine {

    private String command;
    private ArrayList<String> parameters;

    public CommandLine(String command, ArrayList<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    static CommandLine parse(String inputCommand)
    {
        String input = inputCommand;
        input = input.trim().replaceAll(" +", " ");
        String[] inputParts = input.split(" ");

        String command = inputParts[0];

        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 1; i < inputParts.length; i++)
        {
            parameters.add(inputParts[i]);
        }

        return new CommandLine(command, parameters);
    }


    public String getCommand() {
        return command;
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

}
