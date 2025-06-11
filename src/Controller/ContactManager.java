package Controller;

import Model.Contact;
import java.util.LinkedList; 

public class ContactManager {
    private LinkedList<Contact> contacts; 
    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo.");
        }
        // Buscar por nombre antes de añadir para evitar duplicados
        if (findContactByName(contact.getName()) != null) {
            System.out.println("Error: Un contacto con el nombre '" + contact.getName() + "' ya existe.");
            return;
        }
        contacts.add(contact); // Usamos el método add() estándar
        System.out.println("Contacto '" + contact.getName() + "' agregado exitosamente.");
    }

    public Contact findContactByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre a buscar no puede ser nulo o vacío.");
        }

        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null; 
    }

    public boolean deleteContactByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre a eliminar no puede ser nulo o vacío.");
        }

        Contact contactToDelete = new Contact(name);
        return contacts.remove(contactToDelete); 
    }

    public LinkedList<Contact> getAllContacts() {
        return contacts; 
    }
}