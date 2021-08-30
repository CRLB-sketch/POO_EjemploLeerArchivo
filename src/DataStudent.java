/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [Datos del estudiante / Data Stundent] </h3>
 * <p> Clase que nos ayudará a tener bien organizada la información del estudiante </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 2.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

public class DataStudent {
    // Atributos <-------------------------------------------------------------------------------------------------
    private String carne, nombre;
    // Esto hubiera quedado mejor y más optimizad almacenar todas las notas con un arreglo de int "int[]"
    // pero creo que con esto quedará más claro
    private final static int TOTALACTIVITIES = 9;
    private int lab1, lab2, lab3, lab4, lab5, investigacion, proyecto, examen1, examen2;

    // Constructor <-----------------------------------------------------------------------------------------------
    public DataStudent(String pCarne, String pNombre, int[] notas){
        carne = pCarne;
        nombre = pNombre;
        lab1 = notas[0];
        lab2 = notas[1];
        lab3 = notas[2];
        lab4 = notas[3];
        lab5 = notas[4];
        investigacion = notas[5];
        proyecto = notas[6];
        examen1 = notas[7];
        examen2 = notas[8];
    }

    // Getters <---------------------------------------------------------------------------------------------------
    public String getCarne(){
        return carne;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // Métodos <---------------------------------------------------------------------------------------------------
    public int avarage(){
        int sum = lab1 + lab2 + lab3 + lab4 + lab5 + investigacion + proyecto + examen1 + examen2;        
        return sum / TOTALACTIVITIES;
    }

    public String paraSobreescribirDatos(){
        return carne + "," + nombre + "," + lab1 + "," + lab2 + "," + lab3 + "," + lab4 + "," + lab5 + "," 
            + investigacion + "," + proyecto + "," + examen1 + "," + examen2;
    }
    
    @Override
    public String toString() {        
        return "Estudiante: " + nombre +"\n-> Lab 1: " + lab1 + ", Lab 2: " + lab2 
            + ", Lab 3: " + lab3 + ", Lab 4: " + lab4 + ", Lab 5: " + lab5
            + "\n-> Investigacion: "+ investigacion + "\nProyecto: " + proyecto
            + "\n-> Examen 1: " + examen1 + ", Examen 2: " + examen2 + "\n";
    }    
}
