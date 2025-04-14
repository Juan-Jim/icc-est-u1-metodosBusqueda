import java.util.Scanner;

public class App {
    MetodoBusqueda metodosBusqueda = new MetodoBusqueda();

    public static void main(String[] args) {
        App app = new App(); 
        Scanner leer = new Scanner(System.in);

        System.out.print("¿Ponga los elementos que tendra el arreglo?: ");
        int n = leer.nextInt();
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = leer.nextInt();
        }

        System.out.print("Ingresa el elemnto que desea buscar: ");
        int valor = leer.nextInt();

        int resultado = app.metodosBusqueda.busquedaLineal(arreglo, valor);

        if (resultado != -1) {
            System.out.println("El elemento se encuentra en la posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado.");
        }

        leer.close();
    }
}
