package cz.aura.interview.basic.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockDbManager {
	
	// nahrazuje DB
    private List<Contact> mockDb = new ArrayList<>();
	
    /**
     * Uloží kontakty do DB
     */
	public void save(List<Contact> contacts) {
		mockDb = contacts.stream().collect(Collectors.toList());
	}
	
	/**
     * Nahraje uložené kontakty z DB
     */
    public List<Contact> load() {
        return this.mockDb.stream().collect(Collectors.toList());
    }

}
