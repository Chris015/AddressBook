package se.nackademin.christopherolsson.adressbook.registries.registry;

import se.nackademin.christopherolsson.adressbook.registries.Contact;
import se.nackademin.christopherolsson.adressbook.registries.ContactDetails;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class LocalContact implements Contact, Serializable {
    private final UUID id;
    private ContactDetails contactDetails;

    public LocalContact(String firstName, String lastName, String eMailAddress, UUID id) {
        contactDetails = new ContactDetails(firstName, lastName, eMailAddress);
        this.id = id;
    }


    @Override
    public String getId() {
        return this.id.toString();
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