package se.nackademin.christopherolsson.adressbook.registry.remote_registry;



import se.nackademin.christopherolsson.adressbook.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteRegistry {

   private List<Contact> remoteContactList = new ArrayList<Contact>();

    public void add(String firstName, String lastName, String eMailAddress, String id) {
        remoteContactList.add(new RemoteContact(firstName, lastName, eMailAddress, id));
    }

    public List<Contact> search(String term) {
        List<Contact> searchResults = null;
        for (Contact contact : remoteContactList) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) ||
                    (contact.getLastName().toLowerCase().startsWith(term.toLowerCase()))) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public List<Contact> getContacts() {
        return remoteContactList;
    }
}
