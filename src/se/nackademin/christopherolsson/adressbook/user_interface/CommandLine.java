package se.nackademin.christopherolsson.adressbook.user_interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class CommandLine {
    String command;
    List<String> parameters;


    CommandLine parse(String inputCommand)
    {
        String input = inputCommand;
        input = input.trim().replaceAll(" +", " ");
        String[] inputParts = input.split(" ");

        command = inputParts[0];

        parameters = new ArrayList<String>();
        for (int i = 1; i < inputParts.length; i++)
        {
            parameters.add(inputParts[i]);
        }

        return this;
    }


    public String getCommand() {
        return command;
    }

    public List<String> getParameters() {
        return parameters;
    }

}
