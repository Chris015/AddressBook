package se.nackademin.christopherolsson.adressbook.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class Registry {
    private List<Contact> contactList = new ArrayList<>();


    public void addContact(String firstName, String lastName, String eMailAddress) {
        contactList.add(new LocalContact(firstName, lastName, eMailAddress, UUID.randomUUID()));
    }

    public void deleteContact(String id) {
        for (int i = contactList.size() - 1; i >= 0; i--) {
            if (contactList.get(i).getId().equals(id)) {
                contactList.remove(contactList.get(i));
                return;
            }
        }
    }

    public List<Contact> search(String term) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) ||
                    (contact.getLastName().toLowerCase().startsWith(term.toLowerCase()))) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public void load(List<Contact> contacts) {
        this.contactList.addAll(contacts);
    }

    public List<Contact> getContacts() {
        return this.contactList;
    }

}
