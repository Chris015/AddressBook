package se.nackademin.christopherolsson.adressbook.Functions;

import se.nackademin.christopherolsson.adressbook.Contact;

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
