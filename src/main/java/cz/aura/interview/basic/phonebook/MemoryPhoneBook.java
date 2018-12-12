package cz.aura.interview.basic.phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Telefonní seznam s možností uložení a nahrání kontaktů do DB
 */
public class MemoryPhoneBook {

    private List<Contact> contacts = new ArrayList<>();

    private MockDbManager manager = new MockDbManager();

    /**
     * Nahraje uložené kontakty
     */
    public void load() {
        this.contacts = manager.load();
    }

    /**
     * Vrátí kontakty
     * @return
     */
    public List<Contact> get() {
        return contacts;
    }

    /**
     * Uloží kontakty
     */
    public void save() {
        manager.save(contacts);
    }

    /**
     * Přidá kontakt
     * @param contact
     */
    public void add(Contact contact) {
        this.contacts.add(contact);
    }

    /**
     * Vrátí počet kontaktů
     */
    public int size() {
        return this.contacts.size();
    }

    /**
     * Smaže všechny kontakty
     */
    public void clear() {
        this.contacts.clear();
    }

    /**
     * Vrátí kontakt podle telefonu, pokud takový neexistuje, vrátí null
     * @param phoneNumber
     * @return
     */
    public Contact find(String phoneNumber) {
        return this.contacts.stream().filter(contact -> phoneNumber.equals(contact.getPhoneNumber())).findAny().orElse(null);
    }
}
