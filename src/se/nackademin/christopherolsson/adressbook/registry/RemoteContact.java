package se.nackademin.christopherolsson.adressbook.registry;

import se.nackademin.christopherolsson.adressbook.Contact;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteContact implements Contact{
    private final String id;
    private ContactDetails contactDetails;

    public RemoteContact(String firstName, String lastName, String eMailAddress, String id) {
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
    public String getEmailAdress() {
        return contactDetails.geteMailAddress();
    }
}
