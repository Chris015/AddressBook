package se.nackademin.christopherolsson.adressbook.functions;

import se.nackademin.christopherolsson.adressbook.registries.Contact;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class ContactFormatter {

    public static String format(Contact contact) {
        return "Id:\t\t\t\t" + contact.getId() + "\n"
                + "First Name:\t\t" + contact.getFirstName() + "\n"
                + "Last Name:\t\t" + contact.getLastName() + "\n"
                + "Email Address:\t" + contact.getEmailAddress() + "\n";
    }
}
