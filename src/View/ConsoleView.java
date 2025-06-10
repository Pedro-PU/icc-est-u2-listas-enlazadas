package View;

import java.util.Scanner;

public class ConsoleView {


    public void displayMenu(){
        System.out.println("\nMenú de la Agenda de Contactos:"+
            "1. Agregar contacto"+
            "2. Buscar contacto"+
            "3. Eliminar contacto"+
            "4. Mostrar contactos"+
            "5. Salir"+
            "Seleccione una opción: "
        );
    }

    public String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String dato = scanner.nextLine();
        scanner.close();
        return dato;
        
    }

    public void showMessage(String mensaje) {
        System.out.println(mensaje);
    }

}