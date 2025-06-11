package Controller;

import Model.Contact;
import View.ConsoleView;

import java.util.LinkedList;
import java.util.Scanner;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
        loadDefaultContacts(); 
    }

    private void loadDefaultContacts() {
        consoleView.showMessage("Cargando contactos por defecto...");
        contactManager.addContact(new Contact("Juan Perez", "0991234567"));
        contactManager.addContact(new Contact("Maria Garcia", "0987654321"));
        contactManager.addContact(new Contact("Carlos Sanchez", "0971122334"));
        contactManager.addContact(new Contact("Ana Lopez", "0969988776"));
        contactManager.addContact(new Contact("Juan Perez", "0990000000"));
        consoleView.showMessage("Contactos por defecto cargados.\n");
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            consoleView.displayMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                consoleView.showMessage("Entrada inválida. Por favor, ingrese un número.");
                option = 0;
                continue;
            }

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    printList();
                    break;
                case 5:
                    consoleView.showMessage("Saliendo...");
                    break;
                default:
                    consoleView.showMessage("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }

    private void addContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto: ");
        if (name.trim().isEmpty()) {
            consoleView.showMessage("Error: El nombre del contacto no puede estar vacío.");
            return;
        }
        String phone = consoleView.getInput("Ingrese el teléfono: ");
        if (phone.trim().isEmpty()) {
            consoleView.showMessage("Error: El teléfono del contacto no puede estar vacío.");
            return;
        }

        try {
            contactManager.addContact(new Contact(name, phone));
        } catch (IllegalArgumentException e) {
            consoleView.showMessage("Error: " + e.getMessage());
        }
    }

    private void findContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a buscar: ");
        try {
            Contact foundContact = contactManager.findContactByName(name);
            if (foundContact != null) {
                consoleView.showMessage("Contacto encontrado: " + foundContact);
            } else {
                consoleView.showMessage("Contacto no encontrado.");
            }
        } catch (IllegalArgumentException e) {
            consoleView.showMessage("Error: " + e.getMessage());
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a eliminar: ");
        try {
            boolean removed = contactManager.deleteContactByName(name);
            if (removed) {
                consoleView.showMessage("Contacto '" + name + "' eliminado exitosamente.");
            } else {
                consoleView.showMessage("No se encontró el contacto '" + name + "' para eliminar.");
            }
        } catch (IllegalArgumentException e) {
            consoleView.showMessage("Error: " + e.getMessage());
        }
    }

    private void printList() {
        consoleView.showMessage("--- Lista de Contactos ---");
        LinkedList<Contact> allContacts = contactManager.getAllContacts();
        if (allContacts.isEmpty()) {
            consoleView.showMessage("No hay contactos en la lista.");
        } else {
            for (Contact contact : allContacts) {
                consoleView.showMessage(contact.toString());
            }
        }
    }
}