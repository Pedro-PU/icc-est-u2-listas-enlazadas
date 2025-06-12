package Controller;

import View.ConsoleView;
import Model.Contact;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
        ContactsPorDefault();
    }
    
    protected void ContactsPorDefault() {
        contactManager.addContact(new Contact("Juan Perez", "0991234567"));
        contactManager.addContact(new Contact("Maria Garcia", "0987654321"));
        contactManager.addContact(new Contact("Carlos Sanchez", "0971122334"));
        contactManager.addContact(new Contact("Ana Lopez", "0969988776"));
        contactManager.addContact(new Contact("Juan Perez", "0990000000"));
    }

    public void showMenu() {
        int option;
        do {
            consoleView.displayMenu();
            String input = consoleView.getInput("");
            option = Integer.parseInt(input);

            switch (option) {
                case 1 -> addContact();
                case 2 -> findContact();
                case 3 -> deleteContact();
                case 4 -> printList();
                case 5 -> consoleView.showMessage("Saliendo...");
                default -> consoleView.showMessage("Opcion no valida. Vuela a internar");
            }
        } while (option != 5);
    }

    protected void addContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto: ");
        String phone = consoleView.getInput("Ingrese el telefono: ");
        contactManager.addContact(new Contact(name, phone));
        consoleView.showMessage("Contacto agregado");
    }

    protected void findContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a buscar: ");
        Contact contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.showMessage("Contacto no encontrado");
        }
    }

    protected void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto a eliminar: ");
        contactManager.removeContactByName(name);
        consoleView.showMessage("Contacto eliminado (x)");
    }

    protected void printList() {
        consoleView.showMessage("Lista de contactos:");
        contactManager.printList();
    }
}
