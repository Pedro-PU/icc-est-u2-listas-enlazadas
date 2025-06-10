package Controller;
import Model.*;
public class ContactManager {
    LinkedList<Contact<String,String>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact(Contact<String,String> contact){
        contacts.appendToTail(contact);
    }

    public Contact<String,String> findContactByName(String name){
        /*for (Contact<String,String> contact : contacts) {
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;*/
        Contact<String,String> cB = new Contact<String,String>(name);

        return contacts.findByValue(name);
    }
    public void removeContactByName(String name){
        if(name == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        for (Contact<String,String> contact : contacts) {
            if(contact.getName().equals(name)){
                contacts.deleteByValue(contact);
            }
        }
    }

}
