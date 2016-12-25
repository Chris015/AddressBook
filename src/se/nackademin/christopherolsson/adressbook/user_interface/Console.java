package se.nackademin.christopherolsson.adressbook.user_interface;


import java.util.Scanner;
import java.util.logging.Logger;

public class Console implements ConsolePrinter {
    private final static Logger log = Logger.getLogger(Console.class.getName());
    private InputHandler inputHandler;

    @Override
    public void print(String inputLine) {
        System.out.println(inputLine);
    }

    public void registerInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void readInput() {
        while (true) {
            Scanner consoleReader = new Scanner(System.in);
            String input = consoleReader.nextLine();
            log.fine("User input: " + input);
            inputHandler.handle(CommandLine.parse(input));
        }

    }
}
