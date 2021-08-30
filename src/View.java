/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [Vista/View] </h3>
 * <p> Recordemos que vista es la parte donde mostramos los mensajes e interactuamos con el usuario </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 2.0
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
        System.out.println("----------------------------------------------------------------");
        System.out.println("Menu: ");
        System.out.println("1. Ver datos del archivo");
        System.out.println("2. Ver si un estudiante esta en el registro de notas");
        System.out.println("3. Ver notas específicas de un estudiante (num Carne)");
        System.out.println("4. Ver cantidad de aprobados y reprobados");
        System.out.println("5. Agregar estudiante al listado");
        System.out.println("6. Cambiar dato/nota de un estudiante (por carne) [POR EL MOMENTO NO DISPONIBLE XD]");
        System.out.println("7. Elimiar un estudiante del historial (por carne) [POR EL MOMENTO NO DISPONIBLE XD]");
        System.out.println("8. GUARDAR CAMBIOS");
        System.out.println("9. Salir");

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

    public String[] createNewStudent(){

        boolean finish = false;
        String[] finalData = new String[11];
        do {            
            System.out.println("Ingrese el num de carne: ");
            String carne = scan.nextLine();
            System.out.println("Ingrese el nombre del estudiante: ");
            String nombre = scan.nextLine();
            System.out.println("Ingrese la nota del Lab 1 (solamente numeros): ");
            String nota1 = scan.nextLine();
            System.out.println("Ingrese la nota del Lab 2 (solamente numeros): ");
            String nota2 = scan.nextLine();
            System.out.println("Ingrese la nota del Lab 3 (solamente numeros): ");
            String nota3 = scan.nextLine();
            System.out.println("Ingrese la nota del Lab 4 (solamente numeros): ");
            String nota4 = scan.nextLine();
            System.out.println("Ingrese la nota del Lab 5 (solamente numeros): ");
            String nota5 = scan.nextLine();
            System.out.println("Ingrese la nota de la investigación (solamente numeros): ");
            String nota6 = scan.nextLine();
            System.out.println("Ingrese la nota del proyecto (solamente numeros): ");
            String nota7 = scan.nextLine();
            System.out.println("Ingrese la nota del examen 1 (solamente numeros): ");
            String nota8 = scan.nextLine();
            System.out.println("Ingrese la nota del examen 2 (solamente numeros): ");
            String nota9 = scan.nextLine();
            
            try {
                // Vamos a verificar si se ingresaro los datos correctamente
                Integer.parseInt(nota1);
                Integer.parseInt(nota2);
                Integer.parseInt(nota3);
                Integer.parseInt(nota4);
                Integer.parseInt(nota5);
                Integer.parseInt(nota6);
                Integer.parseInt(nota7);
                Integer.parseInt(nota8);
                Integer.parseInt(nota9);           
                
                // Si todo salio bien entonces terminaremos con el ciclo y asignaremos los datos correctos
                finalData[0] = nombre;
                finalData[1] = carne;
                finalData[2] = nota1;
                finalData[3] = nota2;
                finalData[4] = nota3;
                finalData[5] = nota4;
                finalData[6] = nota5;
                finalData[7] = nota6;
                finalData[8] = nota7;
                finalData[9] = nota8;
                finalData[10] = nota9;

                finish = true;
                System.out.println("Datos ingresados correctamente");
            } 
            catch (Exception e) {
                System.out.println("Hey! No debías de ingresar números, porfavor ingresalo de nuevo");
            }

        } while (!finish);
        
        return finalData;
    }
    
    public void invalid(){
        System.out.println("\n-> ERROR: Opción ingresada inválida\n");
    }
    
    public void exit(){
        System.out.println("\n-> Terminando programa....");
    }
    
    public void errorFile(){
        System.out.println("\n-> ERROR: No se logró leer el archivo, porfavor verifica el nombre del archivo csv");
    }
}
