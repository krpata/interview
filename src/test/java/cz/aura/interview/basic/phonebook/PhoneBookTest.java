package cz.aura.interview.basic.phonebook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhoneBookTest {

    private MemoryPhoneBook phoneBook = new MemoryPhoneBook();

    private Contact contact = new Contact("Jan", "Novák", "777445588");

    @Before
    public void setUp() {
        phoneBook.clear();
    }

    @Test
    public void testAdd() {
        final int sizeBeforeAdding = phoneBook.size();

        phoneBook.add(contact);

        assertEquals("Po přidání nového kontaktu se nezvýšil počet kontakt; v telefonním seznamu", sizeBeforeAdding + 1, phoneBook.size());
        assertEquals("Po přidání nového kontaktu se tento kontakt v telefonním seznamu nenašel", contact, phoneBook.find(contact.getPhoneNumber()));
    }

    @Test
    public void testSize() {
        assertEquals("Na začátku testu je velikost je velikost seznamu větší než 0", 0, phoneBook.size());

        phoneBook.add(contact);

        assertEquals("Po přidání nového kontaktu se nezvýšil počet kontaktů v telefonním seznamu na 1", 1, phoneBook.size());
    }

    @Test
    public void testClear() {
        phoneBook.add(contact);

        phoneBook.clear();

        assertEquals("Po smazání seznamu je počet kontaktů v seznamu větší než 0", 0, phoneBook.size());
    }

    @Test
    public void testSaveAndLoad() {
        phoneBook.add(contact);
        final int sizeBeforeSaving = phoneBook.size();
        phoneBook.save();
        phoneBook.clear();
        phoneBook.load();

        assertEquals("Po nahrání kontaktů není počet kontaktů stejný jako byl při uložení kontaktů", sizeBeforeSaving, phoneBook.size());
        assertEquals("Po nahrání kontaktů se v seznamu nenachází kontakt, který do něj byl uložen", contact, phoneBook.find(contact.getPhoneNumber()));
    }

}
