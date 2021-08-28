/*
// Librerias para leer el contenido del archivo
import java.io.BufferedReader;
import java.io.FileReader;
// Importar diccionario
import java.util.Dictionary;
import java.util.Hashtable;

public class SystemNotesAvanzed {
    // Atributos <-----------------------------------------------------------------------------    
    private Dictionary<String, DataStudent> data;
    private String stateFile = "";

    // Constructor <---------------------------------------------------------------------------
    public SystemNotesAvanzed(String nameFile){
        data = new Hashtable<String, DataStudent>(); // Inicializar diccionario        
        stateFile = readFileContent(nameFile); // Verificar si la información se leyo exitosamente
    }

    // Getter <--------------------------------------------------------------------------------
    public String getStateFile(){
        return stateFile;
    }

    // Métodos <-------------------------------------------------------------------------------
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
            System.out.println(temp);
            // Vamos a implementar los datos en el diccionario creado como atributo
            
            
            // Text se usará para confirmar los datos del archivo
            text = "--> EXITO";

        } catch (Exception e) {
            text = "--> ERROR";
        }

        return text;
    }
}
*/

/*
    public int getLab1() {
        return lab1;
    }

    public int getLab2() {
        return lab2;
    }

    public int getLab3() {
        return lab3;
    }

    public int getLab4() {
        return lab4;
    }

    public int getLab5() {
        return lab5;
    }

    public int getInvestigacion() {
        return investigacion;
    }

    public int getProyecto() {
        return proyecto;
    }

    public int getExamen1() {
        return examen1;
    }

    public int getExamen2() {
        return examen2;
    }
    */