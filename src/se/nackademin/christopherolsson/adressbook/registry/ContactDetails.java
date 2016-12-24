package se.nackademin.christopherolsson.adressbook.registry;

import java.io.Serializable;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class ContactDetails implements Serializable {
    private String firstName;
    private String lastName;
    private String eMailAddress;

    public ContactDetails(String firstName, String lastName, String eMailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return eMailAddress;
    }
}
