/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [System Notes "Modelo"] </h3>
 * <p> Lógica principal para interactuar con los objetos </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 1.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

// Librerias para leer el contenido del archivo
import java.io.BufferedReader;
import java.io.FileReader;
// Importar ArrayList
import java.util.ArrayList;
 
public class SystemNotes {

    // Atributos <-----------------------------------------------------------------------------    
    private ArrayList<DataStudent> data; // Estudiantes almacenados
    private String stateFile = ""; // Estado del archivo

    // Constructor <---------------------------------------------------------------------------
    public SystemNotes(String nameFile){
        data = new ArrayList<DataStudent>();
        stateFile = readFileContent(nameFile); // Verificar si la información se leyo exitosamente
    }

    // Getter <--------------------------------------------------------------------------------
    public String getStateFile(){
        return stateFile;
    }

    // Métodos <-------------------------------------------------------------------------------    
    public String showAllNamesOfList(){
        String information = "";

        for (DataStudent dataStudent : data) {
            information += "-> CARNE: " + dataStudent.getCarne() + ", NOMBRE: " + dataStudent.getNombre() + "\n";
        }
        
        return information;
    }

    public boolean verifyStudent(String searchedName){
        for (DataStudent dataStudent : data) {
            String tempName = dataStudent.getNombre();
            if(tempName.equals(searchedName))
                return true;            
        }        
        return false;
    }
    
    public String seeEspecificNotes(String identification){
        for (DataStudent dataStudent : data) {
            String tempCarne = dataStudent.getCarne();
            if(tempCarne.equals(identification))
                return dataStudent.toString();
        }
        return "\n-> ERROR: No se encontro el estudiante solicitado por carne";
    }

    public String seeStudentsApproved(){
        int aproved = 0;
        int rejected = 0;
        for (DataStudent dataStudent : data) {
            int avarageEstudent = dataStudent.avarage();
            if(avarageEstudent > 60) aproved++;
            else rejected++;
        }
        
        return "\nAPROBADOS: " + aproved + ", REPROBADOS: " + rejected;
    }

    private String readFileContent(String file){
        String text = "";
        BufferedReader bf;
        
        try {
            bf = new BufferedReader(new FileReader(file));
            String temp = "";
            String bfRead;

            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead + "\n";
            }

            // El temp tendrá la información del archivo
            // Ahora vamos a preparar y adaptar la informacion
            String[] lines = temp.split("\n"); // Separar contenido por lineas

            for (int i = 1; i < lines.length; i++) {
                // Separar el contenido de la linea por comas para obtener los datos individualmente
                String[] estudentData = lines[i].split(",");

                String carne = estudentData[0];
                String name = estudentData[1];
                int lab1 = Integer.parseInt(estudentData[2]);
                int lab2 = Integer.parseInt(estudentData[3]);
                int lab3 = Integer.parseInt(estudentData[4]);
                int lab4 = Integer.parseInt(estudentData[5]);
                int lab5 = Integer.parseInt(estudentData[6]);
                int investigacion = Integer.parseInt(estudentData[7]);
                int proyecto = Integer.parseInt(estudentData[8]);
                int examen1 = Integer.parseInt(estudentData[9]);
                int examen2 = Integer.parseInt(estudentData[10]);
                int[] notes = { lab1, lab2, lab3, lab4, lab5, investigacion, proyecto, examen1, examen2 };

                data.add(new DataStudent(carne, name, notes)); // Agregar nuevo estudiante con sus respectivos datos
            }
            
            // Text se usará para confirmar los datos del archivo
            text = "--> EXITO";

        } catch (Exception e) {
            text = "--> ERROR";
        }

        return text;
    }
}
