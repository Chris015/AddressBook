package se.nackademin.christopherolsson.adressbook.registry;

import se.nackademin.christopherolsson.adressbook.Contact;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class LocalContact implements Contact {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String eMailAddress;

    public LocalContact(String firstName, String lastName, String eMailAddress, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.id = id;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getEmailAdress() {
        return this.eMailAddress;
    }
}
