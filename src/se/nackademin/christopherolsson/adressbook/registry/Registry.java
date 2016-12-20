package se.nackademin.christopherolsson.adressbook.registry;

import se.nackademin.christopherolsson.adressbook.Contact;

import java.util.List;
import java.util.UUID;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class Registry {
    private List<Contact> contactList;


    void addContact(String firstName, String lastName, String eMailAddress) {
        contactList.add(new LocalContact(firstName, lastName, eMailAddress, UUID.randomUUID()));
    }

    List<Contact> getContacts() {
        return this.contactList;
    }

    void deleteContact(String id) {
        // TODO redundant assignment?
        for (int i = contactList.size(); i > -1; i--) {
            if (contactList.get(i).getId().equals(id)) {
                contactList.remove(contactList.get(i));
            }
        }
    }

    List<Contact> search(String term) {
        List<Contact> searchResults = null;
        for (Contact contact : contactList) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) ||
                    (contact.getLastName().toLowerCase().startsWith(term.toLowerCase()))) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    void load(List<Contact> contacts) {
        this.contactList.addAll(contacts);
    }

}
