package se.nackademin.christopherolsson.adressbook.user_interface;


import java.util.Scanner;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class Console implements ConsolePrinter {

    private InputHandler inputHandler;


    @Override
    public void print(String inputLine) {
        System.out.println(inputLine);
    }

    public void registerInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    void readInput() {
        while (true) {
            Scanner consoleReader = new Scanner(System.in);
            String input = consoleReader.nextLine();
            inputHandler.handle(CommandLine.parse(input));
        }

    }

}
