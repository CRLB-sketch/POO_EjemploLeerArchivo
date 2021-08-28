/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [Vista/View] </h3>
 * <p> Recordemos que vista es la parte donde mostramos los mensajes e interactuamos con el usuario </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 1.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

import java.util.Scanner;

public class View {
    
    // Atributos <-----------------------------------------------------------------------------
    private Scanner scan;
    
    // Constructor <---------------------------------------------------------------------------
    public View(){
        scan = new Scanner(System.in);
    }
    
    // Métodos <-------------------------------------------------------------------------------
    public String menu(){
        System.out.println("Menu: ");
        System.out.println("1. Ver datos del archivo");
        System.out.println("2. Ver si un estudiante esta en el registro de notas");
        System.out.println("3. Ver notas específicas de un estudiante (num Carne)");
        System.out.println("4. Ver cantidad de aprobados y reprobados");
        System.out.println("5. Salir");

        return scan.nextLine();
    }

    public void showInformation(String information){
        System.out.println(information);
    }

    public String askName(){
        System.out.println("\nIngrese el nombre del estudiante que desea buscar en el sistema: ");

        return scan.nextLine();
    }

    public void showEstudentFound(boolean result){
        System.out.println((result) ? "\nEstudiante ingresado si esta en el sistema" : "\nNo esta en el sistema");
    }

    public String askIdentification(){
        System.out.println("\nIngrese el numero de carne del estudiante: ");
        
        return scan.nextLine();
    }

    public void errorFile(){
        System.out.println("\n-> ERROR: No se logró leer el archivo, porfavor verifica el nombre del archivo csv");
    }
    
    public void invalid(){
        System.out.println("\n-> ERROR: Opción ingresada inválida\n");
    }

    public void exit(){
        System.out.println("\n-> Terminando programa....");
    }
}
