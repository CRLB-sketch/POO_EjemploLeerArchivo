/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [System Notes "Modelo"] </h3>
 * <p> Lógica principal para interactuar con los objetos </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 2.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

// Librerias para leer el contenido del archivo
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
// Importar ArrayList
import java.util.ArrayList;
 
public class SystemNotes {

    // Atributos <-----------------------------------------------------------------------------    
    private ArrayList<DataStudent> data; // Estudiantes almacenados
    private String stateFile; // Estado del archivo
    private String header;

    // Constructor <---------------------------------------------------------------------------
    public SystemNotes(String nameFile){
        data = new ArrayList<DataStudent>();
        stateFile = readFileContent(nameFile); // Verificar si la información se leyo exitosamente
        System.out.println("TAMAÑO: " + data.size());
    }

    // Getter <--------------------------------------------------------------------------------
    public String getStateFile(){
        return stateFile;
    }

    // Métodos <-------------------------------------------------------------------------------    
    public void addNewStudent(String[] dataNewStudent){
        String carne = dataNewStudent[0];
        String name = dataNewStudent[1];
        int[] points = {
            Integer.parseInt(dataNewStudent[2]),
            Integer.parseInt(dataNewStudent[3]),
            Integer.parseInt(dataNewStudent[4]),
            Integer.parseInt(dataNewStudent[5]),
            Integer.parseInt(dataNewStudent[6]),
            Integer.parseInt(dataNewStudent[7]),
            Integer.parseInt(dataNewStudent[8]),
            Integer.parseInt(dataNewStudent[9]),
            Integer.parseInt(dataNewStudent[10])
        };

        data.add(new DataStudent(carne, name, points));
    }
    
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

            header = lines[0];

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

    public String saveChanges(String file){
        String information = "";
        
        // Vamos a preparar toda la informacion
        int numLineas = data.size() + 1; // Tamaño de la cantidad de elementos en el array más el encabezado
        String[] lineas = new String[numLineas]; // Definir tamaño para almacenar las lineas correctas y exactas
        lineas[0] = header; // Regresar el encabezado de nuevo
        
        for (int i = 1; i < lineas.length; i++) { // Empezamos desde 1 para evitar sobreescribir en el encabezado
            DataStudent temp = data.get(i - 1); // Restamos uno para obtener el estudiante correcto
            lineas[i] = temp.paraSobreescribirDatos();
        }
        
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

            // Escribimos linea a linea en el documento
			for (String linea : lineas) {
				try {
					out.write(linea + "\n");
				} catch (IOException ex) {
                    information = "\n-> ERROR: Se presento un inconveniente en la escritura";
				}
			}

            out.close();
            System.out.println("Se cerro con exito");
            information = "\n-> DATOS GUARDADOS CON EXITO";
        } catch (Exception e) {
            information = "\n-> ERROR: No se encontro el archivo";
        }

        return information;
    }
}
