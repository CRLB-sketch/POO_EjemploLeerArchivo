/**
 * <h1> EJEMPLO LECTURA DE ARCHIVOS CON JAVA </h1>
 * <h2> Programación Orientada a Objetos </h1>
 * 
 * <h3> Clase: [Controlador/Controller] </h3>
 * <p> Conecta la Vista y el Modelo (Principio Modelo Vista y Controlador [MVC]) </p>
 * 
 * @author Cristian Fernando Laynez Bachez - 201281
 * @since 26 - Agosto - 2021
 * @version 1.0
 * @category Ejemplo: Se puede utilizar como referencia libremente :)
 */

public class Controller {
    
    // Atributos <-----------------------------------------------------------------------------
    private SystemNotes sysNotes; // Modelo
    private View view; // Vista

    // Constructor <---------------------------------------------------------------------------
    public Controller(){
        sysNotes = new SystemNotes("docs/notasBiolo.csv");
        view = new View();
    }

    // Métodos <-------------------------------------------------------------------------------
    public void readFile(){
        if(sysNotes.getStateFile().equals("--> EXITO")){
            menu();
        }
        else{
            view.errorFile();
        }        
    }

    private void menu(){
        boolean finish = false;

        do {
            
            String option = view.menu(); // Mostrar menu y pedir opción a ejecutar

            // Depende de la opción llevar a cabo una operación específica
            switch (option) {

                // Ver datos del archivo - Para que vean que sí se leyo el archivo xd
                case "1":
                    view.showInformation(sysNotes.showAllNamesOfList());
                    break;

                // Verificar si el estudiante ingresado esta en el registro
                case "2":
                    String searchedName = view.askName();
                    view.showEstudentFound(sysNotes.verifyStudent(searchedName));
                    break;

                // Ver notas específicas de un estudiante
                case "3":
                    String identification = view.askIdentification();
                    String resultNotes = sysNotes.seeEspecificNotes(identification);
                    view.showInformation(resultNotes);
                    break;

                // Ver cantidad de aprobados y reprobados
                case "4":
                    view.showInformation(sysNotes.seeStudentsApproved());
                    break;

                // Terminar el programa
                case "5":
                    finish = true;
                    view.exit();
                    break;
            
                // Si la opción es inválida
                default:
                    view.invalid();
                    break;

            }
            
        } while (!finish); // Mientras finish sea falso el programa seguirá ejecutando
    }
    
}
