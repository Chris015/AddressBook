package se.nackademin.christopherolsson.adressbook.registry;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class ContactDetails {
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

    public String geteMailAddress() {
        return eMailAddress;
    }
}
