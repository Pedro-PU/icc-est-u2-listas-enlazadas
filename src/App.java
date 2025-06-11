import Controller.MenuController;
import Model.*;
public class App {
    public static void main(String[] args) {

        MenuController app = new MenuController();
        app.showMenu();
        
        System.out.println("Hello, World!");
        Contact c1 = new Contact("Juan", "123");
        Contact c4 = new Contact("Juan");
        Contact c2 = new Contact("Juan", null);
        Contact c3 = new Contact("Juana", "456");
        Contact c5 = new Contact("Juan", "123");

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
        System.out.println(c1.equals(c5));
    }
}
