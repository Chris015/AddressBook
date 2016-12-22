package se.nackademin.christopherolsson.adressbook.functions;

import se.nackademin.christopherolsson.adressbook.registry.Contact;

import java.util.Comparator;
import java.util.List;

/**
 * @author Christopher Olsson on 2016-12-21.
 */
public class ContactListSorter {
    public static List<Contact> sort(List<Contact> contactList) {
        contactList.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact contact1, Contact contact2) {
                return contact1.getFirstName().compareToIgnoreCase(contact2.getFirstName());
            }
        });
        return contactList;
    }
}
