package cz.aura.interview.basic.phonebook;

import org.springframework.util.Assert;

public class Contact {

    private String phoneNumber; // jednoznačně definuje zaměstnance
    private String firstname;
    private String surname;

    public Contact(String firstname, String surname, String phoneNumber) {
        Assert.notNull(phoneNumber, "phoneNumber is required");
        Assert.notNull(firstname, "firstname is required");
        Assert.notNull(surname, "surname is required");

        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

}
