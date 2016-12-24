package se.nackademin.christopherolsson.adressbook.registries.remote_registry;


import se.nackademin.christopherolsson.adressbook.registries.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteRegistry {

    private List<Contact> remoteContactList = new ArrayList<>();

    public void add(String id, String firstName, String lastName, String eMailAddress) {
        remoteContactList.add(new RemoteContact(id, firstName, lastName, eMailAddress));
    }

    public List<Contact> search(String term) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : remoteContactList) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) ||
                    (contact.getLastName().toLowerCase().startsWith(term.toLowerCase()))) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public boolean contactIdExists(String id) {
        for (Contact contact : remoteContactList) {
            if (contact.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<Contact> getContacts() {
        return remoteContactList;
    }
}
