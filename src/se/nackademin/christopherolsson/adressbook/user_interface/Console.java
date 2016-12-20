package se.nackademin.christopherolsson.adressbook.user_interface;

/**
 * Created by Fredrik Grimmenhag on 2016-12-20.
 */
public class Console implements ConsolePrinter {

    @Override
    public void print(String inputLine) {
        System.out.println(inputLine);
    }

    void registerInputHandler()
    {

    }
}
