package se.nackademin.christopherolsson.adressbook.functions;

import se.nackademin.christopherolsson.adressbook.Contact;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class ContactFormatter {

    public static String format(Contact contact) {
        return contact.getId() + "\n"
                + contact.getFirstName() + "\n"
                + contact.getLastName() + "\n"
                + contact.getEmailAdress() + "\n";
    }
}
