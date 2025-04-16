package views;

import java.util.Scanner;

public class ShowConsole {
    private Scanner scanner;

    public ShowConsole() {
        this.scanner = new Scanner(System.in);
        showBanner();
    }

    public void showBanner() {
        System.out.println("*** Métodos de Búsqueda ***");
    }

    public int inputCode() {
        System.out.print("Ingrese un código de persona: ");
        return scanner.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese un nombre: ");
        return scanner.next();
    }

    public int inputOption() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Buscar por código");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
