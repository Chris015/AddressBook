package se.nackademin.christopherolsson.adressbook.registry.remote_registry;

import se.nackademin.christopherolsson.adressbook.Contact;
import se.nackademin.christopherolsson.adressbook.registry.ContactDetails;

import java.io.Serializable;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteContact implements Contact{
    private String id;
    private ContactDetails contactDetails;

    public RemoteContact(String id, String firstName, String lastName, String eMailAddress) {
        contactDetails = new ContactDetails(firstName, lastName, eMailAddress);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return contactDetails.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return contactDetails.getEmailAddress();
    }
}
