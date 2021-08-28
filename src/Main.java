/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <p> Programa que lee los datos de un archivo csv (que serían las calificaciones) </p>
 * 
 * <h3> Clase: [Main] </h3>
 * <p> Ejecutar principal para ejecutar el programa entero </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 1.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        ctrl.readFile();
    }
}