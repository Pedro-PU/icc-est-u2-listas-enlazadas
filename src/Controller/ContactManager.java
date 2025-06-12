package Controller;

import Model.LinkedList;
import Model.Contact;

public class ContactManager {
    LinkedList<Contact> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        contacts.appendToTail(contact);
    }

    public Contact findContactByName(String name) {
        if (name == null) return null;
        Contact buscado = new Contact(name);
        return contacts.findByValue(buscado);
    }

    public void removeContactByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        Contact buscado = new Contact(name);
        contacts.deleteByValue(buscado);
    }

    public void printList() {
        contacts.print();
    }
}
